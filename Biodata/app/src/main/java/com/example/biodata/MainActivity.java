package com.example.biodata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Alamat(View v){
        Intent it = new Intent(Intent.ACTION_VIEW);
        String url = "https://www.google.com/maps/place/6%C2%B059'10.2%22S+110%C2%B015'28.3%22E/@-6.986162,110.2573068,19z/data=!3m1!4b1!4m6!3m5!1s0x0:0x0!7e2!8m2!3d-6.9861618!4d110.2578536";
        it.setData(Uri.parse(url));
        startActivity(it);
    }
    public void Telepon(View v){
        Intent it = new Intent(Intent.ACTION_DIAL);
        String call ="tel:+6285156012049";
        it.setData(Uri.parse(call));
        startActivity(it);
    }
    public void Email (View v){
        Intent it = new Intent(Intent.ACTION_SENDTO);
        String mailto = "mailto:111202013018@mhs.dinus.ac.id";
        it.setData(Uri.parse(mailto));
        startActivity(it);
    }
}
