package com.example.menuexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ListView listMenu;
    private ListView lvItems;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // listMenu =findViewById(R.id.ViewListID);

        lvItems =  (ListView) findViewById(R.id.ListViewID);
        adaptador = new Adaptador(this,getArrayItems());
        lvItems.setAdapter(adaptador);
    }

    private ArrayList<menuItem> getArrayItems(){

        ArrayList<menuItem> listItems = new ArrayList<menuItem>();

        listItems.add(new menuItem("Radio Groups (LL)"));
        listItems.add(new menuItem("Buttons (LL)"));
        listItems.add(new menuItem("URL Demo (RL)"));
        listItems.add(new menuItem("Overlap Buttons (RL)"));
        listItems.add(new menuItem("URL Demo (TL)"));
        listItems.add(new menuItem("Scroll View (TL)"));

        return listItems;
    }
}