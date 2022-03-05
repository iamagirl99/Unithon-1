package com.example.unithon.Member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.unithon.R;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {

    ArrayList<MemberData> dataList;
    RecyclerView recyclerView;
    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        recyclerView = findViewById(R.id.member_recy);
        adapter = new MemberAdapter(MemberActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}