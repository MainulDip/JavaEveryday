package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class BookActivity extends AppCompatActivity {

    private Button reading, wishlist, addFav, alreadyRead;
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
        }

        bookName.setText(book.getName());
        authorName.setText(book.getAuthor());

        Glide.with(this)
                .load("https://c.tenor.com/dsDEBEfUeFIAAAAC/mai-shiranui-kof.gif")
                .into(bookImg);

        longDescription.setText(sampleLongDesc);
    }

    private void initLayoutElements() {
        reading = findViewById(R.id.btnReadingDet);
        wishlist = findViewById(R.id.btnWishlistDet);
        addFav = findViewById(R.id.addFavDet);
        alreadyRead = findViewById(R.id.alreadyReadDet);

        bookName = findViewById(R.id.bookNameDet);
        authorName = findViewById(R.id.authorNameDet);
        bookPages = findViewById(R.id.pageCountDet);
        longDescription = findViewById(R.id.longDescriptionDet);

        bookImg = findViewById(R.id.bookImgDet);
    }
}