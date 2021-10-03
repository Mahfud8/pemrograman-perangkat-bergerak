package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editangka1, editangka2;
    RadioButton rbtambah, rbkurang, rbkali, rbbagi;
    Button btnhitung;
    TextView txthasil;
    ListView rview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }
    private void initComponent() {
        editangka1 = findViewById(R.id.editangka1);
        editangka2 = findViewById(R.id.editangka2);
        rbtambah = findViewById(R.id.rbtambah);
        rbkurang = findViewById(R.id.rbkurang);
        rbkali = findViewById(R.id.rbkali);
        rbbagi = findViewById(R.id.rbbagi);
        btnhitung = findViewById(R.id.btnhitung);
        txthasil = findViewById(R.id.txthasil);
    }
    public void Hitung(View view){
        int angka1 = Integer.parseInt(editangka1.getText().toString());
        int angka2 = Integer.parseInt(editangka2.getText().toString());

        int hasil = 0;
        String riwayat;
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
