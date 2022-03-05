package com.example.unithon.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.unithon.DummyData;
import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        init_diaries();
        gridView = rootView.findViewById(R.id.gridView);
        HomeGridAdapter gridAdapter = new HomeGridAdapter(DummyData.diaries);
        gridView.setAdapter(gridAdapter);

        return rootView;
    }

    void init_diaries() {
        DummyData.diaries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DummyData.diaries.add(new Model.Diary());
        }
    }
}
