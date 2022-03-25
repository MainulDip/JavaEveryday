package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.BUTTON_TYPE;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.SHOW_ALL_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.SHOW_ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.SHOW_FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.SHOW_READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.SHOW_WISHLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                intent.putExtra(BUTTON_TYPE, SHOW_ALL_BOOKS);
                startActivity(intent);
            }
        });

        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                intent.putExtra(BUTTON_TYPE, SHOW_FAV_BOOKS);
                startActivity(intent);
            }
        });

        deployClickListener(buttonReading, SHOW_READING_LIST_BOOKS);
        deployClickListener(buttonAlreadyRead, SHOW_ALREADY_READ_BOOKS);
        deployClickListener(buttonWantToRead, SHOW_WISHLIST);


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