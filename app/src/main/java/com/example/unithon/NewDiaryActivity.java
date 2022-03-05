package com.example.unithon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewDiaryActivity extends AppCompatActivity {

    private CoverListAdapter coverListAdapter = new CoverListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_diary);

        RecyclerView coverList = findViewById(R.id.coverList);
    }

    public class CoverListAdapter extends RecyclerView.Adapter<CoverListAdapter.ViewHolder> {

        public CoverListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(view);
        }

        public void onBindViewHolder(@NonNull CoverListAdapter.ViewHolder holder, int position) {
            holder.onBind(coverUrlList.get(position));
        }

        public int getItemCount() {
            return coverUrlList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageButton cover;

            public ViewHolder(View itemView) {
                super(itemView);

                cover = itemView.findViewById(R.id.offeredCover);
            }

            void onBind(String url) {
                cover.setImageResource(test);
            }
        }
    }
}
