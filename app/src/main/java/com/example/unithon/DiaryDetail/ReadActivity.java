package com.example.unithon.DiaryDetail;

import static com.example.unithon.DummyData.currentUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.unithon.BookmarkedPagesActivity;
import com.example.unithon.Comment.CommentActivity;
import com.example.unithon.DummyData;
import com.example.unithon.GatherDiaryActivity;
import com.example.unithon.Model;
import com.example.unithon.R;

public class ReadActivity extends AppCompatActivity {

    ImageButton comment_btn;
    ImageButton bookmark_btn;
    ImageButton gather_diary_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        comment_btn = findViewById(R.id.comment_btn);
        bookmark_btn = findViewById(R.id.bookmark_btn);
        gather_diary_btn = findViewById(R.id.gather_diary_btn);
        Log.e("@@@@@@", "Ha...");

        Intent intent = getIntent();
        int diary_num = intent.getIntExtra("diary_num", -1);

        if (diary_num == -1) {
            Log.e("READ ACTIVITY", "Intent error");
            return;
        }

        ViewPager2 viewPager2 = findViewById(R.id.page_view_pager);

        viewPager2.setPageTransformer(new PageCurlPageTransformer());

        DiaryViewPagerAdapter viewPagerAdapter = new DiaryViewPagerAdapter(this, DummyData.diaries.get(diary_num).getPages());
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setCurrentItem(DummyData.diaries.get(diary_num).getPages().size()-1, true);
        comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
                intent.putExtra("diary_num", diary_num);
                intent.putExtra("page_num", viewPager2.getCurrentItem());
                startActivity(intent);
            }
        });

        bookmark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : 넘겨준 책 번호와 북마크한 페이지 번호 더미데이터에 추가.
                Intent intent = new Intent(getApplicationContext(), BookmarkedPagesActivity.class);
                intent.putExtra("diary_num", diary_num);
                startActivity(intent);
            }
        });

        gather_diary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GatherDiaryActivity.class);
                intent.putExtra("diary_num", diary_num);
                startActivity(intent);
            }
        });
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