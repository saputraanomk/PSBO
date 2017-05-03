package com.example.alqibthiyyah.latihanlagi.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.alqibthiyyah.latihanlagi.Adapters.CobaAdapters;
import com.example.alqibthiyyah.latihanlagi.R;


public class MainActivity extends AppCompatActivity {
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CobaAdapters adapters = new CobaAdapters(MainActivity.this);

        listView = (ListView)findViewById(R.id.ListView);
        listView.setAdapter(adapters);
    }
}
