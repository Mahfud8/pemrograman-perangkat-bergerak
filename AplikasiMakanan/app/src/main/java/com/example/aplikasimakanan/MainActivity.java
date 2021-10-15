package com.example.aplikasimakanan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView recMenu;
    private ArrayList<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMenu = findViewById(R.id.recMenu);
        initData();
        recMenu.setAdapter(new MenuAdapter(listMenu));
        recMenu.setLayoutManager(new LinearLayoutManager(this));

    }
    private void initData(){
        this.listMenu = new ArrayList<>();

        listMenu.add(new Menu("Rendang", "Rendang daging sapi asli padang", "Rp18.000", R.drawable.rendang));

        listMenu.add(new Menu("Sate Ayam", "Sate ayam madura dengan saus kacang pedas manis", "Rp25.000", R.drawable.sate));

        listMenu.add(new Menu("Nasi Goreng", "Nasi goreng spesial dengan ayam dan telur", "Rp15.000", R.drawable.nasigoreng));

        listMenu.add(new Menu("Bakso Urat", "Bakso urat sapi dengan mie kuning dan bihun", "Rp20.000", R.drawable.bakso));

        listMenu.add(new Menu("Soto Ayam", "Soto Ayam dengan Nasi", "Rp10.000", R.drawable.sotoayam));

    }
}