package com.annguyen.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //first button
        Button button = (Button) findViewById(R.id.btnContact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //when click button
            public void onClick(View v) {
                //go to Contact
                startActivity(new Intent(MainActivity.this, Contact.class));
            }
        });

        //second button
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            //when click button
            public void onClick(View v) {
                //go to Contact
                startActivity(new Intent(MainActivity.this, Contact2.class));
            }
        });

        //third button
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            //when click button
            public void onClick(View v) {
                //go to Contact
                startActivity(new Intent(MainActivity.this, Contact3.class));
            }
        });
    }
}
