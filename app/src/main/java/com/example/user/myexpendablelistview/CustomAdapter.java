package com.example.user.myexpendablelistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> HeaderList;
    private HashMap<String,List<String>> ChildList;

    public CustomAdapter(Context context,List<String> HeaderList,HashMap<String,List<String>> ChildList) {
        this.context = context;
        this.HeaderList = HeaderList;
        this.ChildList= ChildList;
    }

    @Override
    public int getGroupCount() {

        return HeaderList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ChildList.get(HeaderList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return HeaderList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ChildList.get(HeaderList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String Headerstring = (String) getGroup(groupPosition);

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header,null);


        }

        TextView textView =  convertView.findViewById(R.id.headertextviewid);
        textView.setText(Headerstring);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {



        String Clildstring = (String) getChild(groupPosition,childPosition);

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.clild,null);


        }

        TextView textView =  convertView.findViewById(R.id.childtextid);
        textView.setText(Clildstring);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
