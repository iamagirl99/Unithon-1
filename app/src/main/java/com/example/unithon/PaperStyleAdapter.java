package com.example.unithon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaperStyleAdapter extends RecyclerView.Adapter<PaperStyleAdapter.ViewHolder> {
    private ArrayList<Integer> paperStyleSrcList;

    public void submitList(ArrayList<Integer> paperStyleSrcList) {
        this.paperStyleSrcList = paperStyleSrcList;
        notifyDataSetChanged();
    }

    public PaperStyleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_option, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(paperStyleSrcList.get(position));
    }

    public int getItemCount() {
        return paperStyleSrcList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton cover;

        public ViewHolder(View itemView) {
            super(itemView);

            cover = (ImageButton) itemView.findViewById(R.id.styleOption);
        }

        void onBind(Integer src) {
            cover.setImageResource(src);

            System.out.println(src);
        }
    }
}
