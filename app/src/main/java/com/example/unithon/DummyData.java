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

    public static ArrayList<Integer> paperStyleSrcList = new ArrayList<Integer>() {
        {
            add(new Integer(R.drawable.cover_test));
            add(new Integer(R.drawable.cover_test2));
            add(new Integer(R.drawable.cover_test3));
        }
    };

}
