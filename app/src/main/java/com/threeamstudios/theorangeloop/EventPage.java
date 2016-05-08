package com.threeamstudios.theorangeloop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class EventPage extends Activity {
    public static boolean flag = true;
    private Organization organization = new Organization();

    private String orgUrl;
    private String orgName;
    private String orgDesc;
    private ImageView imageView;
    private TextView ren;
    private TextView red;
    // final TextView textName = (TextView)findViewById(R.id.Org_Name);
    // final TextView textDesc = (TextView)findViewById(R.id.Org_Desc);

    public Integer nm;
    private Bundle ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent from master list
        ext = getIntent().getExtras();
        orgName = ext.getString("Org_Name");
        orgDesc = ext.getString("Org_Desc");
        orgUrl = ext.getString("Org_URL");

        nm = Intent.EXTRA_DOCK_STATE_CAR;

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_event_page);

        // Set Texts
        imageView = (ImageView) findViewById(R.id.imageViewClub);

        // textName.setText(orgName);
        // textDesc.setText(orgDesc);

        // Create an object for subclass of AsyncTask
        GetXMLTask task = new GetXMLTask();
        task.execute(new String[]{orgUrl});

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setTextOff("Register");
        toggle.setTextOn("Unregister");
        if(flag) {
            toggle.setText("Register");
            toggle.setTextOff("Register");
            toggle.setTextOn("Unregister");

        }else {
            toggle.setText("Unregister");
            toggle.setTextOff("Unregister");
            toggle.setTextOn("Register");
        }

       /* toggle.setTextOff("Register");
        toggle.setTextOn("Unregister");*/
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (flag) {
                    DatabaseHandler db = DatabaseHandler.getInstance(getBaseContext());
                    db.getDataOrganization(nm);
                    // temp
                    organization = new Organization();
                    organization.setOrgName(db.getReadableDatabase().toString());

                    db.insertOrganization(organization);
                    flag = false;

                } else {
                    DatabaseHandler db = DatabaseHandler.getInstance(getBaseContext());
                    System.out.println(db.getAllOrganization().get(0));

                    // Remove from the database
                    Toast.makeText(
                            getApplicationContext(),
                            db.getAllOrganization().get(0).toString(),
                            Toast.LENGTH_LONG).show();
                    flag = true;

                }
            }
        });

        ren = (TextView) findViewById(R.id.RegisteredEventName);
        red = (TextView) findViewById(R.id.RegisteredEventDesc);
        ren.setText(this.orgName);
        red.setText(this.orgDesc);

    }

    private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap map = null;
            for (String url : urls) {
                map = downloadImage(url);
            }
            return map;
        }

        // Sets the Bitmap returned by doInBackground
        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

        // Creates Bitmap from InputStream and returns it
        private Bitmap downloadImage(String url) {
            Bitmap bitmap = null;
            InputStream stream = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;

            try {
                stream = getHttpConnection(url);
                bitmap = BitmapFactory.
                        decodeStream(stream, null, bmOptions);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        private InputStream getHttpConnection(String urlString)

                throws IOException {

            InputStream stream = null;
            java.net.URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return stream;
        }
    }

    public void react(View v) {
        // Intent transition = new Intent(this, MemberHomePage.class);
        Intent transition = new Intent(this, MemberHomePage.class);
        startActivity(transition);
    }

}
