package com.example.catatuangku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtJmlPendapatan, txtJmlPengeluaran, txtSelisih, txtCatatan;
    RecyclerView recTransaksi;
    private ArrayList<Transaksi> transactionlist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJmlPendapatan = findViewById(R.id.txtJmlPendapatan);
        txtJmlPengeluaran = findViewById(R.id.txtJmlPengeluaran);
        txtSelisih = findViewById(R.id.txtSelisih);
        txtCatatan = findViewById(R.id.txtCatatan);

        recTransaksi =findViewById(R.id.recTransaksi);
        recTransaksi.setAdapter(new RVAdapter(transactionlist));
        recTransaksi.setLayoutManager(new LinearLayoutManager(this));


    }

    


    public void addTransaction(View v){
        Intent it = new Intent(this, NewTransaction.class);
        startActivity(it);
    }
}