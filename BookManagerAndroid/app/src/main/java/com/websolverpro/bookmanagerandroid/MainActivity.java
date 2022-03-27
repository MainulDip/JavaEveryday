package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.BUTTON_TYPE;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALL_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.WISHLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAllBooks, buttonReading, buttonAlreadyRead, buttonWantToRead, buttonFavourite, buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                intent.putExtra(BUTTON_TYPE, ALL_BOOKS);
                startActivity(intent);
            }
        });

        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                intent.putExtra(BUTTON_TYPE, FAV_BOOKS);
                startActivity(intent);
            }
        });

        deployClickListener(buttonReading, READING_LIST_BOOKS);
        deployClickListener(buttonAlreadyRead, ALREADY_READ_BOOKS);
        deployClickListener(buttonWantToRead, WISHLIST);


    }

    private void initViews(){
        buttonAllBooks = findViewById(R.id.buttonAllBooks);
        buttonReading = findViewById(R.id.buttonReading);
        buttonAlreadyRead = findViewById(R.id.buttonReadAlready);
        buttonWantToRead = findViewById(R.id.buttonWantToRead);
        buttonFavourite = findViewById(R.id.buttonFavourite);
        buttonAbout = findViewById(R.id.buttonAbout);
    }

    private void deployClickListener (View view, String intentExtra){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                intent.putExtra(BUTTON_TYPE, intentExtra);
                startActivity(intent);
            }
        });
    }
}