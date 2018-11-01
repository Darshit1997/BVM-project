package com.example.darshit.bvm;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Iterator;

import me.srodrigo.androidhintspinner.HintAdapter;

public class Attendence_Page1 extends AppCompatActivity {

    TextView date;
    Calendar mCurrentDate;
    int day=0,month=0,year=0;
    String pos;
    String pos1;
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

            date.setText(day+"/"+(month+1)+"/"+year);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Attendence_Page1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        int temp=month+1;
                        date.setText(day+"/"+temp+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });



        final Spinner stspinner = (Spinner) findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> stspad = ArrayAdapter.createFromResource(Attendence_Page1.this,R.array.starttime,android.R.layout.simple_spinner_item);
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



        final Spinner endSpinner = (Spinner) findViewById(R.id.spinner3);
        final ArrayAdapter<CharSequence> esad = ArrayAdapter.createFromResource(Attendence_Page1.this,R.array.endtime,android.R.layout.simple_spinner_item);
        endSpinner.setAdapter(esad);


        endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("End"))
                {

                }

                else
                {
                    String pos = (String) adapterView.getItemAtPosition(i);
                    Toast.makeText(adapterView.getContext(),"selected" +pos,Toast.LENGTH_SHORT).show();
                    endSpinner.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


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
                    pos = (String) adapterView.getItemAtPosition(i);
                    String x=pos.substring(pos.length()-1);
                    pos=x;
                    get_data(x);
//                    Toast.makeText(adapterView.getContext(),"selected" +pos,Toast.LENGTH_SHORT).show();
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

                    pos1 = (String)adapterView.getItemAtPosition(i);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        takeattendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SharedPreferences.Editor patrick=getSharedPreferences("att_data",MODE_PRIVATE).edit();
                    patrick.putString("fac_id","1");
                    patrick.putString("sem",pos);
                    patrick.putString("sub",pos1);
                    Spinner stime_s=(Spinner) findViewById(R.id.spinner);
                    Spinner etime_s=(Spinner) findViewById(R.id.spinner3);
                    TextView d_tv=(TextView) findViewById(R.id.tv_date);

                    String s_time=stime_s.getSelectedItem().toString();
                    String e_time=etime_s.getSelectedItem().toString();
                    String date1=d_tv.getText().toString();
                    patrick.putString("s_time",s_time);
                    patrick.putString("e_time",e_time);
                    patrick.putString("date",date1);
                    patrick.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Attendence_Page1.this,Attendence_Page2.class);
                startActivity(intent);
            }
        });


//        get_data();

    }
    public void get_data(String pos){
        Toast.makeText(getApplicationContext(),pos,Toast.LENGTH_LONG).show();
        String temp_url="http://192.168.43.156/bvm/function.php?req=att_sub&fac_id=1&sem="+pos;
        Toast.makeText(getApplicationContext(),temp_url,Toast.LENGTH_LONG).show();
        StringRequest sq1=new StringRequest(Request.Method.GET, temp_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jobj=new JSONObject((response));
                    String id=jobj.getString("id");
                    String name=jobj.getString("name");
                    String sub_id=jobj.getString("sub_id");

                    String[] ids=id.split(",");
                    String[] names=name.split(",");
                    String[] sub_ids=sub_id.split(",");

                    String[] data=new String[ids.length];
                    for(int i=0;i<ids.length;i++){
                        data[i]=sub_ids[i]+" - "+names[i];
                    }
                    final Spinner s1=(Spinner) findViewById(R.id.spinner2);

                    ArrayAdapter<String> gameKindArray= new ArrayAdapter<String>(Attendence_Page1.this,android.R.layout.simple_spinner_item, data);
                    gameKindArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s1.setAdapter(gameKindArray);

                }
                catch(Exception e1){
                    e1.printStackTrace();
                    Toast.makeText(getApplicationContext(),e1.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
        };
        Volley.newRequestQueue(getApplicationContext()).add(sq1);
    }
}


