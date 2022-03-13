package com.websolverpro.eventsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textName;
    private TextView textViewWelcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.editTextName);
        textViewWelcomeText = findViewById(R.id.textViewWelcome);

//        Always have create/set listener
        textName.setOnClickListener(this);

        Button btnClickMe = findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(this);
        btnClickMe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                System.out.println("Hello Console");
                Toast.makeText(MainActivity.this, textViewWelcomeText.getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

//        playing with checkbox

        CheckBox firstLeftCB = findViewById(R.id.leftFirstCheckBox);
        firstLeftCB.setOnClickListener(this);

        if (firstLeftCB.isChecked()){
            System.out.println("Harry potter is selected");
        }

        firstLeftCB.setChecked(false);
        firstLeftCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(MainActivity.this, "Checkbox checking/unchecking", Toast.LENGTH_SHORT).show();
                    System.out.println("Checkbox Checked Harry Potter");
                } else {
                    System.out.println("UN Checked Harry Potter");
                }

            }
        });
    }

    @Override
    public void onClick(View view) {

        String userInput = textName.getText().toString();

        switch (view.getId()){
            case R.id.btnClickMe:
                Toast.makeText(MainActivity.this, "Toast Click", Toast.LENGTH_SHORT).show();
//                textViewWelcomeText.setText(userInput);
                System.out.println("Printing from interface override");
                break;
            case R.id.editTextName:
                System.out.println("Writing Text");
                break;
            case R.id.leftFirstCheckBox:
                System.out.println("Clicking Checkbox ####");
                break;
            default:
                System.out.println("Printing from default case");
                break;
        }
    }
}