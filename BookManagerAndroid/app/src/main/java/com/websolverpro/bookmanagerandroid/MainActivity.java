package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonAllBooks, buttonReading, buttonAlreadyRead, buttonWantToRead, buttonFavourite, buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void initViews(){
        buttonAllBooks = findViewById(R.id.buttonAllBooks);
        buttonReading = findViewById(R.id.buttonReading);
        buttonAlreadyRead = findViewById(R.id.buttonReadAlready);
        buttonWantToRead = findViewById(R.id.buttonWantToRead);
        buttonFavourite = findViewById(R.id.buttonFavourite);
        buttonAbout = findViewById(R.id.buttonAbout);
    }
}