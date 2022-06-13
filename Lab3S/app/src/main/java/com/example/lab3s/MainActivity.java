package com.example.lab3s;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3s.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<String> seasonsA;
    ArrayList<Integer> IDs;
    ArrayAdapter<String> Adapt;
    //Spinner spin=findViewById(R.id.spinner);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        load_data();
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ImageButton img = (ImageButton) findViewById(R.id.Season);
                binding.Season.setImageResource(IDs.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
public void load_data(){
    seasonsA=new ArrayList<>();
    seasonsA.add("Summer");
    seasonsA.add("Winter");
    seasonsA.add("Spring");
    seasonsA.add("Autumn");
    Adapt= new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,seasonsA);
    binding.spinner.setAdapter(Adapt);
    IDs=new ArrayList<>();
    IDs.add(R.drawable.summer);
    IDs.add(R.drawable.winter);
    IDs.add(R.drawable.spring);
    IDs.add(R.drawable.autumn);


}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void onClickSeasonImage(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Spinner spin=findViewById(R.id.spinner);
        String selectedItem=spin.getSelectedItem().toString();
        intent.putExtra("Season_id", selectedItem);
        startActivity(intent);
    }


}