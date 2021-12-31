package com.example.kalkulator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editangka1, editangka2;
    RadioButton rbtambah, rbkurang, rbkali, rbbagi;
    Button btnhitung;
    TextView txthasil;
    RecyclerView recHitung;
    private ArrayList<Hasil> hasilList;
    SharedPreferences pref;
    Gson gson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recHitung = findViewById(R.id.recHitung);
        initData();
    }


    private void initData() {
        editangka1 = findViewById(R.id.editangka1);
        editangka2 = findViewById(R.id.editangka2);
        rbtambah = findViewById(R.id.rbtambah);
        rbkurang = findViewById(R.id.rbkurang);
        rbkali = findViewById(R.id.rbkali);
        rbbagi = findViewById(R.id.rbbagi);
        btnhitung = findViewById(R.id.btnhitung);
        txthasil = findViewById(R.id.txthasil);
    }

    public void hitung(View v){
        String  strListHasil = pref.getString(getString(R.string.hasil_perhitungan),"[]");
        hasilList = gson.fromJson(strListHasil, new TypeToken<ArrayList<Hasil>>(){}.getType());
        if(hasilList == null) hasilList = new ArrayList<>();

        hasilList.add(new Hasil(txthasil.getText().toString()));

        strListHasil = gson.toJson(hasillist);
        pref.edit().putString(getString(R.string.hasil_perhitungan), strListHasil).apply();

        finish();
    }

    public void Operasi(View view){
        int angka1 = Integer.parseInt(editangka1.getText().toString());
        int angka2 = Integer.parseInt(editangka2.getText().toString());

        int hasil = 0;
        if (rbtambah.isChecked()){
            hasil = angka1 + angka2;
            txthasil.setText(angka1+" + "+angka2+" = "+hasil );
        }
        else if(rbkurang.isChecked()){
            hasil = angka1 - angka2;
            txthasil.setText(angka1+" - "+angka2+" = "+hasil );
        }
        else if(rbkali.isChecked()){
            hasil = angka1 * angka2;
            txthasil.setText(angka1+" x "+angka2+" = "+hasil );
        }
        else if(rbbagi.isChecked()){
            hasil = angka1 / angka2;
            txthasil.setText(angka1+" / "+angka2+" = "+hasil );
        }
    }
}