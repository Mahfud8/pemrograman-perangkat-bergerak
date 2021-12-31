package com.example.catatuangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NewTransaction extends AppCompatActivity {

    //SharedPreferences pref;
    //Gson gson;
    ArrayList<Transaksi> transactionlist;
    EditText edtNominal, edtdescription;
    RadioButton rbpendapatan, rbpengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        //pref = this.getSharedPreferences("CatatUangkukey",MODE_PRIVATE);
        //gson = new GsonBuilder().create();

        edtNominal = findViewById(R.id.edtNominal);
        edtdescription = findViewById(R.id.edtdescription);
        rbpendapatan = findViewById(R.id.rbpendapatan);
        rbpengeluaran = findViewById(R.id.rbpengeluaran);
    }

    public void Save(View v){

    }
}