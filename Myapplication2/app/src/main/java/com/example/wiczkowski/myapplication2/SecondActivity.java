package com.example.wiczkowski.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.wiczkowski.myapplication2.R.string.name;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private TextView mName;
    private TextView mDzienData;
    private TextView mMiesiacData;
    private TextView mRokData;
    private TextView mPassword;
    private TextView mIloscRatKredytu;
    private TextView mIloscWplaconcyhKredytu;
    private TextView mDzienKredytu;

    private TextView mTextView2, mTextView4;
    private TextView mNazwa1, mProcent1, mStart1, mPozostala1, mKwota1;
    private TextView metDzienDataKoniec_SL, metMiesiacDataKoniec_SL, metRokDataKoniec_SL;

    private Button btnBack;
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mName = (TextView) findViewById(R.id.nazwa1);
        mTextView2 = (TextView) findViewById(R.id.textview2);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mNazwa1 = (TextView) findViewById(R.id.textview2);
        mDzienData = (TextView) findViewById(R.id.etDzienData_SL);
        mMiesiacData = (TextView) findViewById(R.id.etMiesiacData_SL);
        mRokData = (TextView) findViewById(R.id.etRokData_SL);
        mProcent1 = (TextView) findViewById(R.id.procent1);
        metDzienDataKoniec_SL = (TextView) findViewById(R.id.etDzienDataKoniec_SL);
        metMiesiacDataKoniec_SL = (TextView) findViewById(R.id.etMiesiacDataKoniec_SL);
        metRokDataKoniec_SL = (TextView) findViewById(R.id.etRokDataKoniec_SL);
        mStart1 = (TextView) findViewById(R.id.start1);
        mPozostala1 = (TextView) findViewById(R.id.pozostala1);
        mKwota1 = (TextView) findViewById(R.id.kwota1);


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        //String name = mPreferences.getString(getString(R.string.name), "");
        //mName.setText(Integer.toString(name));
        String nazwa = mPreferences.getString(getString(name), "");
        mName.setText(nazwa);
        int nr_Password = Integer.parseInt(mPreferences.getString(getString(R.string.password), ""));
        int nr_IloscRatKredytu = Integer.parseInt(mPreferences.getString(getString(R.string.iloscratkredytu), ""));
        int nr_IloscWplaconychKredytu = Integer.parseInt(mPreferences.getString(getString(R.string.iloscwplaconychkredytu), ""));
        int nr_DzienKredytu = Integer.parseInt(mPreferences.getString(getString(R.string.dzienkredytu), ""));
        int nr_DzienData = Integer.parseInt(mPreferences.getString(getString(R.string.dziendata), ""));
        int nr_MiesiacData = Integer.parseInt(mPreferences.getString(getString(R.string.miesiacdata), ""));
        int nr_RokData = Integer.parseInt(mPreferences.getString(getString(R.string.rokdata), ""));

        int nr_DzienDataKoniec_SL = nr_DzienData;
        int nr_MiesiacDataKoniec_SL = nr_MiesiacData;
        int nr_RokDataKoniec_SL = nr_RokData;
        int nr_wplacone = ((nr_Password/nr_IloscRatKredytu)*nr_IloscWplaconychKredytu);
        double nr_PozostalaKwota = nr_Password - ((nr_Password/nr_IloscRatKredytu)*nr_IloscWplaconychKredytu);
        int nr_procent = ((((nr_Password/nr_IloscRatKredytu)*nr_IloscWplaconychKredytu) * 100) /nr_Password );

        for(int i =1; i<= nr_IloscRatKredytu; i++){
            nr_MiesiacDataKoniec_SL = nr_MiesiacDataKoniec_SL + 1;
            if ( nr_MiesiacDataKoniec_SL > 12){
                nr_MiesiacDataKoniec_SL=1;
                nr_RokDataKoniec_SL++;
            }

        }

        if(nr_DzienData > 31){
            Toast.makeText(this, "Niepoprawne wprowadzenie dnia zawarcia kredytu !", Toast.LENGTH_SHORT).show();
        }else{
            mDzienData.setText(Integer.toString(nr_DzienData));
            metDzienDataKoniec_SL.setText(Integer.toString(nr_DzienDataKoniec_SL));
        }
        if(nr_MiesiacData > 12){
            Toast.makeText(this, "Niepoprawne wprowadzenie miesiąca zawarcia kredytu !", Toast.LENGTH_SHORT).show();
        }else{
            mMiesiacData.setText(Integer.toString(nr_MiesiacData));
            metMiesiacDataKoniec_SL.setText(Integer.toString(nr_MiesiacDataKoniec_SL));
        }
        if((nr_RokData < 1950) || (nr_RokData > 2019)){
            Toast.makeText(this, "Niepoprawne wprowadzenie roku zawarcia kredytu !", Toast.LENGTH_SHORT).show();
        }else{
            mRokData.setText(Integer.toString(nr_RokData));
            metRokDataKoniec_SL.setText(Integer.toString(nr_RokDataKoniec_SL));
        }


        mKwota1.setText(Integer.toString(nr_Password));
        mTextView2.setText(Integer.toString(nr_Password));
        mStart1.setText(Integer.toString(nr_wplacone));
        mTextView4.setText(Double.toString(nr_PozostalaKwota));
        mProcent1.setText(Integer.toString(nr_procent));
        prg=(ProgressBar)findViewById(R.id.progressBar1);
        prg.setProgress(nr_procent);
        mPozostala1.setText(Double.toString(nr_PozostalaKwota));
        mKwota1.setText(Double.toString(nr_Password));





        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZmianaActivity();
            }
        });

    }

   public void ZmianaActivity(){
       Intent intent = new Intent(SecondActivity.this, MainActivity.class);
       startActivity(intent);
   }
}
