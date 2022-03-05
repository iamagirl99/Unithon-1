package com.example.unithon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unithon.Home.HomeFragment;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Button loginButton = findViewById(R.id.loginButton);
        ImageButton kakaoLoginButton = findViewById(R.id.kakaoLoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
                startActivity(intent);
            }
        });
    }
}
