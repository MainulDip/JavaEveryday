package com.websolverpro.bookmanagerandroid;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;

    private static ArrayList<Book> reading;
    private static ArrayList<Book> wishList;
    private static ArrayList<Book> favourite;
    private static ArrayList<Book> alreadyRead;

    //    Constructor

    private Utils() {
        if( null == allBooks){
            initData();
        }

        if(reading == null) {
            reading = new ArrayList<>();
        }

        if(wishList == null) {
            wishList = new ArrayList<>();
        }

        if(favourite == null) {
            favourite = new ArrayList<>();
        }

        if(alreadyRead == null) {
            alreadyRead = new ArrayList<>();
        }
    }

//    Instance Getter: Singleton

    public static Utils getInstance() {
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }

//    Getters Setters


    public static ArrayList<Book> getReading() {
        return reading;
    }

    public static void setReading(Book reading) {
        Utils.reading.add(reading);
    }

    public static ArrayList<Book> getWishList() {
        return wishList;
    }

    public static void setWishList(Book wishList) {
        Utils.wishList.add(wishList);
    }

    public static ArrayList<Book> getFavourite() {
        return favourite;
    }

    public static void setFavourite(Book favourite) {
        Utils.favourite.add(favourite);
    }

    public static ArrayList<Book> getAlreadyRead() {
        return alreadyRead;
    }

    public static void setAlreadyRead(Book alreadyRead) {
        Utils.alreadyRead.add(alreadyRead);
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }


//    Helpers

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

}
