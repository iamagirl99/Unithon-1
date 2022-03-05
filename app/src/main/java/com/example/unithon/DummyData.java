package com.example.unithon;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<Model.Diary> diaries;

    public DummyData() {
        init_diaries();
        init_pages();
    }

    void init_diaries() {
        DummyData.diaries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Model.Diary diary = new Model.Diary();
            DummyData.diaries.add(diary);
        }
    }

    void init_pages() {
        for (Model.Diary diary : diaries) {
            diary.pages = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                diary.pages.add(new Model.Page());
            }
        }

    }
}
