package com.example.wiczkowski.creditmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prg=(ProgressBar)findViewById(R.id.progressBar1);
        prg.setProgress(19);

        Button btn_Dodaj = (Button) findViewById(R.id.btn_Dodaj);
        btn_Dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity()
    {
        Intent intent = new Intent(this, DodajActivity.class);
        startActivity(intent);
    }




}

