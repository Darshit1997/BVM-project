package com.example.darshit.bvm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.File;

public class Contact_Us_Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us__page1);


        TextView bvmurl = (TextView)findViewById(R.id.tvurl);

        bvmurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String url ="http://bvmengineering.ac.in/";

//                Uri uri = Uri.parse("http://bvmengineering.ac.in/");
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//                browserIntent.setDataAndType(uri, "text/html");
//                browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
//                context.startActivity(browserIntent);


//                Intent intent = new Intent(Intent.ACTION_VIEW, String);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                startActivity(intent);
                Intent httpIntent = new Intent(Intent.ACTION_VIEW);
                httpIntent.setData(Uri.parse("http://bvmengineering.ac.in"));

                startActivity(httpIntent);

            }
        });
    }
}
