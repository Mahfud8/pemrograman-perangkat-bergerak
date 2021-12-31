package com.example.kalkulatorandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editangka1, editangka2;
    RadioButton rbtambah, rbkurang, rbkali, rbbagi;
    TextView txthasil;
    private ArrayList<Hasil> hasilList;
    RecyclerView recHasil;
    hasilAdapter hasilAdapter;
    SharedPreferences pref;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        pref = this.getSharedPreferences(getString(R.string.kalkulator_key), MODE_PRIVATE);
        gson = new GsonBuilder().create();

    }

    private void initData() {
        editangka1 = findViewById(R.id.editangka1);
        editangka2 = findViewById(R.id.editangka2);
        rbtambah = findViewById(R.id.rbtambah);
        rbkurang = findViewById(R.id.rbkurang);
        rbkali = findViewById(R.id.rbkali);
        rbbagi = findViewById(R.id.rbbagi);
        txthasil = findViewById(R.id.txthasil);
        recHasil = findViewById(R.id.rechasil);
    }

    public void Operasi() {
        if(editangka1.getText().toString().equals("")||editangka2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan masukan angka", Toast.LENGTH_LONG).show();

        } else {
            int angka1 = Integer.parseInt(editangka1.getText().toString());
            int angka2 = Integer.parseInt(editangka2.getText().toString());

            int hasil = 0;
            if (rbtambah.isChecked()) {
                hasil = angka1 + angka2;
                txthasil.setText(angka1 + " + " + angka2 + " = " + hasil);

            } else if (rbkurang.isChecked()) {
                hasil = angka1 - angka2;
                txthasil.setText(angka1 + " - " + angka2 + " = " + hasil);

            } else if (rbkali.isChecked()) {
                hasil = angka1 * angka2;
                txthasil.setText(angka1 + " x " + angka2 + " = " + hasil);

            } else if (rbbagi.isChecked()) {
                hasil = angka1 / angka2;
                txthasil.setText(angka1 + " / " + angka2 + " = " + hasil);
            } else {
                Toast.makeText(getApplicationContext(), "Silahkan pilih operasi dulu", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Hitung(View v) {
        Operasi();

        String strListHasil = pref.getString(getString(R.string.hasil_hitung), "[]");
        hasilList = gson.fromJson(strListHasil, new TypeToken<ArrayList<Hasil>>() {
        }.getType());

        if (hasilList == null)
            hasilList = new ArrayList<>();
        hasilList.add(new Hasil(txthasil.getText().toString()));

        strListHasil = gson.toJson(hasilList);
        pref.edit().putString(getString(R.string.hasil_hitung), strListHasil).apply();

        recHasil.setAdapter(new hasilAdapter(hasilList));
        recHasil.setLayoutManager(new LinearLayoutManager(this));
    }

    //menhapus data saat keluar aplikasi
    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        String strListHasil = pref.getString(getString(R.string.hasil_hitung), "[]");
        hasilList = gson.fromJson(strListHasil, new TypeToken<ArrayList<Hasil>>() {
        }.getType());

        pref.edit().clear().apply();
        getDelegate().onDestroy();
    }*/
}