package com.example.unithon.DiaryDetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;

public class DiaryViewPagerAdapter extends RecyclerView.Adapter<DiaryViewPagerAdapter.ViewHolder> {

    ArrayList<Model.Page> pages;
    Context context;

    public DiaryViewPagerAdapter(Context context, ArrayList<Model.Page> pages) {
        this.context = context;
        this.pages = pages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.diary_image, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model.Page page = pages.get(position);
        holder.imageView.setImageResource(R.drawable.diary);
        holder.imageView.setBackgroundColor(R.color.black);
//        holder.imageView.setImageResource(context.getResources().getIdentifier(page.getImage(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        Log.d("######", pages.size() + "" );
        return pages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cover_image);
        }
    }

}
