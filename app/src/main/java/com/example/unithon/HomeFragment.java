package com.example.unithon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    GridView gridView;
    ArrayList<Model.Diary> dummy_diaries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        init_diaries();
        gridView = rootView.findViewById(R.id.gridView);
        HomeGridAdapter gridAdapter = new HomeGridAdapter(dummy_diaries);
        gridView.setAdapter(gridAdapter);

        return rootView;
    }

    void init_diaries() {
        dummy_diaries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dummy_diaries.add(new Model.Diary());
        }
    }
}
