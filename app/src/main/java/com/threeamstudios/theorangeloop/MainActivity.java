package com.threeamstudios.theorangeloop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/* ------------------------------ */
/* [Model, Dictates 'activities'] */
/* ------------------------------ */
public class MainActivity extends AppCompatActivity {

    // String field for debug purposes.
    private static final String TAG = "OrangeLoop";
	
	// Test Comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
