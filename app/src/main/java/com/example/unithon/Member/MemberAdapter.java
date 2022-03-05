package com.example.unithon.Member;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unithon.R;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.Holder>{

    private Context context;
    private ArrayList<MemberData> dataList;

    public MemberAdapter(Context context,ArrayList<MemberData> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public static class Holder extends RecyclerView.ViewHolder{

        //protected ConstraintLayout member_cell;
        protected TextView member_name;
        protected ImageView duck;
        protected Button delete_button;

        public Holder(View view){
            super(view);
            //this.member_cell = view.findViewById(R.id.member_cell);
            this.member_name = view.findViewById(R.id.member_name);
            this.duck = view.findViewById(R.id.duck);
            this.delete_button = view.findViewById(R.id.delete_button);
        }

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_member_cell, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.member_name.setText(dataList.get(position).name);
        if(!dataList.get(position).isManager){
            holder.duck.setVisibility(View.GONE);
        }
        holder.delete_button.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        if(dataList == null){
            return 0;
        }
        else{
            return dataList.size();
        }
    }

}
