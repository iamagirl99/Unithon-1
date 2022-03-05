package com.example.unithon;

import static com.example.unithon.DummyData.currentUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.unithon.Member.MemberActivity;

public class DiaryActivity extends AppCompatActivity {

    TextView memberTv, turnTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        Intent intent = getIntent();
        int diary_num = intent.getIntExtra("diary_num", -1);
        boolean is_mine = intent.getBooleanExtra("my_diary", false);

        memberTv = findViewById(R.id.memberTv);
        turnTv = findViewById(R.id.turnTv);

        Model.Diary diary;
        if (is_mine) {
            diary = currentUser.getDiaries().get(diary_num).getDiary();
        } else {
            diary = DummyData.diaries.get(diary_num);
        }

        memberTv.setText("참여한 참가자 수 : " + diary.getMembers().size());

        memberTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryActivity.this, MemberActivity.class);
                //TODO: 인텐트에 추가할 정보 있으면 추가하기
                startActivity(intent);
            }
        });

    }
}