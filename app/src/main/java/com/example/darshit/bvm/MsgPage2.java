package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckedTextView;

public class MsgPage2 extends AppCompatActivity {

    CheckedTextView ctv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_page2);


        ctv=(CheckedTextView) findViewById(R.id.ctv);

    }
}

