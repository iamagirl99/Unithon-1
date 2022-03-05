package com.example.unithon.Home;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.ArrayList;
import java.util.List;

public class EveryDiaryAdapter extends RecyclerView.Adapter<EveryDiaryAdapter.ViewHolder> implements Filterable {
    private List<Model.Diary> diaryList;
    private List<Model.Diary> filteredDiaryList;

    public void submitList(List<Model.Diary> diaryList) {
        this.diaryList = diaryList;
        this.filteredDiaryList = diaryList;
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

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredDiaryList = diaryList;
                } else {
                    ArrayList<Model.Diary> filteringList = new ArrayList<>();
                    for (Model.Diary data : diaryList) {
                        if (data.getName().contains(charString)) {
                            filteringList.add(data);
                        }
                    }
                    filteredDiaryList = filteringList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredDiaryList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredDiaryList = (ArrayList<Model.Diary>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
