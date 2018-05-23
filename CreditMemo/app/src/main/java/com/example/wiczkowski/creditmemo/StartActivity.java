package com.example.wiczkowski.creditmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btn_Start = (Button) findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
