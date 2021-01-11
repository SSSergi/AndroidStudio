package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvMonth;
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonth = findViewById(R.id.lvMonth);
        months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);
        lvMonth.setAdapter(monthAdapter);
        lvMonth.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //String month = parent.getItemAtPosition(position).toString();  //1
        //String month = months[position];  //2
        //String month = ((TextView) view).getText().toString();  //3
        String month = lvMonth.getItemAtPosition(position).toString();  //4
        Toast.makeText(getApplicationContext(), "Clicked: " + month, Toast.LENGTH_SHORT).show();  //4  //3  //2  //1
    }
}