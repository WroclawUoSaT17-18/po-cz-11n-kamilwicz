package com.example.wiczkowski.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.wiczkowski.myapplication2.R.string.name;

public class MainActivity extends AppCompatActivity {

    private  static final String TAG = "MainActivity";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName, mPassword, mdzienData, mmiesiacData, mrokData, miloscRatKredytu, miloscWplaconychKredytu, mdzienKredytu;
    private Button btnLogin;
    private Button btnView;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.etName);
        mdzienData = (EditText) findViewById(R.id.dzienData);
        mmiesiacData = (EditText) findViewById(R.id.miesiacData);
        mrokData = (EditText) findViewById(R.id.rokData);
        miloscRatKredytu = (EditText) findViewById(R.id.iloscRatKredytu);
        miloscWplaconychKredytu = (EditText) findViewById(R.id.iloscWplaconychKredytu);
        mdzienKredytu = (EditText) findViewById(R.id.dzienKredytu);
        mPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnView = (Button) findViewById(R.id.btnView);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox1);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();
        if (1==1){
            mName.setText("");
            mdzienData.setText("");
            mrokData.setText("");
            mmiesiacData.setText("");
            miloscWplaconychKredytu.setText("");
            miloscRatKredytu.setText("");
            mPassword.setText("");
            mdzienKredytu.setText("");
        }

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    zmianaActivity();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckBox.isChecked()){
                    mEditor.putString(getString(R.id.checkbox1), "True");

                }else{

                    mEditor.putString(getString(R.id.checkbox1), "True");
                    mEditor.commit();

                    //SAVE THE NAME
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();
                    mName.setText("");

                    //SAVE THE DZIEN DATA
                    String dziendata = mdzienData.getText().toString();
                    mEditor.putString(getString(R.string.dziendata),dziendata);
                    mEditor.commit();
                    mdzienData.setText("");

                    //SAVE THE MIESIAC DATA
                    String miesiacdata = mmiesiacData.getText().toString();
                    mEditor.putString(getString(R.string.miesiacdata),miesiacdata);
                    mEditor.commit();
                    mmiesiacData.setText("");

                    //SAVE THE ROK DATA
                    String rokdata = mrokData.getText().toString();
                    mEditor.putString(getString(R.string.rokdata),rokdata);
                    mEditor.commit();
                    mrokData.setText("");

                    //SAVE THE PASSWORD - kwota kredytu
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();
                    mPassword.setText("");

                    //SAVE THE ILOSC RAT KREDYTU
                    String iloscratkredytu = miloscRatKredytu.getText().toString();
                    mEditor.putString(getString(R.string.iloscratkredytu),iloscratkredytu);
                    mEditor.commit();
                    miloscRatKredytu.setText("");

                    //SAVE THE ILOSC WPLACONYCH KREDYTU
                    String iloscwplaconychkredytu = miloscWplaconychKredytu.getText().toString();
                    mEditor.putString(getString(R.string.iloscwplaconychkredytu),iloscwplaconychkredytu);
                    mEditor.commit();
                    miloscWplaconychKredytu.setText("");

                    //SAVE THE DZIEN KREDYTU
                    String dzienkredytu = mdzienKredytu.getText().toString();
                    mEditor.putString(getString(R.string.dzienkredytu),dzienkredytu);
                    mEditor.commit();
                    mdzienKredytu.setText("");

                    Toast.makeText(MainActivity.this, "Zapisano", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void zmianaActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password),"");
        String dziendata = mPreferences.getString(getString(R.string.dziendata),"");
        String miesiacdata = mPreferences.getString(getString(R.string.miesiacdata),"");
        String rokdata = mPreferences.getString(getString(R.string.rokdata),"");
        String iloscratkredytu = mPreferences.getString(getString(R.string.iloscratkredytu),"");
        String iloscwplaconychkredytu = mPreferences.getString(getString(R.string.iloscwplaconychkredytu),"");
        String dzienkredytu = mPreferences.getString(getString(R.string.dzienkredytu),"");


        mName.setText(name);
        mPassword.setText(password);
        mdzienData.setText(dziendata);
        mmiesiacData.setText(miesiacdata);
        mrokData.setText(rokdata);
        miloscRatKredytu.setText(iloscratkredytu);
        miloscWplaconychKredytu.setText(iloscwplaconychkredytu);
        mdzienKredytu.setText(dzienkredytu);

        if (checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }else{
            mCheckBox.setChecked(false);
        }

    }






}

