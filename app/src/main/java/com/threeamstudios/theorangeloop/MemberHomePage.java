package com.threeamstudios.theorangeloop;

import android.content.Intent;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MemberHomePage extends Activity {

    public static ArrayList<Organization> organizationArrayList;
    private static ArrayList<String> URLfields;

    protected static void getImageURL() {
        String temp0 = "https://i.imgur.com/hsePrlh.jpg";
        String temp1 = "https://i.imgur.com/l23SwNr.jpg";
        String temp2 = "https://i.imgur.com/doO0i5L.jpg";
        String temp3 = "https://i.imgur.com/2DrzOh2.jpg";

        URLfields.add(temp0);
        URLfields.add(temp1);
        URLfields.add(temp2);
        URLfields.add(temp3);
    }

    public static final String URL =
            "https://i.imgur.com/ZCUZZfw.jpg";

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_member_home_page);

        // imageView = (ImageView) findViewById(R.id.imageView);

        // Create an object for subclass of AsyncTask
        // GetXMLTask task = new GetXMLTask();
        // Execute the task

        // Surround w/ loop

        // task.execute(new String[]{URL});
    }

    // Executes with button interaction. Goes to club event page.
    public void goToClub(View view) {
        Intent transition = new Intent(this, EventPage.class);
        startActivity(transition);
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

}
