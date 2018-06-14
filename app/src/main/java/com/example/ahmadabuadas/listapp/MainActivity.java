package com.example.ahmadabuadas.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView MyListView ;
    String [] items;
    String [] price;
    String [] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        MyListView = (ListView) findViewById(R.id.MyListView);
        items = res.getStringArray(R.array.items);
        //MyListView.setAdapter(new ArrayAdapter<String>(this, R.layout.MyTextviewDetails,items));
        price = res.getStringArray(R.array.price);
        description = res.getStringArray(R.array.description);


        ItemAdapter itemsAdapter = new ItemAdapter(this ,items, price, description);
        MyListView.setAdapter(itemsAdapter);

        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ShowDetailsActivity = new Intent(getApplicationContext(),DetailsActivity.class);
                ShowDetailsActivity.putExtra("com.example.ahmadabuadas.Item_Index",i);
                startActivity(ShowDetailsActivity);
            }
        });


    }
}
