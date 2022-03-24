package com.websolverpro.bookmanagerandroid;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    private Utils() {
        if( null == allBooks){
            initData();
        }
    }

    private void initData() {
        allBooks = new ArrayList<>(Arrays.asList(
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
    }

    public static Utils getInstance() {
        if(null != instance){
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }
}
