package com.example.darshit.bvm;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Faculty_Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__login_);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Button login_faculty =findViewById(R.id.btn_faculty_login);

        login_faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Faculty_Login_Activity.this,Faculty_Activity.class);
                startActivity(intent);
            }
        });



    }
}
