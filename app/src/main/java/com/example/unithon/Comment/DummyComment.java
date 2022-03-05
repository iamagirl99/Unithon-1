package com.example.unithon.Comment;

import com.example.unithon.Model;

import java.util.ArrayList;

public class DummyComment {
    public static ArrayList<Model.Comment> dummyCommentList = new ArrayList<Model.Comment>() {
        {
            add(new Model.Comment("ENFP", "2022.03.05 12:17", "hi"));
            add(new Model.Comment("ISTJ", "2022.03.05 15:09", "hello"));
            add(new Model.Comment("INFP", "2022.03.05 13:28", "bye"));
            add(new Model.Comment("ESTJ", "2022.03.05 15: 58", "oh"));
        }
    };
}
