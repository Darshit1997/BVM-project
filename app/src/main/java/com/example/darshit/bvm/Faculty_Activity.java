package com.example.darshit.bvm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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
                AlertDialog.Builder choice=new AlertDialog.Builder(Faculty_Activity.this);
                LinearLayout l1=new LinearLayout(Faculty_Activity.this);
                Button add=new Button(Faculty_Activity.this);
                add.setText("Add New");
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Faculty_Activity.this,Attendence_Page1.class);
                        startActivity(intent);
                    }
                });
                Button show=new Button(Faculty_Activity.this);
                show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Faculty_Activity.this,ShowAttData.class);
                        startActivity(intent);
                    }
                });
                show.setText("Show Data");
                l1.addView(add);
                l1.addView(show);
                choice.setView(l1);
                choice.show();
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
