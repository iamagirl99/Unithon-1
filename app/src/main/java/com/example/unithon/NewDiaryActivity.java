package com.example.unithon;

import static com.example.unithon.DummyData.currentUser;
import static com.example.unithon.DummyData.diaries;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.DiaryDetail.ReadActivity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("deprecation")
public class NewDiaryActivity extends AppCompatActivity {

    private CoverAdapter coverAdapter = new CoverAdapter();
    private ArrayList<Integer> coverSrcList = DummyData.coverSrcList;

    private PaperStyleAdapter paperStyleAdapter = new PaperStyleAdapter();
    private ArrayList<Integer> paperStyleSrcList = DummyData.paperStyleSrcList;

    private int id_view;
    private Uri mImageCaptureUri;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;
    private String absolutePath_cover = "";

    private Bitmap photo;
    private String name;
    private String password;
    private String image;

    EditText conditionOfMember;
    EditText decideDiaryName;
    EditText diaryPassword;
    Button makeDiary;
    ImageView addCover;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("n1 ---> " + currentUser);

        setContentView(R.layout.new_diary);

        conditionOfMember = findViewById(R.id.conditionOfMember);
        decideDiaryName = findViewById(R.id.decideDiaryName);
        diaryPassword = findViewById(R.id.diaryPassword);
        makeDiary = findViewById(R.id.makeDiary);
        addCover = findViewById(R.id.addCover);
        RecyclerView coverList = findViewById(R.id.coverList);
        coverList.setAdapter(coverAdapter);
        coverAdapter.submitList(coverSrcList);


        paperStyleAdapter.submitList(paperStyleSrcList);

        addCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_view = R.id.addCover;
                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                doTakeAlbumAction();
                            }
                        };

                        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        };

                        new AlertDialog.Builder(NewDiaryActivity.this)
                                .setTitle("업로드 할 이미지 선택")
                                .setPositiveButton("앨범선택", albumListener)
                                .setNegativeButton("취소", cancelListener)
                                .show();
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(NewDiaryActivity.this, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();

                    }

                };

                TedPermission.with(getApplicationContext())
                        .setPermissionListener(permissionlistener)
                        .setRationaleMessage("내부 저장소 및 카메라 권한이 필요합니다. ")
                        .setDeniedMessage("[설정] > [권한] 에서 권한을 허용할 수 있습니다.")
                        .setPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA})
                        .check();

            }
        });

        makeDiary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("n2 ---> " + currentUser);
                name = decideDiaryName.getText().toString();
                password = diaryPassword.getText().toString();
                if (absolutePath_cover.length() != 0) {
                    Bitmap bitmap = BitmapFactory.decodeFile(absolutePath_cover);
                    image = BitmapToString(bitmap);
                }
                String hashtag = conditionOfMember.getText().toString();

                Model.Diary diary = new Model.Diary(name, "Me", image, hashtag, password);
                diaries.add(diary);
                currentUser.getDiaries().add(new Model.CustomDiary(diary));

                Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                intent.putExtra("diary_num", currentUser.getDiaries().size() - 1);
                intent.putExtra("my_diary", true);
                startActivity(intent);
            }
        });



    }

    public void doTakeAlbumAction() {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case PICK_FROM_ALBUM: {
                mImageCaptureUri = data.getData();
                Log.d("StoryForMe", mImageCaptureUri.getPath().toString());
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 200);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_IMAGE);
                break;
            }

            case CROP_FROM_IMAGE: {
                if (resultCode != RESULT_OK) {
                    return;
                }

                final Bundle extras = data.getExtras();
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/BamBooDiary/" + System.currentTimeMillis() + ".jpg";

                if (extras != null) {
                    photo = extras.getParcelable("data"); // CROP된 BITMAP
                    addCover.setImageBitmap(photo); // 레이아웃의 이미지칸에 CROP된 BITMAP을 보여줌

                    storeCropImage(photo, filePath); // CROP된 이미지를 외부저장소, 앨범에 저장한다.
                    absolutePath_cover = filePath;
                    break;
                }

                File f = new File(mImageCaptureUri.getPath());
                if (f.exists()) {
                    f.delete();
                }
            }
        }

    }

    private void storeCropImage(Bitmap bitmap, String filePath) {

        try {

            String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/StoryForMe";

            File directory_StoryForMe = new File(dirPath);

            if (directory_StoryForMe.mkdirs())

                Log.e("real path", directory_StoryForMe.getAbsolutePath());

            File copyFile = new File(filePath);
            BufferedOutputStream out = null;

            copyFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(copyFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("path error", e.getMessage());
        }
    }

    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /*
     * Bitmap을 String형으로 변환
     * */
    public static String BitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos);
        byte[] bytes = baos.toByteArray();
        String temp = Base64.encodeToString(bytes, Base64.DEFAULT);
        return temp;
    }
}
