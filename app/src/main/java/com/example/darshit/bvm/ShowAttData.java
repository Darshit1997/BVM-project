package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ShowAttData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_att_data);


        String url="http://192.168.43.156/bvm/function.php?req=all_att_info&fac_id=1";
        Toast.makeText(getApplicationContext(),url,Toast.LENGTH_LONG).show();
        StringRequest show_data=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jo=new JSONObject((response));
                    String sem=jo.getString("sem");
                    String sub=jo.getString("sub");
                    String s_time=jo.getString("s_time");
                    String e_time=jo.getString("e_time");
                    String date=jo.getString("date");
                    String p_ids=jo.getString("p_ids");


                    String[] sems=sem.split(",");
                    String[] subs=sub.split(",");
                    String[] stimes=s_time.split(",");
                    String[] etimes=e_time.split(",");
                    String[] dates=date.split(",");
                    String[] pids=p_ids.split("-");

                    int x=sems.length;

                    for(int i=0;i<x;i++){
                        Toast.makeText(getApplicationContext(),sems[i],Toast.LENGTH_LONG).show();

                        TableLayout tl1=(TableLayout) findViewById(R.id.tbl_main);
                        TableRow tr1=new TableRow(ShowAttData.this);

                        TextView t1=new TextView(ShowAttData.this);
                        t1.setText(sems[i]);

                        TextView t2=new TextView(ShowAttData.this);
                        t2.setText(subs[i]);

                        TextView t3=new TextView(ShowAttData.this);
                        t3.setText(stimes[i]);

                        TextView t4=new TextView(ShowAttData.this);
                        t4.setText(etimes[i]);

                        TextView t5=new TextView(ShowAttData.this);
                        t5.setText(dates[i]);

                        TextView t6=new TextView(ShowAttData.this);
                        t6.setText(pids[i]);

                        tr1.addView(t1);
                        tr1.addView(t2);
                        tr1.addView(t3);
                        tr1.addView(t4);
                        tr1.addView(t5);
                        tr1.addView(t6);

                        tl1.addView(tr1,i+1);
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(show_data);
    }
}
