package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Mag_Page1 extends AppCompatActivity {
    WebView wb;
    ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag__page1);

        wb = (WebView) findViewById(R.id.wb_mag1);
        pg =(ProgressBar) findViewById(R.id.progressBar3);


        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);

        wb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                setTitle("Loading...");
//                setProgress(progress * 100); //Make the bar disappear after URL is loaded
                // Return the app name after finish loading
                wb.setVisibility(View.INVISIBLE);
                pg.setVisibility(View.VISIBLE);
                if (progress == 100) {

                    pg.setVisibility(View.INVISIBLE);
                    wb.setVisibility(View.VISIBLE);
//                    setTitle(R.string.app_name);

                }
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        wb.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url)
            {

                wb.loadUrl("javascript:(function() { " + "document.getElementById('pbTopBar').style.display='none'; document.getElementById('pbToolBar').style.display='none'; " + "})()");
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;

            }
        });

        wb.loadUrl("http://www.bvmengineering.ac.in/Vishvakarma%20Magazine/vishvakarma'17/#p=1");

    }


}

