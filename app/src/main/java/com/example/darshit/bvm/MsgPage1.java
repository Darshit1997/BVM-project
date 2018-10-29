package com.example.darshit.bvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MsgPage1 extends AppCompatActivity {

CheckedTextView ctv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_page1);

        ctv=(CheckedTextView) findViewById(R.id.ctv);
        Button btn_done = (Button) findViewById(R.id.button6);
        final Spinner stspinner = (Spinner) findViewById(R.id.spinner4);
        final ArrayAdapter<CharSequence> stspad = ArrayAdapter.createFromResource(MsgPage1.this,R.array.Semesters,android.R.layout.simple_spinner_item);
        stspinner.setAdapter(stspad);

        stspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("Start"))
                {


                }

                else
                {
                    String pos = (String) adapterView.getItemAtPosition(i);
                    Toast.makeText(adapterView.getContext(),"selected" +pos,Toast.LENGTH_SHORT).show();
                    stspinner.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctv.isChecked()) {
                        ctv.setChecked(false);
                }
                else
                {
                    ctv.setChecked(true);
                }
            }
        });


        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MsgPage1.this,MsgPage2.class);
                startActivity(intent);
            }
        });




    }
}
