package com.example.darshit.bvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Faculty_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_);

        Button faculty_attendence = (Button) findViewById(R.id.btn_fac_attendence);
        Button msg = (Button) findViewById(R.id.button5);

        faculty_attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Faculty_Activity.this,Attendence_Page1.class);
                startActivity(intent);
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Faculty_Activity.this,MsgPage1.class);
                startActivity(intent);
            }
        });





    }
}
