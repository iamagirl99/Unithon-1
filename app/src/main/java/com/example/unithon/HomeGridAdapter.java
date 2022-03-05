package com.example.unithon;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class HomeGridAdapter extends BaseAdapter {

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
        return null;
    }
}
