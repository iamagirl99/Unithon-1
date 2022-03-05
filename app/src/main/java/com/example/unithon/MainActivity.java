package com.example.unithon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.unithon.Home.CustomDialog;
import com.example.unithon.Home.EveryDiaryFragment;
import com.example.unithon.Home.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.ls.LSOutput;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    private ImageView imageView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_hamburger);
        toolbar = findViewById(R.id.tool_bar);
        drawerLayout = findViewById(R.id.layout_drawer);

        tabLayout=findViewById(R.id.layout_tabs);
        viewPager=findViewById(R.id.view_pager);
        adapter=new FragmentAdapter(getSupportFragmentManager(),1);

        //툴바 변경
        setSupportActionBar(toolbar);

        //햄버거 버튼 출력
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //매니저에 프레그먼트 추가
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new EveryDiaryFragment());

        //뷰페이저와 어댑터 연결
        viewPager.setAdapter(adapter);

        //탭과 뷰페이저 연결
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("My Diary");
        tabLayout.getTabAt(1).setText("All Diary");

        navigationView = findViewById(R.id.navigation);
        navigationView.setClickable(true);

        Button changeBtn, myDiaryBtn;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println(item);
                int id = item.getItemId();
                System.out.println(id);
                System.out.println(R.id.nav_change_MBTI);
                Log.d("@@@#@@", "!!!!!!");
                if (id == R.id.nav_change_MBTI) {
                    Log.e("$$$$$", "@@@@");
                    CustomDialog customDialog = new CustomDialog(getApplicationContext());
                    customDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                    customDialog.show();
                    return true;
                }

                return false;
            }

        });
//        navigationView.getMenu().findItem(R.id.nav_change_MBTI).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//
//                return true;
//            }
//        });
//
//        navigationView.getMenu().findItem(R.id.nav_my_diary).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                return false;
//            }
//        });
    }

//    private void setNavigationViewListener() {
//        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
//        navigationView.setNavigationItemSelectedListener(this);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}