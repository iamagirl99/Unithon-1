package com.example.unithon;

import static com.example.unithon.DummyData.currentUser;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BookmarkedPagesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather_diary);

        Intent intent = getIntent();
        int diary_num = intent.getIntExtra("diary_num", -1);

        Model.CustomDiary diary = currentUser.getDiaries().get(diary_num);

        GridView gridView = findViewById(R.id.pages_grid_view);

        if (diary == null) {
            return;
        }

        PagesGridAdapter gridAdapter = new PagesGridAdapter(diary.getBookmarks(), diary_num);
        gridView.setAdapter(gridAdapter);
    }
}
