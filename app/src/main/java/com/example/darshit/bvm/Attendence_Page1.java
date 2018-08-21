package com.example.darshit.bvm;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import me.srodrigo.androidhintspinner.HintAdapter;

public class Attendence_Page1 extends AppCompatActivity {

    TextView date;
    Calendar mCurrentDate;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence__page1);

        Button takeattendence = (Button) findViewById(R.id.btn_takeattendence);

        date = (TextView)findViewById(R.id.tv_date);
        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        month =month+1;
        date.setText(day+"/"+month+"/"+year);




        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Attendence_Page1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                    month=month+1;
                    date.setText(day+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });





        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);




        final ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(Attendence_Page1.this,R.array.Semesters,android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);


        ArrayAdapter<CharSequence> myAdapter2 = ArrayAdapter.createFromResource(Attendence_Page1.this,R.array.Subjects,android.R.layout.simple_spinner_item);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);


        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if(adapterView.getItemAtPosition(i).equals("Select Semester"))
                {

                mySpinner2.setVisibility(View.GONE);
                }

                else
                {
                    String pos = (String) adapterView.getItemAtPosition(i);
                    Toast.makeText(adapterView.getContext(),"selected" +pos,Toast.LENGTH_SHORT).show();
                    mySpinner2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("Choose Subject")) {

                }
                else
                {

                    String pos1 = (String)adapterView.getItemAtPosition(i);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        takeattendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Attendence_Page1.this,Attendence_Page2.class);
                startActivity(intent);
            }
        });




    }
}


