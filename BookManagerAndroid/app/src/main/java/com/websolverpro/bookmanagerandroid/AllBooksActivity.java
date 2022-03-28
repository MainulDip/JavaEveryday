package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    public static final String ALL_BOOKS = "ALL_BOOKS";
    public static final String FAV_BOOKS = "FAV_BOOKS";
    public static final String BUTTON_TYPE = "String BUTTON_TYPE";
    public static final String READING_LIST_BOOKS = "READING_LIST_BOOKS";
    public static final String WISHLIST = "WISHLIST";
    public static final String ALREADY_READ_BOOKS = "ALREADY_READ_BOOKS";

    private RecyclerView booksRecyclerView;
    private BooksRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecyclerView = findViewById(R.id.booksRecyclerView);


        Intent intent = getIntent();

        ArrayList<Book> books = new ArrayList<>();

        if(intent != null) {

            switch (intent.getStringExtra(BUTTON_TYPE)){
                case ALL_BOOKS:
                    books = Utils.getAllBooks();
                    break;
                case FAV_BOOKS:
                    books = Utils.getFavourite();
                    break;
                case ALREADY_READ_BOOKS:
                    books = Utils.getAlreadyRead();
                    break;
                case WISHLIST:
                    books = Utils.getWishList();
                    break;
                case READING_LIST_BOOKS:
                    books = Utils.getReading();
                    break;
                default:
                    books = Utils.getAllBooks();
                    break;
            }

            adapter = new BooksRecyclerViewAdapter(this, intent.getStringExtra(BUTTON_TYPE));

            booksRecyclerView.setAdapter(adapter);

            booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter.setBooks(books);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = getIntent();

        if(intent != null && intent.getStringExtra(BUTTON_TYPE) != null && !intent.getStringExtra(BUTTON_TYPE).equals(ALL_BOOKS)) {
            Intent backIntent = new Intent(AllBooksActivity.this, MainActivity.class);
            backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
            startActivity(backIntent);
        }
    }
}