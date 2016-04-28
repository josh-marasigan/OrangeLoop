package com.threeamstudios.theorangeloop.Tests;

import android.content.Context;
import android.test.AndroidTestCase;
import com.threeamstudios.theorangeloop.DatabaseHandler;

/**
 * Created by Charles on 4/28/2016.
 */
public class TestDB extends AndroidTestCase {
    public void testCreateDB() throws Throwable {

/*        DatabaseHandler x = DatabaseHandler.getInstance(context);
       // assertNotNull(1);
       System.out.println("Hello World");*/
        //false();
        assertEquals(0, 1);
        assertEquals(0, 0);
        //DatabaseHandler x = DatabaseHandler.getInstance(context);

    }
    public void testCreateDC() throws Throwable {

        assertEquals(0, 0);
    }
}
