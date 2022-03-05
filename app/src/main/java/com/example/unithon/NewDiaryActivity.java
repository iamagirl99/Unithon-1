package com.example.unithon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewDiaryActivity extends AppCompatActivity {

    private CoverAdapter coverAdapter = new CoverAdapter();
    private ArrayList<Integer> coverSrcList = DummyData.coverSrcList;

    private PaperStyleAdapter paperStyleAdapter = new PaperStyleAdapter();
    private ArrayList<Integer> paperStyleSrcList = DummyData.paperStyleSrcList;

    private EditText conditionOfMember = findViewById(R.id.conditionOfMember);
    private EditText decideDiaryName = findViewById(R.id.decideDiaryName);
    private EditText diaryPassword = findViewById(R.id.diaryPassword);
    private Button makeDiary = findViewById(R.id.makeDiary);

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

        makeDiary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }
}
