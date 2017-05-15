package com.example.alqibthiyyah.latihanlagi.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alqibthiyyah.latihanlagi.Adapters.CobaAdapters;
import com.example.alqibthiyyah.latihanlagi.R;


public class MainActivity extends AppCompatActivity {
    //ListView listView;
    EditText txtViewuname, txtViewpass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CobaAdapters adapters = new CobaAdapters(MainActivity.this);

       // listView = (ListView)findViewById(R.id.ListView);
        //listView.setAdapter(adapters);

        txtViewuname = (EditText)findViewById(R.id.txtViewuname);
        txtViewpass = (EditText)findViewById(R.id.txtViewpass);
    }

    public void OnLogin (View view){
        String username = txtViewuname.getText().toString();
        String password = txtViewpass.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

    }
}
