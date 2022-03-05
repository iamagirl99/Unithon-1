package com.example.unithon;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static final int MAX_MEMBER = 7;
    public static Model.User currentUser;
    public static ArrayList<Model.Diary> diaries;
    public static ArrayList<Integer> coverSrcList = new ArrayList<Integer>() {
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
        Model.Diary my_diary = new Model.Diary("Jiwon's Diary", currentUser.id, currentUser.id, "");
        Model.CustomDiary diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);

        my_diary = new Model.Diary("Come on, ESTP", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);

        my_diary = new Model.Diary("ISFJ, Hello world", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);

        my_diary = new Model.Diary("A to Z", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);


        my_diary = new Model.Diary("ENFP girls~", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);

        my_diary = new Model.Diary("Allice in Wonderland", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);
        my_diary = new Model.Diary("Let's ISTJ", currentUser.id, currentUser.id, "");
        diary = new Model.CustomDiary(my_diary);
        currentUser.diaries.add(diary);

    }

    void init_my_pages() {
        for (Model.CustomDiary diary : currentUser.diaries) {
            for (int i = 0; i < 10; i++) {
                diary.diary.pages.add(new Model.Page());
            }
        }
    }

    void init_diaries() {
        Model.Diary diary = new Model.Diary("ESFJ 모여라", "Other", "Other", "#심심해 #활발");
        diaries.add(diary);

        diary = new Model.Diary("Let's ENFP!!", "Other", "Other", "#ENFP #모여라");
        diaries.add(diary);

        diary = new Model.Diary("Hello ISTP~", "Other", "Other", "#고민상담 #ISTP");
        diaries.add(diary);

        diary = new Model.Diary("Everyone's ESFJ", "Other", "Other", "#다들들어와 #활발");
        diaries.add(diary);

        diary = new Model.Diary("EOS's MBTI", "Other", "Other", "#EOS #모여라 #앱개발");
        diaries.add(diary);

        diary = new Model.Diary("Our story", "Other", "Other", "#심심한 #사람들 #모여라");
        diaries.add(diary);

        diary = new Model.Diary("MBTI gathering", "Other", "Other", "#MBTI #과몰입자 #여기있다");
        diaries.add(diary);

        diary = new Model.Diary("Little I's world", "Other", "Other", "#I모여라 #내향형");
        diaries.add(diary);
        diary = new Model.Diary("Merry Christmas", "Other", "Other", "#솔크 #여기붙어");
        diaries.add(diary);
        diary = new Model.Diary("First snow", "Other", "Other", "#첫눈 #MBTI");
        diaries.add(diary);
        diary = new Model.Diary("Seven Dwalfes", "Other", "Other", "#백설공주 #MBTI");
        diaries.add(diary);

        diary = new Model.Diary("ISTP boys~!", "Other", "Other", "#ISTP #이리와");
        diaries.add(diary);

        diary = new Model.Diary("test diary", "Other", "Other", "");
        diaries.add(diary);

        diary = new Model.Diary("test diary", "Other", "Other", "");
        diaries.add(diary);

        diary = new Model.Diary("test diary", "Other", "Other", "");
        diaries.add(diary);
    }

    void init_pages() {
        for (Model.Diary diary : diaries) {
            for (int i = 0; i < 10; i++) {
                diary.pages.add(new Model.Page());
            }
        }
    }
}
