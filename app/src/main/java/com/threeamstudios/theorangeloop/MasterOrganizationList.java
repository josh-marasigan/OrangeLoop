package com.threeamstudios.theorangeloop;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MasterOrganizationList extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    private ListView mainListView ;
    private OrganizationToListViewAdaptor adaptor;
    ArrayList<Organization> orgList = new ArrayList<Organization>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_organization_list);

        // Find the ListView resource.
        mainListView = (ListView) findViewById(R.id.list);

        // Params: Context, Layout, Organization Into
        /* adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listItems); */

        // Test
        adaptor = new OrganizationToListViewAdaptor(this, orgList);
        mainListView.setAdapter(adaptor);
        initItems(mainListView);
    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        // Intent transition = new Intent(this, MemberHomePage.class);
        Intent transition = new Intent(this, EventPage.class);
        transition.putExtra("MyData", v.getId());
        startActivity(transition);

        DatabaseHandler handler = DatabaseHandler.getInstance(this);

        // View all organizations in the GUI
        orgList.addAll(2, handler.getAllOrganization());
        adaptor.notifyDataSetChanged();
    }

    public void initItems(View v) {
        // Get Database reference
        DatabaseHandler handler = DatabaseHandler.getInstance(this);

        // View all organizations in the GUI
        orgList.addAll(handler.getAllOrganization());
        adaptor.notifyDataSetChanged();
    }
}
