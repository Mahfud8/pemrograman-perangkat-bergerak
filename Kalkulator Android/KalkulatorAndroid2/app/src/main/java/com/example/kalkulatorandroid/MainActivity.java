package com.example.kalkulatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editangka1, editangka2;
    RadioButton rbtambah, rbkurang, rbkali, rbbagi;
    TextView txthasil;
    private ArrayList<Hasil> hasilList;
    RecyclerView recHasil;
    hasilAdapter adapter;
    HasilViewModel hasilViewModel;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        hasilList = new ArrayList<>();
        db = AppDatabase.getDatabase(getApplicationContext());
        adapter = new hasilAdapter(hasilList);
        recHasil.setAdapter(adapter);
        recHasil.setLayoutManager(new LinearLayoutManager(this));
        recHasil.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        hasilViewModel = new ViewModelProvider(this).get(HasilViewModel.class);

        hasilViewModel.getAllHasil().observe(this, hasils -> {
            hasilList.clear();
            hasilList.addAll(hasils);
            adapter.notifyDataSetChanged();
        });

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
        String string = txthasil.getText().toString();

        Hasil hasil = new Hasil(string);

        hasilViewModel.insert(hasil);
    }
}