package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private CarListAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cars For Car Enthusiasts");
        rv = findViewById(R.id.rv);
        ca = new CarListAdapter(this);
        rv.setAdapter(ca);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}