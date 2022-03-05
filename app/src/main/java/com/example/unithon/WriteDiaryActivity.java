package com.example.unithon;

import static com.example.unithon.DummyData.diaries;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class WriteDiaryActivity extends AppCompatActivity {
    Button btPick;
    ImageView imageView;
    //ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);

        btPick = findViewById(R.id.bt_pick);
        imageView = findViewById(R.id.image_view);

//        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//            if(result.getResultCode() == 100){
//
//            }
//        })

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(WriteDiaryActivity.this, "권한 허가", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(WriteDiaryActivity.this, "권한 거부", Toast.LENGTH_SHORT).show();
            }
        };


        btPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TedPermission.with(getApplicationContext())
                        .setPermissionListener(permissionListener)
                        .setRationaleMessage("다이어리를 작성하기 위해서 권한 허가가 필요해요")
                        .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.INTERNET)
                        .check();

                checkPermission();
            }
        });
    }

    private void checkPermission(){
        int permission = ActivityCompat.checkSelfPermission(WriteDiaryActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            pickImage();
        }
        else{
            if(permission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(WriteDiaryActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
            else{
                pickImage();
            }
        }
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //startActivityForResult deprecated 됨.
        startActivityForResult(intent, 100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 100 && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            pickImage();
        }
        else{
            Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri uri = data.getData();
            switch (requestCode){
                case 100:
                    Intent intent = new Intent(WriteDiaryActivity.this, DsPhotoEditorActivity.class);
                    intent.setData(uri);
                    intent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "Images");
                    intent.putExtra(DsPhotoEditorConstants.DS_TOOL_BAR_BACKGROUND_COLOR, Color.parseColor("#BD69FF"));
                    intent.putExtra(DsPhotoEditorConstants.DS_MAIN_BACKGROUND_COLOR, Color.parseColor("#EBCFFC"));
                    intent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, new int[]{DsPhotoEditorActivity.TOOL_WARMTH, DsPhotoEditorActivity.TOOL_PIXELATE});
                    startActivityForResult(intent, 101);
                    break;

                case 101:
                    imageView.setImageURI(uri);
                    //여기서부터 받는 코드
                    String new_page = uri.toString();
                    Intent income_intent = getIntent();
                    //int order = income_intent.getIntExtra("order");
                    Model.Page np = new Model.Page();
                    np.image = new_page;
                    //diaries.get(order).pages.add(np);
                    Toast.makeText(getApplicationContext(), "photo saved", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}