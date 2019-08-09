package com.example.android.complaintapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ritika on 16/4/18.
 */

public class ContactActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        TextView num=(TextView) findViewById(R.id.plumber);
        num.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:xxxxxx"));
                startActivity(callIntent);
            }
        });
        TextView num1=(TextView) findViewById(R.id.electrician);
        num1.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:xxxxxx"));
                startActivity(callIntent);
            }
        });
        TextView num2=(TextView) findViewById(R.id.carpenter);
        num.setOnClickListener(new View.OnClickListener()

        {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:xxxxxx"));
                startActivity(callIntent);
            }
        });

    }
}
