package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  { /*implements LoaderCallbacks<Cursor>*/

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    //new



        public FirebaseAuth mAuth;
    public Button mEmailSignInButton;

        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */

        /**
         * Keep track of the login task to ensure we can cancel it if requested.
         */
        //private UserLoginTask mAuthTask = null;

        // UI references.
        private AutoCompleteTextView mEmailView;
        private String mEm;
        private EditText mPasswordView;
        private String mPas;
        private View mProgressView;
        private View mLoginFormView;


        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            //setupActionBar();
            // Set up the login form.
            mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
            mEm = mEmailView.getText().toString();
            //populateAutoComplete();

            mPasswordView = (EditText) findViewById(R.id.password);
            mPas = mPasswordView.getText().toString();
            mAuth = FirebaseAuth.getInstance();
            mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
            mEmailSignInButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mEm = mEmailView.getText().toString();
                    mPas = mPasswordView.getText().toString();
                  signIn(mEm,mPas);
                    mEmailView.getText().clear();
                    mPasswordView.getText().clear();



                }
            });
        }
    //@Override
    /*public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/
    private void signIn(String email,String password){
        if (!validateForm()) {
            return;
        }
      mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information

                FirebaseUser user = mAuth.getCurrentUser();
                findViewById(R.id.email_sign_in_button).setVisibility(View.VISIBLE);
                //updateUI(user);
                Intent Complaint = new Intent(LoginActivity.this, DispcomplaintsActivity.class);


                // Start the new activity

                startActivity(Complaint);



            } else {
                // If sign in fails, display a message to the user.
                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                Toast.makeText(LoginActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                //updateUI(null);
                //findViewById(R.id.email_sign_in_button).setVisibility(View.GONE);
            }
        }
        });
            }
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailView.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError("Required.");
            valid = false;
        } else {
            mEmailView.setError(null);
        }

        String password = mPasswordView.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError("Required.");
            valid = false;
        } else {
            mPasswordView.setError(null);
        }

        return valid;
    }

   /* private void updateUI(FirebaseUser user) {
       // hideProgressDialog();
        if (user != null) {


            mEmailSignInButton=(Button)  findViewById(R.id.email_sign_in_button);
            findViewById(R.id.email_sign_in_button).setVisibility(View.VISIBLE);

                   



        } else {
           *//* mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);*//*
            findViewById(R.id.email_sign_in_button).setVisibility(View.GONE);
        }
    }*/
   /* @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i==R.id.email_sign_in_button)
        {
            signIn(mEmailView.getText().toString(), mPasswordView.getText().toString());
        }
    }*/



    }






