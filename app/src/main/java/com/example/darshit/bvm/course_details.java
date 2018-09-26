package com.example.darshit.bvm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class course_details extends AppCompatActivity {
    WebView wb;
    ProgressBar pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        wb=(WebView)findViewById(R.id.WebView);
        pg =(ProgressBar) findViewById(R.id.progressBar);


        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);

        wb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                   //setTitle("Loading...");
              //setProgress(progress * 100); //Make the bar disappear after URL is loaded
                // Return the app name after finish loading
                wb.setVisibility(View.INVISIBLE);
                pg.setVisibility(View.VISIBLE);
                if(progress == 100) {

                    pg.setVisibility(View.INVISIBLE);
                    wb.setVisibility(View.VISIBLE);
                   //setTitle(R.string.app_name);

                }
            }
        });

        wb.setWebViewClient(new WebViewClient() {



            @Override
            public void onPageFinished(WebView view, String url)
            {

                wb.loadUrl("javascript:(function() { " + "document.getElementById('header').style.display='none'; document.getElementById('footer').style.display='none'; " + "})()");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //   pg.setVisibility(View.VISIBLE);
//            if(url.indexOf("http://bvmengineering.ac.in")>-1) return false;
//            return true;


              // Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
                if(url.startsWith("https://docs.google.com/gview?embedded=true&url=")) {
                }
                else{
                    if (url.endsWith(".pdf")) {
                        url = "http://docs.google.com/gview?embedded=true&url=" + url;
                    }

                    // Toast.makeText(getApplicationContext(), "NEW URL:" + url, Toast.LENGTH_SHORT).show();

                }

                wb.loadUrl(url);

                return true;
            }

        });
        wb.loadUrl("http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23");

    }


    @Override
    public void onBackPressed() {
        if (wb.canGoBack()) {
            wb.goBack();
        } else {
            super.onBackPressed();
        }

    }
}
