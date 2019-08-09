package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


/**
 * Created by ritika on 4/3/18.
 */

public class FormcomplaintActivity extends AppCompatActivity {

    private String name;
    private String email;
    private String rollno;
    private String hostel;
    private String roomno;
    private String number;
    private String condition;
    private String description;
    private RadioGroup hostelgroup;
    private RadioGroup congroup;

    public String key;
    private String services;

    private AutoCompleteTextView mNameView;
    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mRollnoView;
    private AutoCompleteTextView mRoomnoView;
    private AutoCompleteTextView mNumberView;
    private AutoCompleteTextView mdescription;

    private DatabaseReference mDatabase;

// ...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formcomplaint);
        Button Services1 = (Button) findViewById(R.id.register);

        // Set a click listener on that View

        //services=getIntent().getStringExtra("service");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("complaints");

        hostelgroup = (RadioGroup) findViewById(R.id.hostel);
        congroup = (RadioGroup) findViewById(R.id.condition);


        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        email = mEmailView.getText().toString();

        mNameView = (AutoCompleteTextView) findViewById(R.id.name);
        name = mNameView.getText().toString();


        mRollnoView = (AutoCompleteTextView) findViewById(R.id.rollno);
        rollno = mRollnoView.getText().toString();

        mRoomnoView = (AutoCompleteTextView) findViewById(R.id.roomno);
        roomno = mRoomnoView.getText().toString();

        mNumberView = (AutoCompleteTextView) findViewById(R.id.number);
        number = mNumberView.getText().toString();

        mdescription = (AutoCompleteTextView) findViewById(R.id.description);
        description = mdescription.getText().toString();
        key = mDatabase.child("complaints").push().getKey();

        Services1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get selected radio button from radioGroup
                int selectedhosId = hostelgroup.getCheckedRadioButtonId();
                int selectedconId = congroup.getCheckedRadioButtonId();
                // find the radio button by returned id
                RadioButton radiohButton = (RadioButton) findViewById(selectedhosId);
                RadioButton radiocButton = (RadioButton) findViewById(selectedconId);

                Intent ServicesIntent = new Intent(FormcomplaintActivity.this, SuccessActivity.class);

                ServicesIntent.putExtra("fkey", key);
                services = getIntent().getStringExtra("service");

                if (check())
                // Start the new activity
                {
                    hostel = radiohButton.getText().toString();
                    condition = radiocButton.getText().toString();


                    Complaint complaint = new Complaint(name, email, rollno, hostel, roomno, number, condition, description, key, services, "");

                    mDatabase.push().setValue(complaint);
                    startActivity(ServicesIntent);

                }
                else
                    Toast.makeText(getApplicationContext(), "Invalid entry", Toast.LENGTH_SHORT).show();



            }
        });


    }

    boolean check() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        email = mEmailView.getText().toString();
        name = mNameView.getText().toString();
        rollno = mRollnoView.getText().toString();
        roomno = mRoomnoView.getText().toString();
        number = mNumberView.getText().toString();
        description = mdescription.getText().toString();
        hostelgroup = (RadioGroup) findViewById(R.id.hostel);
        congroup = (RadioGroup) findViewById(R.id.condition);
        int selectedhosId = hostelgroup.getCheckedRadioButtonId();
        int selectedconId = congroup.getCheckedRadioButtonId();
        // find the radio button by returned id
        RadioButton radiohButton = (RadioButton) findViewById(selectedhosId);
        RadioButton radiocButton = (RadioButton) findViewById(selectedconId);

        boolean c, d, e, n,g;
        if (email.matches(emailPattern)) {
            //Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
            c = true;
        } else {
            Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
            c = false;
        }
        if (!isValidMobile(number)) {
            Toast.makeText(getApplicationContext(), "Invalid Phone Number", Toast.LENGTH_SHORT).show();
            e = false;
        } else e = true;

        if (!isValidRoomno(roomno)) {
            Toast.makeText(getApplicationContext(), "Invalid Room Number", Toast.LENGTH_SHORT).show();
            e = false;
        } else e = true;


        if (name.matches("") || rollno.matches("") || roomno.matches("") || number.matches("") || email.matches("") || description.matches("")) {
            Toast.makeText(this, "All fields are compulsory", Toast.LENGTH_SHORT).show();
            d = false;

        } else
            d = true;

        if (!name.matches("^[\\p{L} .'-]+$")) {
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
            n = false;
        } else n = true;
        if(hostelgroup.getCheckedRadioButtonId()==-1||congroup.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(this, "All fields not filled", Toast.LENGTH_SHORT).show();
            g=false;
        }
        else g=true;



        if (c && d && e && n && g)
            return true;
        else
            return false;

    }

    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }

    private boolean isValidRoomno(String roomno) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", roomno)) {
            if (roomno.length() < 1 || roomno.length() > 3) {
                // if(phone.length() != 10) {
                check = false;

            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }


// onClick of button perform this simplest code.


}




