package com.example.darshit.bvm;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Home_Page extends main_drawer  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);


        Toolbar toolbar =  (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        Button login = (Button) findViewById(R.id.btn_login);
        Button aboutus = (Button) findViewById(R.id.about_us);
        Button courses = (Button) findViewById(R.id.courses);
        Button map = (Button) findViewById(R.id.map);
        Button fpage1 = (Button) findViewById(R.id.faculty);
        Button mag = (Button) findViewById(R.id.magazine);
        Button placement = (Button) findViewById(R.id.placement);
        Button contactus = (Button) findViewById(R.id.contactus);
        Button gallery = (Button) findViewById(R.id.gallery);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,aboutus_homepage.class);
                startActivity(intent);

            }
        });

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Course_Page1.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Map_Bvm.class);
                startActivity(intent);
            }
        });


        fpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Faculty_Guestpage1.class);
                startActivity(intent);
            }
        });


        mag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Mag_Page1.class);
                startActivity(intent);
            }
        });


        placement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Placement_Page1.class);
                startActivity(intent);
            }
        });


        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Contact_Us_Page1.class);
                startActivity(intent);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Page.this,Gallery_Page1.class);
                startActivity(intent);
            }
        });








    }
}
