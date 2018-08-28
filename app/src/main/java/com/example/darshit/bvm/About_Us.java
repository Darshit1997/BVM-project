package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class About_Us extends AppCompatActivity {

    WebView wb;
    ProgressBar pg;

    private class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            pg.setVisibility(View.VISIBLE);
            
            return true;
        }


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        wb=(WebView)findViewById(R.id.WebView);

       // pg =(ProgressBar) findViewById(R.id.progressBar);

      //  this.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
       // setProgressBarIndeterminateVisibility(true);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setPluginState(WebSettings.PluginState.ON);
    //    wb.getSettings().setPluginsEnabled(true);
        wb.setWebViewClient(new HelloWebViewClient());
        wb.loadUrl("http://bvmengineering.ac.in/comman_page1.aspx?page_id=2");

      //  setProgressBarIndeterminateVisibility(false);
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




