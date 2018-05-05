package com.example.wiczkowski.creditmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

// ----------- To co jest pod komentarzem z niewiadomych przryczyn nie działą --------------
       // Name = getIntent().getExtras().getString("NAME");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Name" + Name);


    }

    public void dodajKredyt(View view) {
        switch (view.getId())
        {
            case R.id.buttonDodaj:
                Intent intent = new Intent(Main3Activity.this, DodajKredytActivity.class);
                startActivity(intent);
        }
    }
}
