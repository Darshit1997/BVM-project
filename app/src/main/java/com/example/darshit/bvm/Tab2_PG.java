package com.example.darshit.bvm;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Tab2_PG extends Fragment {
    String s;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_pg, container, false);
        TextView textView1 = (TextView) rootView.findViewById(R.id.section1_label1);
        TextView textView2 = (TextView) rootView.findViewById(R.id.section1_label2);
        TextView textView3 = (TextView) rootView.findViewById(R.id.section1_label3);
        TextView textView4 = (TextView) rootView.findViewById(R.id.section1_label4);
        TextView textView5 = (TextView) rootView.findViewById(R.id.section1_label5);
        TextView textView6 = (TextView) rootView.findViewById(R.id.section1_label6);
        TextView textView7 = (TextView) rootView.findViewById(R.id.section1_label7);
        TextView textView8 = (TextView) rootView.findViewById(R.id.section1_label8);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=31";
                show_data(s);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=32";
                show_data(s);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=33";
                show_data(s);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=34";
                show_data(s);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=35";
                show_data(s);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=36";
                show_data(s);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=37";
                show_data(s);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=67";
                show_data(s);
            }
        });






        return rootView;
    }

    public void show_data(String wb_url){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final WebView wb = new WebView(getActivity());
        final ProgressBar pg=new ProgressBar(getActivity());
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);

        wb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                wb.setVisibility(View.INVISIBLE);
                pg.setVisibility(View.VISIBLE);
                if(progress == 100) {
                    pg.setVisibility(View.INVISIBLE);
                    wb.setVisibility(View.VISIBLE);
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
        //wb.loadUrl("http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23");
        wb.loadUrl(wb_url);
        alert.setView(wb);
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
}
