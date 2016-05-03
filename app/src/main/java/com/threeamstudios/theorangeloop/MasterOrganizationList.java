package com.threeamstudios.theorangeloop;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MasterOrganizationList extends Activity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    private ListView mainListView ;
    private OrganizationToListViewAdaptor adaptor;
    ArrayList<String> listItems=new ArrayList<String>();
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
    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        orgList.add(new Organization("Test", 1, new ArrayList<Member>()));
        adaptor.notifyDataSetChanged();
    }


}
