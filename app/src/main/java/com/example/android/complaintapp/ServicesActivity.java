package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ritika on 3/3/18.
 */

public class ServicesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        TextView Services = (TextView) findViewById(R.id.plumber);

        // Set a click listener on that View
        Services.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ServicesIntent = new Intent(ServicesActivity.this, FormcomplaintActivity.class);
                ServicesIntent.putExtra("service","plumber");
                // Start the new activity
                startActivity(ServicesIntent);
            }
        });

        TextView Services1 = (TextView) findViewById(R.id.electrician);

        // Set a click listener on that View
        Services1.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ServicesIntent = new Intent(ServicesActivity.this, FormcomplaintActivity.class);
                ServicesIntent.putExtra("service","electrician");
                // Start the new activity
                startActivity(ServicesIntent);
            }
        });

        TextView Services2 = (TextView) findViewById(R.id.carpenter);

        // Set a click listener on that View
        Services2.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ServicesIntent = new Intent(ServicesActivity.this, FormcomplaintActivity.class);
                ServicesIntent.putExtra("service","carpenter");
                // Start the new activity
                startActivity(ServicesIntent);
            }
        });

        TextView Services3 = (TextView) findViewById(R.id.painter);

        // Set a click listener on that View
        Services3.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ServicesIntent = new Intent(ServicesActivity.this, FormcomplaintActivity.class);
                ServicesIntent.putExtra("service","painter");
                // Start the new activity
                startActivity(ServicesIntent);
            }
        });


        TextView Services4 = (TextView) findViewById(R.id.ambulance);

        // Set a click listener on that View
        Services4.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                //change number
                Intent callIntent = new Intent(ServicesActivity.this,ContactActivity.class);
                //callIntent.setData());
                // Start the new activity

               startActivity(callIntent);
            }
        });



    }
}
