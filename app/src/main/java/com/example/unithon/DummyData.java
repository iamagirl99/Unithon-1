package com.example.unithon;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<Model.Diary> diaries;
    public static ArrayList<Integer> coverSrcList  = new ArrayList<Integer>() {
        {
            add(new Integer(R.drawable.cover_test));
            add(new Integer(R.drawable.cover_test2));
            add(new Integer(R.drawable.cover_test3));
        }
    };

    public DummyData() {
        init_diaries();
        init_pages();
    }

    void init_diaries() {
        DummyData.diaries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Model.Diary diary = new Model.Diary();
            diary.pages = new ArrayList<>();
            DummyData.diaries.add(diary);
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
