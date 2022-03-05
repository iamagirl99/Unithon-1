package com.example.unithon.Comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.Model;
import com.example.unithon.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Model.Comment> commentList;

    public void submitList(List<Model.Comment> commentList) {
        this.commentList = commentList;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public int getItemCount() {
        if (commentList == null) {
            return 0;
        }
        return commentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWriter, tvDate, tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWriter = (TextView) itemView.findViewById(R.id.item_tv_name);
            tvDate = (TextView) itemView.findViewById(R.id.item_tv_date);
            tvContent = (TextView) itemView.findViewById(R.id.item_tv_content);
        }

        void onBind(Model.Comment comment) {
            tvWriter.setText(comment.getWriter());
            tvDate.setText(comment.getDate());
            tvContent.setText(comment.getContent());

            System.out.println(comment.getWriter());
            System.out.println(comment.getDate());
            System.out.println(comment.getContent());
        }
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.onBind(commentList.get(position));
    }
}
