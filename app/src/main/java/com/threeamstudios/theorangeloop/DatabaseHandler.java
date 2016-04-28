package com.threeamstudios.theorangeloop;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

// Abstract to ensure Singleton design. Only one instantiation is allowed for am SQLite DB.
public class DatabaseHandler extends SQLiteOpenHelper {

    // No Default constructor in SQLiteOpenHelper. Private for Singleton Design Pattern
    private DatabaseHandler(Context context) {
        super(context, DB_NAME, null, 1);
    }

    // Single instantiation of DatabaseHandler/DataBase
    private static DatabaseHandler instance;

    // Public getter for the sole instantiation of the DatabaseHandler
    public static synchronized DatabaseHandler getInstance(Context context) {

        // If there is no instantiation, execute the ONLY instantiation of DBHandler!
        if (instance == null) {
            instance = new DatabaseHandler(context.getApplicationContext());
        }
        return instance;
    }

    // DataBase metadata
    private static final String DB_NAME = "organizationManager";
    private static final String TABLE_ORGANIZATIONS = "organizations";
    private static final String TABLE_MEMBERS = "members";

    // ORGANIZATION Table fields/Columns
    private static final String ORG_ID = "id";
    private static final String ORG_NAME = "name";
    private static final String ORG_DESC = "description";

    // Retrieve following data from controller
    private static final Integer ORG_SIZE = -1;

    // MEMBER Table fields/Columns
    private static final String MEMBER_ID = "id";
    private static final String MEMBER_NAME = "name";
    // Add field for clubs participating in

    // Establish Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQLite command. Make Org table
        String CREATE_ORG_TABLE =
                "CREATE TABLE " + TABLE_ORGANIZATIONS
                        + "("
                        + ORG_ID + " INTEGER PRIMARY KEY,"
                        + ORG_NAME + " TEXT,"
                        + ORG_DESC + " TEXT"
                        + ORG_SIZE + "INTEGER"
                        + ")";
        String CREATE_MEMBERS_TABLE =
                "CREATE TABLE " + TABLE_MEMBERS
                        + "("
                        + MEMBER_ID + " INTEGER PRIMARY KEY,"
                        + MEMBER_NAME + " TEXT,"
                        + ")";

        // Execute commands
        db.execSQL(CREATE_ORG_TABLE);
        db.execSQL(CREATE_MEMBERS_TABLE);
    }

    public boolean insertOrganization(String name, String desc, Integer size){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("desc", desc);
        contentValues.put("size", size);
        db.insert(TABLE_ORGANIZATIONS, null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }
    public boolean updateOrganization (Integer id, String name, String desc, Integer size)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("desc", desc);
        contentValues.put("size", size);
        db.update(TABLE_ORGANIZATIONS, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }
    public Integer deleteOrganization (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_ORGANIZATIONS,
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    // Update Database when need be
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    // Methods, CRUD operations for database.

}
