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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by ritika on 1/4/18.
 */

public class StatustellActivity extends AppCompatActivity {
    private String status;
    private String Id;
    private AutoCompleteTextView StatusView;
    private RadioGroup response;
    private DatabaseReference mDatabase;
    private Button enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statustell);
        StatusView =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        enter=(Button) findViewById(R.id.button3);
        Id=StatusView.getText().toString().trim();
        response=(RadioGroup)findViewById(R.id.response);

        mDatabase=FirebaseDatabase.getInstance().getReference().child("complaints");

        /*final ValueEventListener complaintListener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Complaint complaint=dataSnapshot.getValue(Complaint.class);
                DataSnapshot complaintSnapshot=dataSnapshot.child("complaints");
                Iterable<DataSnapshot> complaintChildren = complaintSnapshot.getChildren();
                for (DataSnapshot complaints : complaintChildren)
                {
                    Complaint c=complaints.getValue(Complaint.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }*/
        if(Id.isEmpty()||response.getCheckedRadioButtonId()==-1) {
            enter.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Fill All Fields", Toast.LENGTH_SHORT).show();

        }
        else
            enter.setEnabled(true);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                response=(RadioGroup)findViewById(R.id.response);
                StatusView =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
                Id = StatusView.getText().toString().trim();

                int selectstatus = response.getCheckedRadioButtonId();
                RadioButton selectstat = (RadioButton) findViewById(selectstatus);
                if(response.getCheckedRadioButtonId()!=-1)
                status=selectstat.getText().toString().trim();



                if(status.equals("Yes")&&!Id.isEmpty()) {
                   
                    FirebaseDatabase.getInstance().getReference().child("complaints").addValueEventListener(new ValueEventListener() {
                        @Override

                        public void onDataChange(DataSnapshot dataSnapshot) {
                            StatusView =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
                            Id = StatusView.getText().toString().trim();

                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                Complaint c = snapshot.getValue(Complaint.class);
                                //Object obj = snapshot.getKey();
                                //String a = obj.toString();
                                if (c.getKey().equals(Id))
                                {
                                    DatabaseReference src=snapshot.getRef();
                                    final DatabaseReference target=FirebaseDatabase.getInstance().getReference().child("Old Complaints");
                                    //TODO wrong node pushed
                                    moveFirebaseRecord(src,target);
                                    Toast.makeText(getApplicationContext(), "Your response has been recorded", Toast.LENGTH_SHORT).show();

                                    

                                    break;
                                }

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }


                Intent ServicesIntent = new Intent(StatustellActivity.this, UserActivity.class);
                ServicesIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ServicesIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ServicesIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(ServicesIntent);

            }

        }
               );



    }
    public void moveFirebaseRecord(final DatabaseReference fromPath, final DatabaseReference toPath)
    {
        fromPath.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                toPath.push().setValue(dataSnapshot.getValue(), new DatabaseReference.CompletionListener()
                {
                    @Override
                    public void onComplete(DatabaseError firebaseError, DatabaseReference firebase)
                    {
                        if (firebaseError != null)
                        {
                            System.out.println("Copy failed");

                        }
                        else
                        {
                            System.out.println("Success");
                            fromPath.removeValue();

                        }
                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError firebaseError)
            {

            }
        });
    }

    }

