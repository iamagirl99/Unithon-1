package com.example.unithon;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static final int MAX_MEMBER = 7;
    public static Model.User currentUser;
    public static ArrayList<Model.Diary> diaries;
    public static ArrayList<Integer> coverSrcList  = new ArrayList<Integer>() {
        {
            add(new Integer(R.drawable.cover_test));
            add(new Integer(R.drawable.cover_test2));
            add(new Integer(R.drawable.cover_test3));
        }
    };

    public static ArrayList<Integer> paperStyleSrcList = new ArrayList<Integer>() {
        {
            add(new Integer(R.drawable.cover_test));
            add(new Integer(R.drawable.cover_test2));
            add(new Integer(R.drawable.cover_test3));
        }
    };

    public DummyData() {
        currentUser = new Model.User();
        init_my_diaries();
        init_my_pages();
        diaries = new ArrayList<>();
        init_diaries();
        init_pages();
    }

    void init_my_diaries() {
        for (int i = 0; i < 10; i++) {
            Model.Diary my_diary = new Model.Diary("My Diary", currentUser.id, currentUser.id);
            Model.CustomDiary diary = new Model.CustomDiary(my_diary);
            currentUser.diaries.add(diary);
        }
    }

    void init_my_pages() {
        for (Model.CustomDiary diary : currentUser.diaries) {
            for (int i = 0; i < 10; i++) {
                diary.diary.pages.add(new Model.Page());
            }
        }
    }

    void init_diaries() {
        for (int i = 0; i < 10; i++) {
            Model.Diary diary = new Model.Diary("test diary", "Other", "Other");
            diaries.add(diary);
        }
    }

    void init_pages() {
        for (Model.Diary diary : diaries) {
            for (int i = 0; i < 10; i++) {
                diary.pages.add(new Model.Page());
            }
        }
    }
}
