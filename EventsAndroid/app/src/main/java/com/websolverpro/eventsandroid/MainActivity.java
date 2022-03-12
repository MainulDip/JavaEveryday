package com.websolverpro.eventsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClickMe = findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(this);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello Console");
                Toast.makeText(MainActivity.this, "Hello Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClickMe:
                System.out.println("Priting from interface override");
                break;
            default:
                System.out.println("Printing from default case");
                break;
        }
    }
}