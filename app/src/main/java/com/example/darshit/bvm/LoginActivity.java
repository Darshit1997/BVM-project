package com.example.darshit.bvm;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView aboutus = (TextView) findViewById(R.id.txtview_aboutus);
        TextView contactus = (TextView) findViewById(R.id.txtview_contactus);


        Button faculty = (Button) findViewById(R.id.btn_faculty);
        Button student = (Button) findViewById(R.id.btn_student);





        aboutus.setPaintFlags(aboutus.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        contactus.setPaintFlags(contactus.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Faculty_Login_Activity.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Student_Login_Activity.class);
                startActivity(intent);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,About_Us.class);
                startActivity(intent);

            }
        });


    }
}
