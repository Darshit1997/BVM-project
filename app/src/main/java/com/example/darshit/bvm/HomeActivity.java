package com.example.darshit.bvm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class HomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LoginIntent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}