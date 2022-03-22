package com.websolverpro.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import androidrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> contacts = new ArrayList<>(Arrays.asList(
                new Contact("FirstName", "firstname@gmail.com", "https://64.media.tumblr.com/1e85498c54c08b65cf601a59004c3e20/tumblr_msmgp74fVH1sromnlo1_1280.png"),
                new Contact("SecondName", "secondname@gmail.com", "https://static.wikia.nocookie.net/snk/images/4/47/Kof_xv_iori_render.png"),
                new Contact("ThirdName", "thirdname@gmail.com", "https://i.pinimg.com/originals/f0/ad/ad/f0adad259f997ed9310635fea570378a.png"),
                new Contact("FourthName", "thirdname@gmail.com", "https://i.pinimg.com/originals/c7/fc/13/c7fc134dc49ab111954d83fc14251947.png"),
                new Contact("FifthName", "thirdname@gmail.com", "https://pngimage.net/wp-content/uploads/2018/06/terry-bogard-png-5.png"),
                new Contact("SixthName", "thirdname@gmail.com", "https://upload.wikimedia.org/wikipedia/en/a/a1/Kim_Kaphwan.png"),
                new Contact("SeventhName", "thirdname@gmail.com", "https://www.nicepng.com/png/detail/201-2015422_street-fighter-5-zangief-by-hes6789-street-fighter.png")
        ));

//        ArrayList<Contact> contacts = new ArrayList<>(Arrays.asList(
//                new Contact("FirstName", "firstname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("SecondName", "secondname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("ThirdName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("FourthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("FifthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("SixthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
//                new Contact("SeventhName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg")
//        ));

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);

//        Instantiate the adapter and bind/set the data and bind/set the adapter with the View (RecyclerView Layout)
        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);
        contactsRecyclerView.setAdapter(adapter);

//        Last but not least, bind layout manager with the View (RecyclerView Layout)
//        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}