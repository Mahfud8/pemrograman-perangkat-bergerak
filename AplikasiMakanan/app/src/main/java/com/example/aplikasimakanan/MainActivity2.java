package com.example.aplikasimakanan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView txtnama2, txtdeskripsi, txtharga2;
    ImageView Imgfoto2;
    int image;
    String nama, deskripsi, harga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnama2 = findViewById(R.id.textnama);
        txtdeskripsi = findViewById(R.id.textdeskripsi);
        txtharga2 = findViewById(R.id.textharga);
        Imgfoto2 = findViewById(R.id.imageView);


        nama = getIntent().getStringExtra("txt_nama");
        deskripsi = getIntent().getStringExtra("txt_deskripsi");
        harga = getIntent().getStringExtra("txt_harga");
        image =getIntent().getIntExtra("img_foto",0);

        txtnama2.setText(nama);
        txtdeskripsi.setText(deskripsi);
        txtharga2.setText(harga);
        Imgfoto2.setImageResource(image);

    }
}