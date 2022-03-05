package com.example.unithon.Comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {
    CommentAdapter commentAdapter;
    RecyclerView rcvComment;
    ArrayList<Model.Comment> commentArrayList = DummyComment.dummyCommentList;
    ImageButton imgv_comment;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        imgv_comment = (ImageButton) findViewById(R.id.imgb_add_comment);
        editText = (EditText) findViewById(R.id.edt_comment);

        Intent intent = getIntent();
        int diary_num = intent.getIntExtra("diary_num", -1);
        int page_num = intent.getIntExtra("page_num", -1);

        rcvComment = findViewById(R.id.comment_rcv);
        commentAdapter = new CommentAdapter();
        rcvComment.setAdapter(commentAdapter);
        commentAdapter.submitList(commentArrayList);

        imgv_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentArrayList.add(new Model.Comment("ENFP", "2022.03.06 1: 54", editText.getText().toString()));
                editText.setText("");
            }
        });
    }
}