package com.example.darshit.bvm;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class course_details extends AppCompatActivity {
    WebView wb;
    Activity activity ;
    private ProgressDialog progDailog;
    String GoogleDocs="http://docs.google.com/gview?embedded=true&url=";

    private class HelloWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        wb=(WebView)findViewById(R.id.WebView);


        activity = this;
        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
        progDailog.setCancelable(true);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(false);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setPluginState(WebSettings.PluginState.ON);
        //    wb.getSettings().setPluginsEnabled(true);
        wb.setWebViewClient(new course_details.HelloWebViewClient());
        wb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageFinished(WebView view ,String url)
            {
                progDailog.dismiss();
//                view.loadUrl("javascript:(function() { " + "document.getElementsByTagName('content')[0].style.display='none'; " + "})()");
            }


        });
        wb.loadUrl("http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23");
        wb.loadUrl(GoogleDocs+"loadurl");


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
