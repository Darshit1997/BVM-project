package com.example.darshit.bvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Faculty_Guestpage1 extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__guestpage1);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();
listAdapter=new com.example.darshit.bvm.ExpandableListAdapter(this,listDataHeader,listDataChild);
//        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Civil Engineering");
        listDataHeader.add("Computer Engineering");
        listDataHeader.add("Electrical Engineering");
        listDataHeader.add("Electronics Engineering");
        listDataHeader.add("Mechanical Engineering");
        listDataHeader.add("Production Engineering");
        listDataHeader.add("Information Technology");
        listDataHeader.add("Electronic & Communication");
        listDataHeader.add("Structural");
        listDataHeader.add("Mathematics");

        // Adding child data
        List<String> civil = new ArrayList<String>();
        civil.add("Dr.Laxmansinh Bhemsinh Zala");
        civil.add("Prof.Neha Rameshchandra  Patel");
        civil.add("Dr. S. D. Dhiman");
        civil.add("Prof.Reshma Lalbihari Patel");
        civil.add("Prof.Himanshu Champaklal Vakharia");
        civil.add("Prof. Pankaj  Jayantilal Shah");
        civil.add("Prof.Chandravadan Banwarilal Mishra");
        civil.add("Dr. Harshad Vithalbhai  Patel");
        civil.add("Prof. Amitkumar Narandas Bhavsar");
        civil.add("Dr. H. J. Chauhan");
        civil.add("Prof.D. S. Modi");
        civil.add("Prof. Nekzad Farokh Umrigar");
        civil.add("Prof.Amit Ambalal Amin");
        civil.add("Dr. Jayeshkumar R Pitroda");
        civil.add(" Prof. Pinakin N Patel");
        civil.add("Prof. Jignesh I Brahmbhatt");
        civil.add("Bhupesh M Panchal");
        civil.add("Chirag R Patel");
        civil.add("Gautam B Parekh");



        List<String> structural = new ArrayList<String>();
        structural.add("Dr. Arvind K. Verma");
        structural.add("Dr. Indrajit N. Patel");
        structural.add("Atul N. Desai");
        structural.add("Bharat R. Dalwadi");
        structural.add("Dr. Darshana Rajiv Bhatt");
        structural.add("Elizabeth - George");
        structural.add("Sumant B. Patel");
        structural.add("Dr. Deepa A. Sinha");
        structural.add("Dr. Snehal V. Mevada");
        structural.add("Dr. Vishal A. Arekar");
        structural.add(" Vimlesh V. Agrawal");
        structural.add("Vishalkumar Bhaskarbhai Patel");
        structural.add("Jagruti P. Shah");


        List<String> computer = new ArrayList<String>();
        computer.add("Darshak Gauravbhai Thakore");
        computer.add("Mayur Mansukhlal Vegad");
        computer.add("PRASHANT B SWADAS");
        computer.add("Narendra Manorbhai Patel");
        computer.add("Mosin Ibrahim hasan");
        computer.add("Hemant D Vasava");
        computer.add("Bhavesh Ashokbhai Tanawala");
        computer.add("Kirtikumar Jashavantbhai Sharma");
        computer.add("Dr. Udesang K  Jaliya");
        computer.add("Mahasweta Jayantbhai Joshi");
        computer.add("Pranay S  Patel");
        computer.add("Bhadreshbhai c Patel");
        computer.add(" Bindu V. Raval");


        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), civil); // Header, Child data
        listDataChild.put(listDataHeader.get(8), structural);
        listDataChild.put(listDataHeader.get(1), computer);
    }
}
