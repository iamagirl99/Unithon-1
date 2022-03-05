package com.example.unithon;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoverAdapter extends RecyclerView.Adapter<CoverAdapter.ViewHolder> {
    private ArrayList<Integer> coverSrcList;

    public void submitList(ArrayList<Integer> coverSrcList) {
        this.coverSrcList = coverSrcList;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_option, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(coverSrcList.get(position));

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    public int getItemCount() {
        return coverSrcList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton cover;

        public ViewHolder(View itemView) {
            super(itemView);

            cover = (ImageButton) itemView.findViewById(R.id.styleOption);
        }

        void onBind(Integer src) {
            cover.setImageResource(src);

            cover.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView image = (ImageView) view;

                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        image.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        image.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                    }

                    return true;
                }
            });
        }
    }
}
