package com.websolverpro.androidadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listViewEx;
    Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> countries = new ArrayList<>(Arrays.asList("Bangladesh", "USA", "India", "Canada"));

        listViewEx = findViewById(R.id.listViewEx);
        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, countries
        );

        listViewEx.setAdapter(countriesAdapter);
        listViewEx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Country Selected : " + countries.get(i) , Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> genderList = new ArrayList<>(Arrays.asList("Please Select", "Male", "Female", "Other", "Ignore"));
        spinnerGender = findViewById(R.id.genderSpinner);


        ArrayAdapter genderAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderList);
        spinnerGender.setAdapter(genderAdapter);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(genderList.get(0).equals(genderList.get(i))) {
                    return;
                }
                Toast.makeText(MainActivity.this, "Gender Selected: " + genderList.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Gender Show ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}