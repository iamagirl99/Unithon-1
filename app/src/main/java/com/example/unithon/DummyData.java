package com.example.unithon;

import java.util.ArrayList;

public class DummyData {
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
            Model.CustomDiary diary = new Model.CustomDiary();
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
            Model.Diary diary = new Model.Diary();
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
