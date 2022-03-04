package com.websolverpro.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnClicking();
    }

    public void btnClicking(View view) {
        TextView txtHello = findViewById(R.id.idHelloWorldText);
        txtHello.setText("Java Calling");
    }
}