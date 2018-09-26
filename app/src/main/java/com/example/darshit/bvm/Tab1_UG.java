package com.example.darshit.bvm;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Tab1_UG extends Fragment {
//public class Tab1_UG extends AppCompatActivity{
String s;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_ug, container, false);
        TextView textView1 = (TextView) rootView.findViewById(R.id.section_label);
        TextView textView2 = (TextView) rootView.findViewById(R.id.section_label2);
        TextView textView3 = (TextView) rootView.findViewById(R.id.section_label3);
        TextView textView4 = (TextView) rootView.findViewById(R.id.section_label4);
        TextView textView5 = (TextView) rootView.findViewById(R.id.section_label5);
        TextView textView6 = (TextView) rootView.findViewById(R.id.section_label6);
        TextView textView7 = (TextView) rootView.findViewById(R.id.section_label7);
        TextView textView8 = (TextView) rootView.findViewById(R.id.section_label8);
        TextView textView9 = (TextView) rootView.findViewById(R.id.section_label9);
        TextView textView10 = (TextView) rootView.findViewById(R.id.section_label10);

       /*textView1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               Intent intent = new Intent(getActivity().getBaseContext(),course_details.class);
//               startActivity(intent);
//               openFragment();
           }
       });*/

        //               super.onCreate(savedInstanceState);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23";
                show_data(s);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=24";
                show_data(s);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=25";
                show_data(s);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=26";
                show_data(s);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=27";
                show_data(s);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=28";
                show_data(s);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=29";
                show_data(s);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=30";
                show_data(s);
            }
        });
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=27";
                show_data(s);
            }
        });
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=28";
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
