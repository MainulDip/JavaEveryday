package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class AllBooksActivity extends AppCompatActivity {

    public static final String SHOW_ALL_BOOKS = "SHOW_ALL_BOOKS";
    public static final String SHOW_FAV_BOOKS = "SHOW_FAV_BOOKS";
    public static final String BUTTON_TYPE = "String BUTTON_TYPE";
    public static final String SHOW_READING_LIST_BOOKS = "SHOW_READING_LIST_BOOKS";
    public static final String SHOW_WISHLIST = "SHOW_WISHLIST";
    public static final String SHOW_ALREADY_READ_BOOKS = "SHOW_ALREADY_READ_BOOKS";

    private RecyclerView booksRecyclerView;
    private BooksRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecyclerView = findViewById(R.id.booksRecyclerView);
        adapter = new BooksRecyclerViewAdapter(this);

        booksRecyclerView.setAdapter(adapter);

        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        ArrayList<Book> books = new ArrayList<>();

        if(intent != null) {
            switch (intent.getStringExtra(BUTTON_TYPE)){
                case SHOW_ALL_BOOKS:
                    books = Utils.getInstance().getAllBooks();
                    break;
                case SHOW_FAV_BOOKS:
                    books = Utils.getInstance().getFavourite();
                    break;
                case SHOW_ALREADY_READ_BOOKS:
                    books = Utils.getAlreadyRead();
                    break;
                case SHOW_WISHLIST:
                    books = Utils.getWishList();
                    break;
                case SHOW_READING_LIST_BOOKS:
                    books = Utils.getReading();
                    break;
                default:
                    books = Utils.getInstance().getAllBooks();
                    break;
            }
        }



        adapter.setBooks(books);

    }
}