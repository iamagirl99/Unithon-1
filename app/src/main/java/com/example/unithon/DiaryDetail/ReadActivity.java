package com.example.unithon.DiaryDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.unithon.DummyData;
import com.example.unithon.R;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Log.e("@@@@@@", "Ha...");

        Intent intent = getIntent();
        int order = intent.getIntExtra("order", -1);

        if (order == -1) {
            Log.e("READ ACTIVITY", "Intent error");
            return;
        }

        ViewPager2 viewPager2 = findViewById(R.id.page_view_pager);

        viewPager2.setPageTransformer(new PageCurlPageTransformer());

        DiaryViewPagerAdapter viewPagerAdapter = new DiaryViewPagerAdapter(this, DummyData.diaries.get(order).getPages());
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }

    public static class PageCurlPageTransformer implements ViewPager2.PageTransformer {

        @Override
        public void transformPage(View page, float position) {

//            Log.d(TAG, "transformPage, position = " + position + ", page = " + page.getTag(R.id.viewpager));
            if (page instanceof PageCurl) {
                if (position > -1.0F && position < 1.0F) {
                    // hold the page steady and let the views do the work
                    page.setTranslationX(-position * page.getWidth());
                } else {
                    page.setTranslationX(0.0F);
                }
                if (position <= 1.0F && position >= -1.0F) {
                    ((PageCurl) page).setCurlFactor(position);
                }
            }
        }
    }
}