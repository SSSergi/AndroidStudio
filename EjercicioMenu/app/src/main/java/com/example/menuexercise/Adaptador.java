package com.example.menuexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;

    private ArrayList<menuItem> listItems;

    public Adaptador(Context context, ArrayList<menuItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        menuItem item = (menuItem) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

        TextView tvOpcion = (TextView) convertView.findViewById(R.id.lvOpcion);

        tvOpcion.setText(item.getOpcion());

        return convertView;
    }
}
