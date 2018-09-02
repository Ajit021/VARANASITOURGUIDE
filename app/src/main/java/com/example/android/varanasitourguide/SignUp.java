package com.example.android.varanasitourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mFirebaseAuth=FirebaseAuth.getInstance();

        mAuthStateListener =new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    //user signed in
                    //Toast.makeText(SignUp.this,"you are loged in", Toast.LENGTH_SHORT).show();

                }

                else
                {
                    //user signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };



        //for first activity
        LinearLayout history = (LinearLayout) findViewById(R.id.history);

        // Set a click listener on that View
        history.setOnClickListener(new View.OnClickListener()

        {
            // The code in this method will be executed when the album category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Activity}
                Intent historyIntent = new Intent(SignUp.this, history.class);

                // Start the new activity
                startActivity(historyIntent);
            }
        });

        LinearLayout topattraction = (LinearLayout) findViewById(R.id.topattraction);

        // Set a click listener on that View
        topattraction.setOnClickListener(new View.OnClickListener()

        {
            // The code in this method will be executed when the nowplaying category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Activity}
                Intent topattractionIntent = new Intent(SignUp.this, topattraction.class);

                // Start the new activity
                startActivity(topattractionIntent);
            }
        });

        LinearLayout restaurants = (LinearLayout) findViewById(R.id.restaurants);

        // Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the song category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Activity}
                Intent restaurantsIntent = new Intent(SignUp.this,restaurants.class);

                // Start the new activity
                startActivity(restaurantsIntent);
            }
        });

        LinearLayout sites = (LinearLayout) findViewById(R.id.sites);

        // Set a click listener on that View
        sites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the payment category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Activity}
                Intent sitesIntent = new Intent(SignUp.this, sites.class);

                // Start the new activity
                startActivity(sitesIntent);


            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.sign_out_menu:
                //sign out
                AuthUI.getInstance().signOut(this);
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Sign-in succeeded, set up the UI
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }


            @Override
    protected void onPause()
    {
        super.onPause();
        if(mAuthStateListener!=null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
