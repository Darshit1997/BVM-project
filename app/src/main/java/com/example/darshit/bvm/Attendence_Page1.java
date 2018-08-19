package com.example.darshit.bvm;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import me.srodrigo.androidhintspinner.HintAdapter;

public class Attendence_Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence__page1);





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


                if(adapterView.getItemAtPosition(i).equals(""))
                {

                mySpinner2.setVisibility(View.GONE);
                }

                else
                {
                    String item = (String) adapterView.getItemAtPosition(i);
                    Toast.makeText(adapterView.getContext(),"selected" +item,Toast.LENGTH_SHORT).show();
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
               // if(adapterView.getItemAtPosition(i).equals("Choose Subject")) {

                //}
                //else
                //{

                    adapterView.getItemAtPosition(i);

                //}


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
}


