package com.example.ahmadabuadas.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String [] items;
    String [] price;
    String [] description;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
      this.items = i;
      this.price = p;
      this.description =d;
      this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_textview_details, null);
        TextView NametextView = (TextView) v.findViewById(R.id.NametextView );
        TextView PricetextView = (TextView) v.findViewById(R.id.PricetextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);

        String name = items[i];
        String desc = description[i];
        String cost = price[i];

        NametextView.setText(name);
        PricetextView.setText(cost);
        descriptionTextView.setText(desc);
        return v;
    }
}
