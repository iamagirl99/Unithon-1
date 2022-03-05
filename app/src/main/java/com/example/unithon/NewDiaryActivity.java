package com.example.unithon;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class NewDiaryActivity extends AppCompatActivity {
    private static final int PICK_FROM_ALBUM = 1;

    private CoverAdapter coverAdapter = new CoverAdapter();
    private ArrayList<Integer> coverSrcList = DummyData.coverSrcList;

    private PaperStyleAdapter paperStyleAdapter = new PaperStyleAdapter();
    private ArrayList<Integer> paperStyleSrcList = DummyData.paperStyleSrcList;

    private EditText conditionOfMember = findViewById(R.id.conditionOfMember);
    private EditText decideDiaryName = findViewById(R.id.decideDiaryName);
    private EditText diaryPassword = findViewById(R.id.diaryPassword);
    private Button makeDiary = findViewById(R.id.makeDiary);
    private Button addCover = findViewById(R.id.addCover);
    private Button addTemplate = findViewById(R.id.addTemplate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_diary);

        tedPermission();

        RecyclerView coverList = findViewById(R.id.coverList);
        coverList.setAdapter(coverAdapter);
        coverAdapter.submitList(coverSrcList);

        RecyclerView paperStyleList = findViewById(R.id.paperStyleList);
        paperStyleList.setAdapter(paperStyleAdapter);
        paperStyleAdapter.submitList(paperStyleSrcList);

        addCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        makeDiary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String condition = conditionOfMember.getText().toString();
                ArrayList<String> hashtag = (ArrayList<String>) Arrays.asList(condition.split(" "));

                String name = decideDiaryName.getText().toString();

                String password = diaryPassword.getText().toString();


            }
        });
    }

    private void tedPermission() {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_ALBUM) {

            Uri photoUri = data.getData();

            Cursor cursor = null;

            try {

                /*
                 *  Uri 스키마를
                 *  content:/// 에서 file:/// 로  변경한다.
                 */
                String[] proj = {MediaStore.Images.Media.DATA};

                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

}
