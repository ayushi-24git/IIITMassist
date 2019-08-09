package com.example.android.complaintapp;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by ritika on 9/3/18.
 */

public class EntertimeActivity  extends DispcomplaintsActivity implements DatePickerDialog.OnDateSetListener

        {
            private DatePicker datePicker;
            private TextView dateView;
            private int year, month, day;

            private Calendar calendar;

            //

    private AutoCompleteTextView timeView;
   private String time;

    private Button enter;
    private DatabaseReference mDatabase;




    // ...
    private void sendEmail(String t, String em) {
        //Getting content for email
     /*email = em;
     subject = "complaint";
    message = t;*/

        //Creating SendMail object
        SendMail sm = new SendMail(this, em, "complaint", t);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertime);
        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
       // showDate(year, month+1, day);
        //




        //

        enter = (Button) findViewById(R.id.button2);

        String key = getIntent().getStringExtra("fkey");
        final String email = getIntent().getStringExtra("emailid");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("complaints");


        enter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

               timeView = (AutoCompleteTextView) findViewById(R.id.time);
                TextView date=(TextView)findViewById(R.id.textView6);
                time = timeView.getText().toString();
                // mDatabase.child("complaints").child(key).child("res").setValue(time);
                String key = getIntent().getStringExtra("fkey");
                String email = getIntent().getStringExtra("emailid");
                if(date.getText().equals("Set Date")||time.equals(""))
                    Toast.makeText(view.getContext(), "Enter Timing Details", Toast.LENGTH_SHORT).show();
                else {


                    sendEmail("Your rectification time is:" + date.getText() + "," + time + "Your complaint id is:" + key + "\n" + "Please copy this complaint id when your complaint is rectified,and paste it in the, give your complaint status form", email);
                    Toast.makeText(view.getContext(), "Time Updated", Toast.LENGTH_SHORT).show();
                    Intent ServicesIntent = new Intent(EntertimeActivity.this, DispcomplaintsActivity.class);

                    startActivity(ServicesIntent);
                }
            }
        });
    }

            @SuppressWarnings("deprecation")
            public void setDate(View view)
            {
                //showDialog(999);
               /* Toast.makeText(getApplicationContext(), "ca",
                        Toast.LENGTH_SHORT)
                        .show();*/
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(),"Date Picker");
            }




                        @Override
                        public void onDateSet(DatePicker arg0,
                                              int arg1, int arg2, int arg3) {
                            // TODO Auto-generated method stub
                            Calendar c=Calendar.getInstance();
                            c.set(Calendar.YEAR,arg1);
                            c.set(Calendar.MONTH,arg2);
                            c.set(Calendar.DAY_OF_MONTH,arg3);
                            // arg1 = year
                            // arg2 = month
                            // arg3 = day
                            String currrentdate= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
                            TextView date=(TextView)findViewById(R.id.textView6);
                            date.setText(currrentdate);
                        }


            //


        }



   /* private Calendar myCalendar;
    private TextView edittext;
    private TextView edittext1;
    private Calendar myClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertime);
         myCalendar = Calendar.getInstance();

        edittext= (TextView) findViewById(R.id.date);
        edittext1=(TextView) findViewById(R.id.time);
       final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };*/
      /* myClock= Calendar.getInstance();
       final TimePickerDialog.OnTimeSetListener time=new TimePickerDialog.OnTimeSetListener() {
           @Override
           public void onTimeSet(TimePicker timePicker, int i, int i1) {
               myClock.set(Calendar.HOUR_OF_DAY,i);
               myClock.set(Calendar.MINUTE,i1);
               updateLabel1();

           }
       };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(EntertimeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        edittext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(EntertimeActivity.this,time,myClock.get(Calendar.HOUR_OF_DAY),myClock.get(Calendar.MINUTE),true).show();
            }
        });*/

   /* private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));*/

   /* private void updateLabel1{
        String myFormat="HH/MM";
        SimpleTimeZone t=new SimpleTimeZone(myFormat,Locale.US);
    }*/

 /*android:layout_alignLeft="@+id/textView3"
         android:layout_alignStart="@+id/textView3"
         android:layout_below="@+id/autoCompleteTextView*/

