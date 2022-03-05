package com.websolverpro.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private Boolean counter = false;
    private CharSequence oldText;

    public void btnClicking(View view) {
        TextView txtHello = findViewById(R.id.idHelloWorldText);
        CharSequence newText = "Java Calling";

        EditText editTextName = findViewById(R.id.editTextName);


        txtHello.setText(editTextName.getText().toString());
        editTextName.setText("");
        editTextName.clearFocus();

//        if (!counter){
//            this.oldText = txtHello.getText();
//            txtHello.setText(newText);
//            this.counter = true;
//            System.out.println("Counter Initialized");
//            return;
//        }
//
//        if(txtHello.getText() == oldText){
//            txtHello.setText(newText);
//            System.out.println("Text View Value Changed to : " + txtHello.getText());
//        } else if (txtHello.getText() == newText){
//            txtHello.setText(oldText);
//            System.out.println("Text View Value Changed to : " + txtHello.getText());
//        }
    }
}

// Code is Poetry :)