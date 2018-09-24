package com.example.darshit.bvm;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2_PG extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_pg, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        //String x[]=new String[10];
//        String x[]=getResources().getStringArray(R.array.section_format1);
//        String data="";
//        for(int i=0;i<x.length;i++){
//            //
//            //x[i]=getResources().getStringArray(R.array.section_format).toString();
//            data=data+" "+x[i]+'\n';
////                textView.setText(x[i]+"\n");
//        }
//        textView.setText(data);

        return rootView;
    }
}
