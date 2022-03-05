package com.example.unithon.Comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {
    CommentAdapter commentAdapter;
    RecyclerView rcvComment;
    ArrayList<Model.Comment> commentArrayList = DummyComment.dummyCommentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("herehererrehrehre " + commentArrayList);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        rcvComment = findViewById(R.id.comment_rcv);
        commentAdapter = new CommentAdapter();
        rcvComment.setAdapter(commentAdapter);
        commentAdapter.submitList(commentArrayList);
    }
}