package com.example.catatuangku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtJmlPendapatan, txtJmlPengeluaran, txtSelisih, txtCatatan;
    RecyclerView recTransaksi;
    ArrayList<Transaksi> transaksiList;
    RVAdapter adapter;
    TransaksiViewModel transaksiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        transaksiList = new ArrayList<>();
        adapter = new RVAdapter(transaksiList);
        recTransaksi.setAdapter(adapter);
        recTransaksi.setLayoutManager(new LinearLayoutManager(this));
        recTransaksi.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        transaksiViewModel = new ViewModelProvider(this).get(TransaksiViewModel.class);
        transaksiViewModel.getAllTransaksi().observe(this, transaksis -> {
            transaksiList.clear();
            transaksiList.addAll(transaksis);
            adapter.notifyDataSetChanged();
        });
    }

    private void initData() {
        txtJmlPendapatan = findViewById(R.id.txtJmlPendapatan);
        txtJmlPengeluaran = findViewById(R.id.txtJmlPengeluaran);
        txtSelisih = findViewById(R.id.txtSelisih);
        txtCatatan = findViewById(R.id.txtCatatan);
        recTransaksi =findViewById(R.id.recTransaksi);
    }

    public void addTransaction(View v){
        Intent it = new Intent(this, NewTransaksi.class);
        startActivity(it);
    }
}