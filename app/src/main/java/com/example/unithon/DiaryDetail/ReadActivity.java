package com.example.unithon.DiaryDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.unithon.DummyData;
import com.example.unithon.R;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Intent intent = new Intent();
        int order = intent.getIntExtra("order", -1);

        if (order == -1) {
            Log.d("READ ACTIVITY", "Intent error");
            return;
        }

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        DiaryViewPagerAdapter viewPagerAdapter = new DiaryViewPagerAdapter(this, DummyData.diaries.get(order).getPages());
    }
}