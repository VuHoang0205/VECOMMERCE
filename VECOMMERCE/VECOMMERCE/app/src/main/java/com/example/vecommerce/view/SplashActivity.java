package com.example.vecommerce.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vecommerce.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    @Override
    public void onBackPressed() {
        if (isFinishing()) {
            return;
        }
        super.onBackPressed();

    }
}
