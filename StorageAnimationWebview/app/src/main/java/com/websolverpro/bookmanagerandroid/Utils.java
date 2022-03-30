package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALL_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.WISHLIST;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Utils {

    public static final String MANAGER_BOOK = "MANAGER_BOOK";

    private static Utils instance;

    private static ArrayList<Book> allBooks;

    private static ArrayList<Book> readings;
    private static ArrayList<Book> wishLists;
    private static ArrayList<Book> favourites;
    private static ArrayList<Book> alreadyReads;

    /**
     * Shared Preferences
     */
//    private static SharedPreferences spAllBooks, spReading, spWishList, spFavourite, spAlreadyRead ;
    private static SharedPreferences spManagerBook;
    private static SharedPreferences.Editor spEditor;
    private static Type collectionType = new TypeToken<ArrayList<Book>>(){}.getType();
    private static Gson gson = new Gson();
    private Context context;

    //    Constructor

    private Utils(Context context) {
        this.context = context;
        spManagerBook = context.getSharedPreferences(MANAGER_BOOK, Context.MODE_PRIVATE);
        spEditor = spManagerBook.edit();

        if( null == allBooks){

            /**
             * as getString will return default string if nothing found, we can check that for null/errors case
             */

            if(!spManagerBook.getString(ALL_BOOKS, ALL_BOOKS).equals(ALL_BOOKS)){
                allBooks = gson.fromJson(spManagerBook.getString(ALL_BOOKS, ALL_BOOKS), collectionType);
            } else {
                initData();
            }
//
//            System.out.println("sp type : " + spManagerBook.getString(ALL_BOOKS, ALL_BOOKS));
//            initData();
        }

        if(readings == null) {
            readings = new ArrayList<>();
        }

        if(wishLists == null) {
            wishLists = new ArrayList<>();
        }

        if(favourites == null) {
            favourites = new ArrayList<>();
        }

        if(alreadyReads == null) {
            alreadyReads = new ArrayList<>();
        }
    }

//    Instance Getter: Singleton

    public static Utils getInstance(Context context) {
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }

//    Getters Setters


    public static ArrayList<Book> getReadings() {
        if(!spManagerBook.getString(READING_LIST_BOOKS, READING_LIST_BOOKS).equals(READING_LIST_BOOKS)) {
            readings = gson.fromJson(spManagerBook.getString(READING_LIST_BOOKS, READING_LIST_BOOKS), collectionType);
        }
        return readings;
    }

    public static Callable<Void> setReading(Book reading) {
        Utils.readings.add(reading);
        spEditor.putString(READING_LIST_BOOKS, gson.toJson(readings));
        spEditor.commit();
        return null;
    }

    public static ArrayList<Book> getWishLists() {
        if(!spManagerBook.getString(WISHLIST, WISHLIST).equals(WISHLIST)) {
            wishLists = gson.fromJson(spManagerBook.getString(WISHLIST, WISHLIST), collectionType);
        }
        return wishLists;
    }

    public static Callable<Void> setWishList(Book wishList) {
        Utils.wishLists.add(wishList);
        spEditor.putString(WISHLIST, gson.toJson(wishLists));
        spEditor.commit();
        return null;
    }

    public static ArrayList<Book> getFavourites() {
        /**
         * Check if shared pref's FAV_BOOKS exists, if exists return from fetching.
         */
        if(!spManagerBook.getString(FAV_BOOKS, FAV_BOOKS).equals(FAV_BOOKS)) {
            favourites = gson.fromJson(spManagerBook.getString(FAV_BOOKS, FAV_BOOKS), collectionType);
        }
        return favourites;
    }

    public static Runnable setFavourite(Book favourite) {
        Utils.favourites.add(favourite);
        spEditor.putString(FAV_BOOKS, gson.toJson(favourites));
        spEditor.commit();
        return null;
    }

    public static ArrayList<Book> getAlreadyReads() {
        if(!spManagerBook.getString(ALREADY_READ_BOOKS, ALREADY_READ_BOOKS).equals(ALREADY_READ_BOOKS)) {
            favourites = gson.fromJson(spManagerBook.getString(ALREADY_READ_BOOKS, ALREADY_READ_BOOKS), collectionType);
        }
        return alreadyReads;
    }

    public static Callable<Void> setAlreadyRead(Book alreadyRead) {
        Utils.alreadyReads.add(alreadyRead);
        spEditor.putString(ALREADY_READ_BOOKS, gson.toJson(alreadyReads));
        spEditor.commit();
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
                favourites.remove(book);
                spEditor.putString(FAV_BOOKS, gson.toJson(favourites));
                spEditor.commit();
                break;
            case WISHLIST:
                wishLists.remove(book);
                spEditor.putString(WISHLIST, gson.toJson(wishLists));
                spEditor.commit();
                break;
            case READING_LIST_BOOKS:
                readings.remove(book);
                spEditor.putString(READING_LIST_BOOKS, gson.toJson(readings));
                spEditor.commit();
                break;
            case ALREADY_READ_BOOKS:
                alreadyReads.remove(book);
                spEditor.putString(ALREADY_READ_BOOKS, gson.toJson(alreadyReads));
                spEditor.commit();
            default:
                break;
        }
    }

    /**
     * Shared Preference Implementation Without Broken Changes
     * 1. Create Separate Shared Preferences for each category
     * 2. Initialize Shared Preference With Some Data. When app first load, check if shared storage is populated or not.
     * 3. Create helper function that will update the targeted storage when called
     * 4. When book/s are inserted or deleted, those functions will also call the storage updater function
     * 5. Getters will fetch data from the storage and deserialize and return
     * 6. Setters will serialize and store data to shared preference storage
     */

//    Helpers

    private void initData() {
        ArrayList<Book> data = new ArrayList<>(Arrays.asList(
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


        System.out.println("Shared Preferences : "+ spManagerBook.getString(ALL_BOOKS,"hello"));
        spEditor.putString(ALL_BOOKS, gson.toJson(data));
        spEditor.commit();

         allBooks = gson.fromJson(spManagerBook.getString(ALL_BOOKS, ALL_BOOKS), collectionType);
//        allBooks = data;



//        allBooks = new ArrayList<>();
//        if(someDat != null){
//            for(Book b: someDat){
//                allBooks.add(b);
//            }
//        }
//        System.out.println(ALL_BOOKS + allBooks);
//        System.out.println(ALL_BOOKS + someDat);

//        System.out.println("Data : "+ someDat.get(0).getName());
//        allBooks = gson.fromJson(spManagerBook.getString(ALL_BOOKS, ALL_BOOKS), collectionType);
//        spEditor.remove(ALL_BOOKS);
//        spEditor.commit();
//        System.out.println("Shared Preferences : "+ spManagerBook.getAll());
//        spEditor.clear();
//        spEditor.commit();
//        System.out.println("Shared Preferences : "+ spManagerBook.getAll());


    }

}
