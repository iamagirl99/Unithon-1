package com.example.unithon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewDiaryActivity extends AppCompatActivity {

    private CoverListAdapter coverListAdapter = new CoverListAdapter();
    private ArrayList<Integer> coverSrcList = DummyData.coverSrcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_diary);

        RecyclerView coverList = findViewById(R.id.coverList);
        coverList.setAdapter(coverListAdapter);
        coverListAdapter.submitList(coverSrcList);
    }
}
