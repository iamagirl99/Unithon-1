package com.example.unithon.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class HomeGridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Model.Diary> diaries;
    public HomeGridAdapter(ArrayList<Model.Diary> diaries) {
        this.diaries = diaries;
    }
    @Override
    public int getCount() {
        return diaries.size();
    }

    @Override
    public Object getItem(int i) {
        return diaries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        Model.Diary diary = diaries.get(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.summary_diary, viewGroup, false);
        }

        TextView diaryNameTv = view.findViewById(R.id.diary_name);
        diaryNameTv.setText(diary.getName());

        return view;
    }
}
