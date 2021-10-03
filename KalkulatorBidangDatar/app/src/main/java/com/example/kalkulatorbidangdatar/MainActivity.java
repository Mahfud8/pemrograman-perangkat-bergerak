package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText inputpad, inputlt;
    Button persegi, segitiga, lingkaran;
    TextView txtluas, txtkeliling;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }
    private void initComponent() {
        inputpad = findViewById(R.id.inputpad);
        inputlt = findViewById(R.id.inputlt);
        persegi = findViewById(R.id.persegi);
        segitiga = findViewById(R.id.segitiga);
        lingkaran = findViewById(R.id.lingkaran);
        txtluas = findViewById(R.id.txtluas);
        txtkeliling = findViewById(R.id.txtkeliling);
    }
    public void hitungpersegi(View v){
        int panjang = Integer.parseInt(inputpad.getText().toString());
        int lebar = Integer.parseInt(inputlt.getText().toString());

        double luaspersegi = panjang * lebar;
        double kelilingpersegi = 2 * panjang + 2 * lebar;

        txtluas.setText(String.valueOf(luaspersegi));
        txtkeliling.setText(String.valueOf(kelilingpersegi));
    }
    public void hitungsegitiga(View v) {
        float alas = Float.parseFloat(inputpad.getText().toString());
        float tinggi = Float.parseFloat(inputlt.getText().toString());

        float a = (float)Math.pow(tinggi, 2);
        float b = (float)Math.pow(alas / 2, 2);
        double miring = Math.sqrt(a + b);

        double luassegitiga = (alas * tinggi) / 2;
        double kelilingsegitiga = alas + miring * 2;

        txtluas.setText(String.valueOf(luassegitiga));
        txtkeliling.setText(String.valueOf(kelilingsegitiga));
    }
    public void hitunglingkaran(View v) {
        float diameter = Float.parseFloat(inputpad.getText().toString());

        double luaslingkaran = Math.PI * Math.pow(diameter / 2, 2);
        double kelilinglingkaran = Math.PI * diameter;

        txtluas.setText(String.valueOf(luaslingkaran));
        txtkeliling.setText(String.valueOf(kelilinglingkaran));
    }
}