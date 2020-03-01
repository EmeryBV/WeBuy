package com.example.webuy;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Magasin_activity extends AppCompatActivity {

    private ArrayList<String> planetes;
    ListView listview;
    MagasinAdapter adapter;
    Data datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magasin);
        datas = new Data();
        listview = (ListView) findViewById(R.id.listView);
        adapter = new MagasinAdapter(datas.getMagasins(),Magasin_activity.this);
        listview.setAdapter(adapter);

        popUp("Magasin_activity");
    }

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}