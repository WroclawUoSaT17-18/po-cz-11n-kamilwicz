package com.example.wiczkowski.creditmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId())
        {
            case R.id.buttonStart:
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
        }
    }
}
