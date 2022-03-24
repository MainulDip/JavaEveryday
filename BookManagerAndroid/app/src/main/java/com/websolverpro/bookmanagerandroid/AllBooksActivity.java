package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class AllBooksActivity extends AppCompatActivity {

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

        ArrayList<Book> books = Utils.getInstance().getAllBooks();

        adapter.setBooks(books);

    }
}