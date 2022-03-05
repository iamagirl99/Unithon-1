package com.example.unithon;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewDiaryActivity extends AppCompatActivity {

    private CoverAdapter coverAdapter = new CoverAdapter();
    private ArrayList<Integer> coverSrcList = DummyData.coverSrcList;

    private PaperStyleAdapter paperStyleAdapter = new PaperStyleAdapter();
    private ArrayList<Integer> paperStyleSrcList = DummyData.paperStyleSrcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_diary);

        RecyclerView coverList = findViewById(R.id.coverList);
        coverList.setAdapter(coverAdapter);
        coverAdapter.submitList(coverSrcList);

        RecyclerView paperStyleList = findViewById(R.id.paperStyleList);
        paperStyleList.setAdapter(paperStyleAdapter);
        paperStyleAdapter.submitList(paperStyleSrcList);
    }
}
