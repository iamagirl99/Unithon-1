package com.example.unithon.Home;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.List;

public class EveryDiaryAdapter extends RecyclerView.Adapter<EveryDiaryAdapter.ViewHolder> {
    private List<Model.Diary> diaryList;

    public void submitList(List<Model.Diary> diaryList) {
        this.diaryList = diaryList;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_summary_diary, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public int getItemCount() {
        if (diaryList == null) {
            return 0;
        }
        return diaryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTags;
        ImageView imgvCover;

        public ViewHolder(View itemView) {
            super(itemView);
            imgvCover = (ImageView) itemView.findViewById(R.id.all_item_imgv_cover);
            tvName = (TextView) itemView.findViewById(R.id.all_item_tv_name);
            tvTags = (TextView) itemView.findViewById(R.id.all_item_tv_tags);
        }

        void onBind(Model.Diary diary) {
            tvName.setText(diary.getName());
            tvTags.setText(diary.getTags());
        }
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.onBind(diaryList.get(position));
    }
}
