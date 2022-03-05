package com.example.unithon.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.Comment.CommentAdapter;
import com.example.unithon.DummyData;
import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class EveryDiaryFragment extends Fragment {
    EveryDiaryAdapter diaryAdapter;
    RecyclerView rcvDiaries;
    ArrayList<Model.Diary> diaryArrayList = DummyData.diaries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_others, container, false);

        System.out.println("here " + diaryArrayList);

        rcvDiaries = rootView.findViewById(R.id.others_rcv);
        diaryAdapter = new EveryDiaryAdapter();
        rcvDiaries.setAdapter(diaryAdapter);
        diaryAdapter.submitList(diaryArrayList);

        return rootView;
    }
}
