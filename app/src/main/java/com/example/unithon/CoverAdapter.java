package com.example.unithon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoverListAdapter extends RecyclerView.Adapter<CoverListAdapter.ViewHolder> {
    private ArrayList<Integer> coverSrcList;

    public void submitList(ArrayList<Integer> coverSrcList) {
        this.coverSrcList = coverSrcList;
        notifyDataSetChanged();
    }

    public CoverListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offered_cover, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(coverSrcList.get(position));
    }

    public int getItemCount() {
        return coverSrcList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton cover;

        public ViewHolder(View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.offeredCover);
        }

        void onBind(Integer src) {
            cover.setImageResource(src);
        }
    }
}
