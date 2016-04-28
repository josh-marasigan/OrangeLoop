package com.threeamstudios.theorangeloop.Tests;

import android.content.Context;
import android.test.AndroidTestCase;
import com.threeamstudios.theorangeloop.*;

import java.util.ArrayList;

/**
 * Created by Charles on 4/28/2016.
 */
public class TestDB extends AndroidTestCase {

    public void testDatabaseHandler() throws Throwable{
        assertEquals(1,DatabaseHandler.returnOne());
    }

    public void testMemberSetters() throws Throwable {
        Organization org = new Organization();
        org.setOrgSize(5);
        org.setOrgName("Test Organization");
        ArrayList<Member> orgMembers = new ArrayList<Member>();
        ArrayList<Organization> orgList = new ArrayList<Organization>();
        orgMembers.add(new Member());
        org.setOrgMembers(orgMembers);

        assertEquals(new Integer(5), org.getOrgSize());
        assertEquals("Test Organization", org.getOrgName());
        assertEquals("Fred", org.getOrgMembers().get(0).getName());

    }

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
