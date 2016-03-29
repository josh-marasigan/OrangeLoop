package com.threeamstudios.theorangeloop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/* ------- */
/* [Model] */
/* ------- */
public class MainActivity extends Activity {

    // String field for debug purposes.
    private static final String TAG = "OrangeLoop";
	
	// Test Comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Controls

        // Assign Event Handlers to Controls

        // Establish DataBases and Tables. (Clubs)

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    // Executes with button interaction. Goes to personal user home page
    public void goToHome(View view) {
        Intent transition = new Intent(this, MemberHomePage.class);
        startActivity(transition);
    }

}
