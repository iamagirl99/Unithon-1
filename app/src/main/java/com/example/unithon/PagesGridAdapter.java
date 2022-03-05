package com.example.unithon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PagesGridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Model.Page> pages;
    public PagesGridAdapter(ArrayList<Model.Page> pages) {
        this.pages = pages;
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
//        pageImageView.setImageDrawable(context.getResources().getIdentifier(page.image, "drawable", context.getPackageName()));

        return view;
    }
}
