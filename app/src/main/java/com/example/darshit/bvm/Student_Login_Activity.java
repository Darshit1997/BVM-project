package com.example.darshit.bvm;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Student_Login_Activity extends AppCompatActivity {

    EditText uname;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login_);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Button login_student = findViewById(R.id.btn_student_login);

        uname=(EditText) findViewById(R.id.editText);
        pass=(EditText) findViewById(R.id.editText2);


        login_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname1=uname.getText().toString();
                String pass1=pass.getText().toString();

                if(!uname1.isEmpty() && !pass1.isEmpty()){
                    login(uname1,pass1);
                }


            }
        });
    }

    public void login(final String user,final String pass){
//        String temp_url="http://bvm.epizy.com/test.php?username="+user+"&password="+pass;
        String temp_url="https://slopped-woods.000webhostapp.com/function.php?utype=student&username="+user+"&password="+pass;
        Toast.makeText(getApplicationContext(),temp_url,Toast.LENGTH_LONG).show();
        StringRequest sq1=new StringRequest(Request.Method.GET, temp_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONObject jobj=new JSONObject((response));
//                    boolean error=jobj.getBoolean("error");
//                    if(!error){
                    String uid=jobj.getString("msg");
                    String status=jobj.getString("status");

                    if(status.equals("1"))
                    {
                        Intent intent = new Intent(Student_Login_Activity.this,Student_Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Incorrect data",Toast.LENGTH_LONG).show();
                    }


//                        JSONArray ja=jobj.toJSONArray();
                    Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(),"ERROR OCCURED",Toast.LENGTH_LONG).show();
//                    }
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
            /*@Override
            protected Map<String,String> getParams(){
                Map<String,String> params=new HashMap<String, String>();
                return params;
            }*/
        };
        Volley.newRequestQueue(getApplicationContext()).add(sq1);
    }
}
