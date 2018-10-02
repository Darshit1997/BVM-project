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
        listDataHeader.size();

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

        List<String> electrical = new ArrayList<String>();
        electrical.add("Dr. Bhupendra R. Parekh");
        electrical.add("Dr. Nidhish G. Mishra");
        electrical.add("Abdulsalam A. Shaikh");
        electrical.add("Dr. Rashesh P. Mehta");
        electrical.add("Jagdish K. Chauhan");
        electrical.add("Manish Kumar N. Sinha");
        electrical.add("Ajay M. Patel");
        electrical.add("Ashish R. Patel");
        electrical.add("Jaydeepsinh C. Baria");
        electrical.add("Gaurang K. Sharma");
        electrical.add("Yogesh R. Prajapati");
        electrical.add("Mrs. Dharita K. Patel");
        electrical.add("Dipan A. Parikh");
        electrical.add("Dr. Akshay A. Pandya");
        electrical.add("Swapnil V. Arya");
        electrical.add("Nilesh B Patel");
        electrical.add("Tejas J Patel");
        electrical.add("Amit G Patel");
        electrical.add("Keval N. Pandya");
        electrical.add("Ramesh C Patel");

        List<String> electronics = new ArrayList<String>();
        electronics.add("Tanmay D Pawar");
        electronics.add("Dr. Dipakkumar M Patel");
        electronics.add("Dr. D. L. Vala");
        electronics.add("Dr. Jagdishkumar. M. Rathod");
        electronics.add("Ajaykumar A. Daiya");
        electronics.add("Dr. Mehfuza  S. Holia");
        electronics.add("Dr. Kaushika D. PATEL");
        electronics.add("Mohan M. Khambalakar");
        electronics.add("Ms. Parul H Panchal");
        electronics.add("Milendraakumar Manilal Solanki");
        electronics.add("Mahendra Prahladbhai Prajapati");
        electronics.add("Chintankumar Sumanbhai Patel");
        electronics.add("Chetan Jayprakash Jayaswal");
        electronics.add("Nirajkumar Ratubhai ADA");
        electronics.add("Anita Narendra Bhatt");
        electronics.add("Hemant C. Patel");
        electronics.add("Harshad J. Sevak");

        List<String> mechanical = new ArrayList<String>();
        mechanical.add("P M George");
        mechanical.add("Vinay J. Patel");
        mechanical.add("Vina D Chauhan");
        mechanical.add("Mohammedilyas Ismail Kathadi");
        mechanical.add("Satish A Shah");
        mechanical.add("Jayprakash Nagindas Jain");
        mechanical.add("Bharat Shivjibhai Patel");
        mechanical.add("M J Zinzuvadia");
        mechanical.add("Shashank P Joshi");
        mechanical.add("Rameshkumar G Jivani");
        mechanical.add("Dr. Haresh Patolia");
        mechanical.add("Prakash Mohanlal Tadvi");
        mechanical.add("Vipulkumar H Chaudhari");
        mechanical.add("Prof. H G Katariya");
        mechanical.add("Jayantilal Pithabhai Hadiya");
        mechanical.add("Sanjaykumar Jayendrasingh Vansadiya");
        mechanical.add("F R Vora");
        mechanical.add("Jayesh Rasikbhai Koisha");
        mechanical.add("Alpeshkumar Babubhai Damor");
        mechanical.add("Ronak Rajnikant Patel");
        mechanical.add("Upendrakumar Balabhai Chaudhari");
        mechanical.add("Pinkal G Choksi");
        mechanical.add("Hitesh A Bhargav");
        mechanical.add("Dhara P Trivedi");
        mechanical.add("Ketul Bhanuprasad Brahmbhatt");
        mechanical.add("Vishal Anilkumar Pandya");
        mechanical.add("Ashish Maheshkumar Thakkar");
        mechanical.add("Vijaypratap Ramsen Singh");
        mechanical.add("Chintan P Mazmudar");
        mechanical.add("Kinjal A Patel");
        mechanical.add("Ankit S Yadav");
        mechanical.add("Jaydeep V Sanandiya");

        List<String> production = new ArrayList<String>();
        production.add("Dr. Amit M Trivedi");
        production.add("Kamlesh Dhansukhlal Bhatt");
        production.add("Rakesh Sureshbhai Barot");
        production.add("Purvi D Chauhan");
        production.add("Hardik S Berawala");
        production.add("Jigisha Bhaskar Thakkar");
        production.add("Akil H Jariya");
        production.add("Gaurav V. Patel");
        production.add("Jatin R. Makwana");

        List<String> infotech = new ArrayList<String>();
        infotech.add("Dr.Keyur Nayankumar Brahmbhatt");
        infotech.add("Mr. Nilesh B. Prajapati");
        infotech.add("Dr. Zankhana  H. Shah");
        infotech.add("KRUPALI H. SHAH");
        infotech.add("Mr. Vikram M. Agrawal");
        infotech.add("Vatsal Hasmukhbhai Shah");
        infotech.add("Kanubhai Ganpatbhai Patel");
        infotech.add("Ms. Bijal N. Dalwadi");
        infotech.add("Mr. Chintan  Mukeshchandra  Mahant");
        infotech.add("Mr. Vishal A. Polara");
        infotech.add("Mr. Priyank N. Bhojak");
        infotech.add("Ms. Prachi Ketankumar Shah");
        infotech.add("Vishal A. Kanjariya");
        infotech.add("Ravindrakumar D. Patel");
        infotech.add("Ronak H. Patel");
        infotech.add("Dr. Swapnil D. Patel");

        List<String> elecomm = new ArrayList<String>();
        elecomm.add("Bhargav C. Goradiya");
        elecomm.add("Arjanbhai B. Bambhaniya");
        elecomm.add("Prafulkumar s. Bhakhar");
        elecomm.add("Dr.Darshankumar C. Dalwadi");
        elecomm.add("Hiren Jigeshkumar Patel");
        elecomm.add("Robinson P. Paul");
        elecomm.add("Ghansyamkumar B. Rathod");
        elecomm.add("Sandip Rajnikant Unadkat");
        elecomm.add("Ripal MaHENDRAKUMAR PATEL");
        elecomm.add("Palak Kaushikbhai Patel");
        elecomm.add("Anishbhai A. Vahora");
        elecomm.add("Dr.Rajvirsinh Chandrasinh Rana");
        elecomm.add("Amit Harishchandra Choksi");
        elecomm.add("Ronak Rajendrakumar Vashi");
        elecomm.add("Kaushal R. Patel");
        elecomm.add("Mayurkumar M. Sevak");
        elecomm.add("Mohammadsoheb R. Saiyed");
        elecomm.add("Chiragkumar A. Patel");
        elecomm.add("Prakashbhai P. Solanki");

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


        List<String> mathematics = new ArrayList<String>();
        mathematics.add("Dr Truptiben A. Desai");
        mathematics.add("Dr R. B. Gandhi");
        mathematics.add("Dr. Mukesh E. Shimpi");
        mathematics.add("Shailesh Dilipbhai Bhagat");
        mathematics.add("Dr Namita S. Sathe");
        mathematics.add("Aakar  N. Roghelia");
        mathematics.add("Dr Mehul  J. Shah");
        mathematics.add("Dipti R. Patel");






        listDataChild.put(listDataHeader.get(0), civil);// Header, Child data
        listDataChild.put(listDataHeader.get(1), computer);
        listDataChild.put(listDataHeader.get(2), electrical);
        listDataChild.put(listDataHeader.get(3), electronics);
        listDataChild.put(listDataHeader.get(4), mechanical);
        listDataChild.put(listDataHeader.get(5), production);
        listDataChild.put(listDataHeader.get(6), infotech);
        listDataChild.put(listDataHeader.get(7), elecomm);
        listDataChild.put(listDataHeader.get(8), structural);
        listDataChild.put(listDataHeader.get(9), mathematics);


    }
}
