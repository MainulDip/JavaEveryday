package com.websolverpro.materialandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private View parentMain;
    private FloatingActionButton floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentMain = findViewById(R.id.parentMain);
        floatingBtn = findViewById(R.id.btnFloating);

        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar();
                System.out.println("Hello there");
            }
        });
    }

    private  void showSnackBar() {
        Snackbar.make(parentMain, "Hello World", BaseTransientBottomBar.LENGTH_INDEFINITE )
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("Clicking Snackbar OnClick");
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorTesting))
                .setBackgroundTint(getResources().getColor(R.color.purple_700))
                .show();

    }
}