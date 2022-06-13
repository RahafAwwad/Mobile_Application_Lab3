package com.example.lab3s;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private static final String[] SeasonsMonths = {
            "Summer runs from June 1 to August 31",
            "Spring runs from March 1 to May 31",
            "Winter runs from December 1 to February 28 (February 29 in a leap year)",
            "Autumn runs from September 1 to November 30"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String id = intent.getStringExtra("Season_id");
        String text = "";
        switch (id) {
            case "Summer":
                text = SeasonsMonths[0];
                break;
            case "Winter":
                text = SeasonsMonths[2];
                break;
            case "Spring":
                text = SeasonsMonths[1];
                break;
            case "Autumn":
                text = SeasonsMonths[3];
                break;
            default:
                text = "None";
                break;
        }


        TextView tv = (TextView) findViewById(R.id.SeasonDetails);
        tv.setText(text);
    }
}