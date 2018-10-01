package com.example.darshit.bvm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class Placement_Page1 extends AppCompatActivity {
    String s;
//    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement__page1);


        Button bt1 = (Button) findViewById(R.id.pcyr1);
        Button bt2 = (Button) findViewById(R.id.pcyr2);
        Button bt3 = (Button) findViewById(R.id.pcyr3);
        Button bt4 = (Button) findViewById(R.id.pcyr4);
        Button bt5 = (Button) findViewById(R.id.pcyr5);
        Button bt6 = (Button) findViewById(R.id.pcyr6);
        Button bt7 = (Button) findViewById(R.id.pcyr7);
        Button bt8 = (Button) findViewById(R.id.pcyr8);
        Button bt9 = (Button) findViewById(R.id.pcyr9);
        Button bt10 = (Button) findViewById(R.id.pcyr10);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Placement_Page1.this,Placement_1.class);
                startActivity(intent);
//                s="http://www.google.com";   show_data(s);
//                /*AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
//                alert.setTitle("Title here");
//
//                WebView wv = new WebView(alert.getContext());
//                wv.loadUrl("http:\\www.google.com");
//                wv.setWebViewClient(new WebViewClient() {
//                    @Override
//                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                        view.loadUrl(url);
//
//                        return true;
//                    }
//                });
//
//                alert.setView(wv);
//                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                });
//                alert.show();*/
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_2.class);
                startActivity(intent);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_3.class);
                startActivity(intent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_4.class);
                startActivity(intent);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_5.class);
                startActivity(intent);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_6.class);
                startActivity(intent);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_7.class);
                startActivity(intent);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_8.class);
                startActivity(intent);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_9.class);
                startActivity(intent);
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Placement_Page1.this,Placement_10.class);
                startActivity(intent);
            }
        });


    }

//    public void show_data(String wb_url) {
////        Toast.makeText(getApplicationContext(),wb_url,Toast.LENGTH_SHORT).show();
//        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
//        final WebView wb = new WebView(getApplicationContext());
//        final ProgressBar pg = new ProgressBar(getApplicationContext());
//        wb.getSettings().setJavaScriptEnabled(true);
//        wb.getSettings().setLoadWithOverviewMode(true);
//        wb.getSettings().setUseWideViewPort(true);
//        wb.getSettings().setBuiltInZoomControls(true);
//
//        wb.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                wb.setVisibility(View.INVISIBLE);
//                pg.setVisibility(View.VISIBLE);
//                if (progress == 100) {
//                    pg.setVisibility(View.INVISIBLE);
//                    wb.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        wb.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                wb.loadUrl("javascript:(function() { " + "document.getElementById('header').style.display='none'; document.getElementById('footer').style.display='none'; " + "})()");
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if (url.startsWith("https://docs.google.com/gview?embedded=true&url=")) {
//                } else {
//                    if (url.endsWith(".pdf")) {
//                        url = "http://docs.google.com/gview?embedded=true&url=" + url;
//                    }
//
//                    // Toast.makeText(getApplicationContext(), "NEW URL:" + url, Toast.LENGTH_SHORT).show();
//
//                }
//
//                wb.loadUrl(url);
//
//                return true;
//            }
//
//        });
//        //wb.loadUrl("http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23");
//        wb.loadUrl(wb_url);
//        TextView tv=new TextView(getApplicationContext());
//        tv.setText("hello world");
//        alert.setView(tv);
//        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//                dialog.dismiss();
//            }
//        });
//        alert.show();
//    }



}
