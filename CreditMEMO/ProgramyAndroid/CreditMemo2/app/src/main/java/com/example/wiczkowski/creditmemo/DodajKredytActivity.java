package com.example.wiczkowski.creditmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DodajKredytActivity extends AppCompatActivity {

    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_kredyt);

        Name = (EditText)findViewById(R.id.name);

        Button save = (Button)findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Name.getText().toString();

                Intent intent = new Intent(DodajKredytActivity.this, Main3Activity.class);
                intent.putExtra("NAME", name);
                startActivity(intent);

            }
        });






    }






}
