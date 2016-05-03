package com.threeamstudios.theorangeloop;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Josh M on 5/1/2016.
 */
public class OrganizationToListViewAdaptor extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Organization> objects;

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
    }

    public OrganizationToListViewAdaptor(Context context, ArrayList<Organization> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        return objects.size();
    }

    public Organization getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.orgrow, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.Org_Name);
            holder.textView2 = (TextView) convertView.findViewById(R.id.Org_Desc);
            holder.textView3 = (TextView) convertView.findViewById(R.id.Org_Date);
            holder.textView4 = (TextView) convertView.findViewById(R.id.Org_Time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(objects.get(position).getOrgName());
        holder.textView2.setText(objects.get(position).getOrgDesc());
        holder.textView3.setText("test1");
        holder.textView4.setText("test2");
        return convertView;
    }

}
