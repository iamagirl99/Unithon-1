package com.example.unithon;

import static com.example.unithon.DummyData.currentUser;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PagesGridAdapter extends BaseAdapter {

    int diaryNum = 0;
    Context context;
    ArrayList<Model.Page> pages;
    Model.Diary diary;

    public PagesGridAdapter(ArrayList<Model.Page> pages, int diaryNum) {
        this.pages = pages;
        diary = currentUser.getDiaries().get(diaryNum).getDiary();
        this.diaryNum = diaryNum;
    }
    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public Object getItem(int i) {
        return pages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        Model.Page page = pages.get(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_page, viewGroup, false);
        }

        ImageView pageImageView = view.findViewById(R.id.page_image_view);
        ImageButton imageButton = view.findViewById(R.id.bookmark);
        pageImageView.setImageResource(context.getResources().getIdentifier(page.image, "drawable", context.getPackageName()));

//        imageButton.setColorFilter(R.color.red, PorterDuff.Mode.SRC_ATOP);
//        imageButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFF0000")));/
        if (currentUser.diaries.get(diaryNum).getBookmarks().contains(i)) {
            imageButton.setImageResource(R.drawable.ic_baseline_bookmark_pressed_24);
        } else {
            imageButton.setImageResource(R.drawable.ic_baseline_bookmark_24);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> bookmarks = currentUser.diaries.get(diaryNum).getBookmarks();
                if (bookmarks.contains(i)) {
                    bookmarks.remove(bookmarks.indexOf(i));
                    imageButton.setImageResource(R.drawable.ic_baseline_bookmark_24);
                } else {
                    bookmarks.add(i);
                    imageButton.setImageResource(R.drawable.ic_baseline_bookmark_pressed_24);
                }
            }
        });

        return view;
    }
}
