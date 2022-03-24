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

        ArrayList<Book> books = new ArrayList<>(Arrays.asList(
                new Book(1, "FistBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(2, "SecondBook", "AuthorSecond", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(3, "ThirdBook", "AuthorThird", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(4, "fourthBook", "AuthorFourth", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(1, "FistBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(2, "SecondBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(3, "ThirdBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(4, "fourthBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(1, "FistBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(2, "SecondBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(3, "ThirdBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(4, "fourthBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100)
        ));

        adapter.setBooks(books);

    }
}