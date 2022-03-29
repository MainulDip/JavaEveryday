package com.websolverpro.bookmanagerandroid;

import static com.websolverpro.bookmanagerandroid.AllBooksActivity.BUTTON_TYPE;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.ALREADY_READ_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.FAV_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.READING_LIST_BOOKS;
import static com.websolverpro.bookmanagerandroid.AllBooksActivity.WISHLIST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class BookActivity extends AppCompatActivity {

    private Button addReading, addWishlist, addFav, addAlreadyRead;
    private TextView bookName, authorName, bookPages, longDescription;
    private ImageView bookImg;
    private Book book;
    private String sampleLongDesc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n " +
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initLayoutElements();

        Intent intent = getIntent();
        if(intent != null) {
            book = (Book) intent.getSerializableExtra("TheBook");
            System.out.println(book);

            bookName.setText(book.getName());
            authorName.setText(book.getAuthor());

            Glide.with(this)
//                    .load("https://c.tenor.com/dsDEBEfUeFIAAAAC/mai-shiranui-kof.gif")
                    .load(book.getImageUrl())
                    .into(bookImg);

            /**
             * Set Click Listeners for every button on this activity
             */

//            handlerFav();
            bindClickListener(addFav, new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Utils.setFavourite(book);
                    return null;
                }
            }, "Add Favourite", Utils.getFavourite(), book, FAV_BOOKS);

            bindClickListener(addAlreadyRead, new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Utils.setAlreadyRead(book);
                    return null;
                }
            }, "Set Already Read", Utils.getAlreadyRead(), book, ALREADY_READ_BOOKS);

            bindClickListener(addWishlist, new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Utils.setWishList(book);
                    return null;
                }
            }, "Add WishList", Utils.getWishList(), book, WISHLIST);

            bindClickListener(addReading, new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Utils.setReading(book);
                    return null;
                }
            }, "Add Reading List", Utils.getReading(), book, READING_LIST_BOOKS);
        }



        longDescription.setText(sampleLongDesc);




    }



    /**
     * Helper method for crating click listeners
     * experiment with it later
     */

    private void bindClickListener(View view, Callable<Void> func, String str, ArrayList<Book> categoryList, Book incommingBook, String intentString){

        /**
         * check if book exists already in the category
         */

        Boolean bookAlreadyExists = false;
        for (Book singleBook: categoryList){
            if(singleBook.getId() == incommingBook.getId()){
                bookAlreadyExists = true;
            }
        }

        if(bookAlreadyExists){
            Toast.makeText(this, "Book Already Selected Before", Toast.LENGTH_SHORT).show();
            view.setEnabled(false);
            return;
        } else {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        func.call();
                        view.setEnabled(false);
                        Intent intent = new Intent(BookActivity.this, AllBooksActivity.class);
                        intent.putExtra(BUTTON_TYPE, intentString);
                        BookActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(BookActivity.this, book.getName()+" "+str, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initLayoutElements() {
        addReading = findViewById(R.id.btnReadingDet);
        addWishlist = findViewById(R.id.btnWishlistDet);
        addFav = findViewById(R.id.addFavDet);
        addAlreadyRead = findViewById(R.id.alreadyReadDet);

        bookName = findViewById(R.id.bookNameDet);
        authorName = findViewById(R.id.authorNameDet);
        bookPages = findViewById(R.id.pageCountDet);
        longDescription = findViewById(R.id.longDescriptionDet);

        bookImg = findViewById(R.id.bookImgDet);
    }
}