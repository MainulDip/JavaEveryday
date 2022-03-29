package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALL_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.WISHLIST;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;

    private static ArrayList<Book> reading;
    private static ArrayList<Book> wishList;
    private static ArrayList<Book> favourite;
    private static ArrayList<Book> alreadyRead;

    /**
     * Shared Preferences
     */
    private SharedPreferences sharedPreferences;

    //    Constructor

    private Utils() {

//        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);
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

    public static Callable<Void> setReading(Book reading) {
        Utils.reading.add(reading);
        return null;
    }

    public static ArrayList<Book> getWishList() {
        return wishList;
    }

    public static Callable<Void> setWishList(Book wishList) {
        Utils.wishList.add(wishList);
        return null;
    }

    public static ArrayList<Book> getFavourite() {
        return favourite;
    }

    public static Runnable setFavourite(Book favourite) {
        Utils.favourite.add(favourite);
        return null;
    }

    public static ArrayList<Book> getAlreadyRead() {
        return alreadyRead;
    }

    public static Callable<Void> setAlreadyRead(Book alreadyRead) {
        Utils.alreadyRead.add(alreadyRead);
        return null;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }
    public static void deleteBook(Book book, String store) {
        switch (store){
            case ALL_BOOKS:
//                allBooks.remove(book);
                break;
            case FAV_BOOKS:
                favourite.remove(book);
                break;
            case WISHLIST:
                wishList.remove(book);
                break;
            case READING_LIST_BOOKS:
                reading.remove(book);
                break;
            case ALREADY_READ_BOOKS:
                alreadyRead.remove(book);
            default:
                break;
        }
    }





//    Helpers

    private void initData() {
        allBooks = new ArrayList<>(Arrays.asList(
                new Book(1, "FistBook", "Authorfirst", "https://www.snk-corp.co.jp/us/games/kof-xv/characters/img/character_kula.png", "small description", "This is long Description", 100),
                new Book(2, "SecondBook", "AuthorSecond", "https://static.wikia.nocookie.net/snk/images/4/47/Kof_xv_iori_render.png", "small description", "This is long Description", 100),
                new Book(3, "ThirdBook", "AuthorThird", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(4, "fourthBook", "AuthorFourth", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(5, "FistBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(6, "SecondBook", "Authorfirst", "https://pngimage.net/wp-content/uploads/2018/06/terry-bogard-png-5.png", "small description", "This is long Description", 100),
                new Book(7, "ThirdBook", "Authorfirst", "https://www.nicepng.com/png/detail/201-2015422_street-fighter-5-zangief-by-hes6789-street-fighter.png", "small description", "This is long Description", 100),
                new Book(8, "fourthBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(9, "FistBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(10, "SecondBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(11, "ThirdBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100),
                new Book(12, "fourthBook", "Authorfirst", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png", "small description", "This is long Description", 100)
        ));
    }

}
