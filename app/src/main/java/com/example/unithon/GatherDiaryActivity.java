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

        GridView gridView = findViewById(R.id.pages_grid_view);

        PagesGridAdapter gridAdapter = new PagesGridAdapter(pages);
        gridView.setAdapter(gridAdapter);
    }



}
