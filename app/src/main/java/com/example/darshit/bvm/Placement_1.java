package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Placement_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_1);

        final WebView web1 = (WebView) findViewById(R.id.web1);
        final ProgressBar pg =(ProgressBar) findViewById(R.id.progressBar4);

        web1.getSettings().setJavaScriptEnabled(true);
        web1.getSettings().setLoadWithOverviewMode(true);
        web1.getSettings().setUseWideViewPort(true);
        web1.getSettings().setBuiltInZoomControls(true);


        web1.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                //setTitle("Loading...");
                //setProgress(progress * 100); //Make the bar disappear after URL is loaded
                // Return the app name after finish loading
                web1.setVisibility(View.INVISIBLE);
                pg.setVisibility(View.VISIBLE);
                if(progress == 100) {

                    pg.setVisibility(View.INVISIBLE);
                    web1.setVisibility(View.VISIBLE);
                    //setTitle(R.string.app_name);

                }
            }
        });


        web1.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {


                // Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
//                if(url.startsWith("https://docs.google.com/gview?embedded=true&url=")) {
//                }
//                else{
//                    if (url.endsWith(".pdf")) {
//                        url = "http://docs.google.com/gview?embedded=true&url=" + url;
//                    }
//
//                    // Toast.makeText(getApplicationContext(), "NEW URL:" + url, Toast.LENGTH_SHORT).show();
//
//                }

                web1.loadUrl(url);

                return true;
            }


        });

        web1.loadUrl("http://docs.google.com/gview?embedded=true&url=http://www.bvmengineering.ac.in/Placement%20Details%20of%20Past%20Years/2008-'09%20Placement%20Details.pdf");


    }
}
