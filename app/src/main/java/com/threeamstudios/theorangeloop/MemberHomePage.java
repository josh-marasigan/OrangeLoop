package com.threeamstudios.theorangeloop;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MemberHomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_home_page);
    }

    // Executes with button interaction. Goes to club event page
    public void goToClub(View view) {
        Intent transition = new Intent(this, EventPage.class);
        startActivity(transition);
    }
}
