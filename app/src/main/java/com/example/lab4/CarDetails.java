package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetails extends AppCompatActivity {
    private int position;
    private String car;
    private ImageView car_pic;
    private String[] car_pics = {
            "bmw",
            "nissan",
            "chevrolet",
            "lamborghini",
            "shelby",
            "astin",
            "mazda",
            "honda",
            "toyota",
            "benz"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        car_pic = (ImageView) findViewById(R.id.car);
        car = getIntent().getStringExtra("car");
        position = Integer.parseInt(getIntent().getStringExtra("position"));
        setTitle(car);
        int id = getResources().getIdentifier(car_pics[position], "drawable", getPackageName());
        car_pic.setImageResource(id);

    }
}