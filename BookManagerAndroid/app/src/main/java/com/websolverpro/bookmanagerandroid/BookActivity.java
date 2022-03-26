package com.websolverpro.bookmanagerandroid;

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
import java.util.function.Function;

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

            handlerFav();
        }



        longDescription.setText(sampleLongDesc);


        /**
         * Set Click Listeners for every button on this activity
         */


//        bindClickListener(addFav, Utils.setFavourite, "Add Favourite", Utils.getFavourite(), book );

        addReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.setReading(book);
                Toast.makeText(BookActivity.this, book.getName()+" Add Favourite", Toast.LENGTH_SHORT).show();
            }
        });

        addAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.setAlreadyRead(book);
                Toast.makeText(BookActivity.this, book.getName()+" Add Already Read", Toast.LENGTH_SHORT).show();
            }
        });

        addWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.setWishList(book);
                Toast.makeText(BookActivity.this, book.getName()+" Add To Wishlists", Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * already read book handler
     */

    private void handlerFav(){
        Boolean bookAlreadyExists = false;
        for (Book singleBook: Utils.getFavourite()){
            if(singleBook.getId() == book.getId()){
                bookAlreadyExists = true;
            }
        }

        if(bookAlreadyExists){
            Toast.makeText(this, "Book Already Selected Before", Toast.LENGTH_SHORT).show();
            addFav.setEnabled(false);
            return;
        } else {
            addFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utils.getInstance().setFavourite(book);
                    Toast.makeText(BookActivity.this, book.getName() + " Add Favourite", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * Helper method for crating click listeners
     * experiment with it later
     */

    private void bindClickListener(View view, Callable<Void> func, String str, ArrayList<Book> categoryList, Book incommingBook){

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