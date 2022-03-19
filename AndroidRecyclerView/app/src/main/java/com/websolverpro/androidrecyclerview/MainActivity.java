package com.websolverpro.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import androidrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRV = findViewById(R.id.contactsRV);


    }
}