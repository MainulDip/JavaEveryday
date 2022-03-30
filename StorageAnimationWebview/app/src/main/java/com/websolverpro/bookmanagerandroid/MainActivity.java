package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.BUTTON_TYPE;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALL_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.WISHLIST;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonAllBooks, buttonReading, buttonAlreadyRead, buttonWantToRead, buttonFavourite, buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Generate Data Utils
         */
        Utils.getInstance(this);

        /**
         *
         */
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);

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

        /**
         * WebView Implementation
         */

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setMessage("You're about to redirect to the official Webpage, Do you agree?");
                alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                        intent.putExtra("url", "https://websolverpro.com");
                        startActivity(intent);
                    }
                });
                alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Cancled Redirection", Toast.LENGTH_SHORT).show();
                    };
                });

                alertBuilder.create().show();
            }
        });


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

    /**
     * Define Custom Behaviour For Top Back Bytton
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}