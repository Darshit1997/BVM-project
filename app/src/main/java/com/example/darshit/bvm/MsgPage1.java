package com.example.darshit.bvm;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class MsgPage1 extends AppCompatActivity {

    LinearLayout linearmain;
    CheckBox checkBox;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_page1);

        final CheckedTextView checkedTextView=(CheckedTextView) findViewById(R.id.ctv);
        Button btn_done = (Button) findViewById(R.id.button6);
        final Spinner stspinner = (Spinner) findViewById(R.id.spinner4);
        final ArrayAdapter<CharSequence> stspad = ArrayAdapter.createFromResource(MsgPage1.this,R.array.Semesters,android.R.layout.simple_spinner_item);
        stspinner.setAdapter(stspad);

        stspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("Select Semester"))
                {

                }
                else
                {
                    String pos = (String) adapterView.getItemAtPosition(i);
                    Toast.makeText(adapterView.getContext(),"selected " +pos,Toast.LENGTH_SHORT).show();
                    stspinner.setVisibility(View.VISIBLE);

                    chk_data(pos);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    public void chk_data(String pos) {
        String temp_url="http://slopped-woods.000webhostapp.com/function.php?req1=send_msg&sem="+pos;
        Toast.makeText(getApplicationContext(),temp_url,Toast.LENGTH_LONG).show();
        StringRequest sq1=new StringRequest(Request.Method.GET, temp_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jobj=new JSONObject((response));
                    String id=jobj.getString("id");
                    String name=jobj.getString("name");

                    String[] ids=id.split(",");
                    String[] names=name.split(",");

                    Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
                    linearmain = (LinearLayout) findViewById(R.id.linear);

                    ArrayList<String> a1= new ArrayList<String>();

//                    a1.add(id);
                    for(int i=0;i<ids.length;i++){
                        a1.add(ids[i]+" ("+names[i]+")");
                    }
                    for(int i=0;i<a1.size();i++) {
                        checkBox = new CheckBox(MsgPage1.this);

                        String xid;
                        xid=a1.get(i);
                        xid=xid.substring(0,6);

                        checkBox.setId(i+1);
                        checkBox.setText(a1.get(i));
                        /*checkBox.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(checkBox.isChecked()){
                                    int x=v.getId();
                                    Toast.makeText(getApplicationContext(),x+":is checked",Toast.LENGTH_LONG).show();
                                }
                                else if(!checkBox.isChecked()){
                                    int x=v.getId();
                                    Toast.makeText(getApplicationContext(),x+":is un - checked",Toast.LENGTH_LONG).show();
                                }
                            }
                        });*/
                        checkBox.setOnCheckedChangeListener(new patrick());
                        linearmain.addView(checkBox);
                    }
                }
                catch(Exception e1){
                    e1.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Error is"+e1.toString(),Toast.LENGTH_LONG).show();
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

    public class patrick implements CheckBox.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean ischecked){
            if(ischecked){
                int x=buttonView.getId();
                Toast.makeText(getApplicationContext(),x+"is chechked",Toast.LENGTH_LONG).show();
            }
            else{
                int x=buttonView.getId();
                Toast.makeText(getApplicationContext(),x+"not checked",Toast.LENGTH_LONG).show();
            }
        }
    }




}
