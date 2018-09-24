package com.example.darshit.bvm;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Tab1_UG extends Fragment {
//public class Tab1_UG extends AppCompatActivity{
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

                Intent intent = new Intent(getActivity().getApplicationContext(), course_details.class);
                startActivity(intent);
            }
//                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//                alert.setTitle("Title here");
//
//                final WebView wv = new WebView(getActivity());
//                wv.getSettings().setJavaScriptEnabled(true);
//                wv.getSettings().setLoadWithOverviewMode(true);
//                wv.getSettings().setUseWideViewPort(true);
//                wv.getSettings().setBuiltInZoomControls(true);
//                wv.getSettings().setUseWideViewPort(true);
//                wv.getSettings().setPluginState(WebSettings.PluginState.ON);
//
//               //wv.getSettings().setPluginsEnabled(true);
//                wv.setWebViewClient(new WebViewClient() {
//                    @Override
//                    public void onPageFinished(WebView view ,String url)
//                    {
//                        wv.loadUrl("javascript:(function() { " +
//                                "document.getElementsByTagName('content')[0].style.display='none'; " +
//                                "})()");
//                    }
//                });
//
//                wv.loadUrl("http://www.bvmengineering.ac.in/comman_page1.aspx?page_id=23");
////                wv.setWebViewClient(new WebViewClient() {
////                    @Override
////                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                        view.loadUrl(url);
////
////                        return true;
////                    }
////                });
//
//                alert.setView(wv);
//                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                });
//                alert.show();
//            }
        });


        return rootView;
        }
}
