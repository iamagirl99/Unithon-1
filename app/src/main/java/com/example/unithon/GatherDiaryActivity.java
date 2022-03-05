package com.example.unithon;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GatherDiaryActivity extends AppCompatActivity {

    ArrayList<Model.Page> pages;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather_diary);

        // TODO 0번째 다이어리 가져오는 중
        init_diaries();
        pages = DummyData.diaries.get(0).getPages();
        init_pages();
        GridView gridView = findViewById(R.id.pages_grid_view);

        PagesGridAdapter gridAdapter = new PagesGridAdapter(pages);
        gridView.setAdapter(gridAdapter);
    }

    void init_pages() {
        for (int i = 0; i < 10; i++) {
            pages.add(new Model.Page());
        }
    }

    void init_diaries() {
        DummyData.diaries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DummyData.diaries.add(new Model.Diary());
        }
    }
}
