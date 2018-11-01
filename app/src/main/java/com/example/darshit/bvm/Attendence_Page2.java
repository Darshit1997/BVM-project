package com.example.darshit.bvm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class Attendence_Page2 extends AppCompatActivity {

    LinearLayout linearmain;
    CheckBox checkBox;
    String temp="";
    String[] id1=new String[10];
    String[] name1=new String[10];
    String[] stu_id1=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence__page2);



    //    CheckedTextView checkedTextView=(CheckedTextView) findViewById(R.id.);
        linearmain = (LinearLayout) findViewById(R.id.lnratendencepg2);

//        chk_data(pos,ids,names);
        SharedPreferences patrick=getSharedPreferences("att_data",MODE_PRIVATE);
        String fac_id=patrick.getString("fac_id","").toString();
        String sem=patrick.getString("sem","").toString();
        Toast.makeText(getApplicationContext(),"FACULTY ID:"+fac_id+" & SEMESTER:"+sem,Toast.LENGTH_LONG).show();
        chk_data(fac_id,sem,id1,name1,stu_id1);

        Button btn=(Button) findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_att_data();
//                Intent i=new Intent(Attendence_Page2.this,ShowAttData.class);
//                startActivity(i);
            }
        });
    }
    public void save_att_data(){
        SharedPreferences patrick=getSharedPreferences("att_data",MODE_PRIVATE);
        String fac_id=patrick.getString("fac_id","").toString();
        String sem=patrick.getString("sem","").toString();
        String s_time=patrick.getString("s_time","").toString();
        String e_time=patrick.getString("e_time","").toString();
        String date=patrick.getString("date","").toString();
        String sub=patrick.getString("sub","").toString();

        Toast.makeText(getApplicationContext(),fac_id+" "+sem+" "+s_time+" "+e_time+" "+date,Toast.LENGTH_LONG).show();


//        Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
        String[] x=temp.split(",");
        int y=x.length;
        String d="";
        for(int i=0;i<y;i++){
            d+=id1[i]+"-"+stu_id1[i]+",";
        }
        String url1="http://192.168.43.156/bvm/function.php?req=ins_att_data&fac_id="+fac_id+"&sub="+sub+"&s_time="+s_time+"&e_time="+e_time+"&date="+date+"&p_ids="+temp;
        StringRequest re1=new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jo1=new JSONObject((response));
                    String scode=jo1.getString("status");
                    if(scode.equals("1")){
                        Toast.makeText(getApplicationContext(),"Attendance Saved!",Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(Attendence_Page2.this,Faculty_Activity.class);
                        startActivity(i1);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"!!Error Occured!!",Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(Attendence_Page2.this,Attendence_Page1.class);
                        startActivity(i1);
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
        };

        Volley.newRequestQueue(getApplicationContext()).add(re1);
        AlertDialog.Builder pat=new AlertDialog.Builder(this);
        final EditText input=new EditText(this);
        input.setText(url1);
        input.setInputType(InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE);
        pat.setView(input);
        pat.setTitle(url1);
        pat.show();
//        Toast.makeText(getApplicationContext(),d,Toast.LENGTH_LONG).show();
    }
    public void chk_data(String fac_id, String sem, final String[] id1, final String[] name1, final String[] stu_id1) {
        String temp_url="http://192.168.43.156/bvm/function.php?req=att_stu&fac_id="+fac_id+"&sem="+sem;
        Toast.makeText(getApplicationContext(),temp_url,Toast.LENGTH_LONG).show();
        StringRequest sq1=new StringRequest(Request.Method.GET, temp_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{

                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jobj=new JSONObject((response));

                    String id=jobj.getString("id");
                    String name=jobj.getString("name");
                    String sub_id=jobj.getString("stud_id");

                    String[] tids=id.split(",");
                    String[] tnames=name.split(",");
                    String[] tstud_ids=sub_id.split(",");

                    int x1=tids.length;
                    for(int i=0;i<x1;i++){
                        id1[i]=tids[i];
                        name1[i]=tids[i];
                        stu_id1[i]=tstud_ids[i];
                    }

                    Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
//                    linearmain = (LinearLayout) findViewById(R.id.linear);
                    ArrayList<String> a1= new ArrayList<String>();
                    for(int i=0;i<tids.length;i++){
                        String temp1=tstud_ids[i]+" ("+tnames[i]+")";
                        a1.add(temp1);
                    }
                    temp="";
                    for(int i=0;i<tids.length;i++) {
                        checkBox = new CheckBox(Attendence_Page2.this);

                        String xid;
                        xid=a1.get(i);
                        xid=xid.substring(0,6);

                        checkBox.setId(i);
                        checkBox.setText(a1.get(i));
//                        checkBox.setOnCheckedChangeListener(new patrick());
                        linearmain.addView(checkBox);
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked){
                                    int x=buttonView.getId();
//                                    Toast.makeText(getApplicationContext(),x+"is chechked",Toast.LENGTH_LONG).show();
                                    int y= Integer.parseInt(id1[x]);
                                    String z=stu_id1[x];
                                    temp=temp+z+",";
//                                    Toast.makeText(getApplicationContext(),"x="+x+"y="+y+"z"+z,Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();

//                                    Toast.makeText(getApplicationContext(),x+" is checked"+id1[x],Toast.LENGTH_LONG).show();
                                }
                                else{
                                    int x=buttonView.getId();
//                                    Toast.makeText(getApplicationContext(),x+"is chechked",Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();
                                    int y= Integer.parseInt(id1[x]);
                                    String z=stu_id1[x];
                                    temp=temp.replace(z," ");
                                    temp=temp.replace(", ,",",");
//                                    Toast.makeText(getApplicationContext(),x+"not checked"+temp,Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
                                }
                            }
                        });
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
}