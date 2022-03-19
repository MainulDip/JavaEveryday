package com.websolverpro.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import androidrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRV = findViewById(R.id.contactsRV);

        ArrayList<Contact> contacts = new ArrayList<>(Arrays.asList(
                new Contact("FirstName", "firstname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("SecondName", "secondname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("ThirdName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("FourthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("FifthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("SixthName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg"),
                new Contact("SeventhName", "thirdname@gmail.com", "https://i.pinimg.com/736x/8d/ac/80/8dac805032916139a24513f8ff6c41a6.jpg")
        ));

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter();

        adapter.setContacts(contacts);

        contactRV.setAdapter(adapter);
//
        contactRV.setLayoutManager(new LinearLayoutManager(this));

    }
}