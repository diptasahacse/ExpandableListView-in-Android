package com.example.user.myexpendablelistview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private List<String> HeaderList;
    private HashMap<String,List<String>> ChildList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandablelistid);
        PreaperData();
        CustomAdapter customArapter = new CustomAdapter(this,HeaderList,ChildList);
        expandableListView.setAdapter(customArapter);




    }

    private void PreaperData() {
        String[] HeaderData = getResources().getStringArray(R.array.Headerlist);
        String[] ChildData = getResources().getStringArray(R.array.Childlist);

        HeaderList = new ArrayList<>();
        ChildList = new HashMap<>();

        for (int i=0;i<HeaderData.length;i++)
        {
            //add header data

            HeaderList.add(HeaderData[i]);

            List<String> child = new ArrayList<>();
            child.add(ChildData[i]);

            ChildList.put(HeaderList.get(i),child);
        }
    }
}
