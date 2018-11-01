package com.example.darshit.bvm;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
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

public class MsgPage1 extends AppCompatActivity{

    LinearLayout linearmain;
    CheckBox checkBox;
    String mno;

    String[] ids=new String[10];
    String[] names=new String[10];
    String[] contacts=new String[10];
    String temp="";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_page1);

       // final CheckedTextView checkedTextView=(CheckedTextView) findViewById(R.id.ctv);
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

                    String p=pos.substring(pos.length()-1);
                    chk_data(p,ids,names,contacts);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int l=ids.length;
//                CheckBox cbox;
//                for(int i=0;i<l;i++){
//                    cbox=(CheckBox) findViewById(i);
//                    if(cbox.isChecked()){
//                        temp+=":"+contacts[i];
//                    }
//                }
                sendSMS();
            //Intent intent = new Intent(MsgPage1.this,MsgPage2.class);
            //startActivity(intent);
            }
        });
    }
    protected void sendSMS(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MsgPage1.this, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(MsgPage1.this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Enter message to be sent!");
        final EditText input=new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg=input.getText().toString();
                String[] x=temp.split(",");
                int y=x.length;
                Toast.makeText(getApplicationContext(),temp+"_total length_"+y,Toast.LENGTH_LONG).show();
                for(int i=0;i<y;i++) {
//                    Toast.makeText(getApplicationContext(),(i+1)+":"+x[i],Toast.LENGTH_LONG).show();
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(x[i], null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage("8980258949", null, "Hello World, Patrick!", null, null);
//                    Toast.makeText(getApplicationContext(), "SMS sent.",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
    public void chk_data(String pos, final String[] ids, final String[] names, final String[] contacts) {
        String temp_url="http://192.168.43.156/bvm/function.php?req1=send_msg&sem="+pos;
        Toast.makeText(getApplicationContext(),temp_url,Toast.LENGTH_LONG).show();
        StringRequest sq1=new StringRequest(Request.Method.GET, temp_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    /*int il=ids.length;

                    for(int i=0;i<il;i++){
                        ids[i]=null;
                        names[i]=null;
                        contacts[i]=null;
                    }*/

                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jobj=new JSONObject((response));
                    //do_work(jobj);
                    String id=jobj.getString("id");
                    String name=jobj.getString("name");
                    final String contact=jobj.getString("contact");
                    final String[] cno;
                    String[] tids=id.split(",");
                    String[] tnames=name.split(",");
                    final String[] tcontacts=contact.split(",");

                    int x1=tids.length;
                    for(int i =0;i<x1;i++){
                        ids[i]=tids[i];
                        names[i]=tnames[i];
                        contacts[i]=tcontacts[i];
                    }

                    Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
                    linearmain = (LinearLayout) findViewById(R.id.linear);
                    linearmain.removeAllViews();
                    ArrayList<String> a1= new ArrayList<String>();
                    for(int i=0;i<tids.length;i++){
                        String temp=tids[i]+" ("+tnames[i]+")";
                        a1.add(temp);
                    }
                    temp="";
                    for(int i=0;i<a1.size();i++) {
                        checkBox = new CheckBox(MsgPage1.this);

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
                                    Toast.makeText(getApplicationContext(),x+"is chechked",Toast.LENGTH_LONG).show();

                                    String t2=tcontacts[x];

//                                    temp+=contacts[checkBox.getId()]+",";
                                    temp=temp+t2+",";
                                }
                                else{
                                    int x=buttonView.getId();
                                    Toast.makeText(getApplicationContext(),x+"not checked",Toast.LENGTH_LONG).show();
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
