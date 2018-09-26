package com.example.darshit.bvm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Map_Bvm extends AppCompatActivity {

    WebView wb;
    ProgressBar pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_bvm);

        wb=(WebView)findViewById(R.id.wb_map);
        pg =(ProgressBar) findViewById(R.id.progressBar2);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);

        wb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                setTitle("Loading...");
//                setProgress(progress * 100); //Make the bar disappear after URL is loaded
                // Return the app name after finish loading
                wb.setVisibility(View.INVISIBLE);
                pg.setVisibility(View.VISIBLE);
                if(progress == 100) {

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
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;

            }
        });
        wb.loadUrl("https://www.google.com/maps/place/Birla+Vishvakarma+Mahavidyalaya,+Vallabh+Vidyanagar,+Mota+Bazaar,+Vallabh+Vidyanagar,+Anand,+Gujarat+388120/@22.5525703,72.9238183,16z/data=!4m2!3m1!1s0x395e4e74c03b7749:0xab364c66fd4834c");


        if(ActivityCompat.checkSelfPermission(Map_Bvm.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Map_Bvm.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Map_Bvm.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
                //enter code for if permission already granted
        }


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
