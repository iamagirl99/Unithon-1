package com.example.unithon.Member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import static com.example.unithon.DummyData.diaries;
import android.content.Intent;
import android.os.Bundle;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {

    ArrayList<MemberData> dataList;
    ArrayList<Model.User> userList;
    Model.Diary diary;
    String owner;
    RecyclerView recyclerView;
    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        Intent intent = getIntent();
        int order = intent.getIntExtra("order");
        diary = diaries.get(order);
        owner = diary.getOwner_id();
        userList = diary.getMembers();

        for(int i = 0; i < userList.size(); i++){
            dataList.get(i).name = userList.get(i).getMbti();
            if(owner == userList.get(i).getId()){
                dataList.get(i).isManager = true;
            }
        }

        recyclerView = findViewById(R.id.member_recy);
        adapter = new MemberAdapter(MemberActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}