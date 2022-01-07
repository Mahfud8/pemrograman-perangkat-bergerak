package com.example.catatuangku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewTransaksi extends AppCompatActivity {

    EditText edtNominal, edtketerangan, edtdate;
    RadioGroup radioGroup;
    RadioButton radioButton, rbpendapatan, rbpengeluaran;
    TransaksiViewModel transaksiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaksi);

        edtNominal = findViewById(R.id.edtnominal);
        edtketerangan = findViewById(R.id.edtketerangan);
        edtdate = findViewById(R.id.edtdate);
        radioGroup = findViewById(R.id.radioGroupsimpan);
        rbpendapatan = findViewById(R.id.rbpendapatan);
        rbpengeluaran = findViewById(R.id.rbpengeluaran);
        Waktu();

    }

    public void Save(View v) throws ParseException {
        if (edtNominal.getText().toString().equals("") ||
                edtketerangan.getText().toString().equals("") ||
                edtdate.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan lengkapi dulu", Toast.LENGTH_LONG).show();
        } else {
            int nominal = Integer.parseInt(edtNominal.getText().toString());
            String keterangan = edtketerangan.getText().toString();

            String waktu = (edtdate.getText().toString());
            
            String opsi;
            int idTerpilih = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(idTerpilih);
            opsi = radioButton.getText().toString();

            Transaksi transaksi = new Transaksi(keterangan, nominal, opsi, waktu);
            transaksiViewModel = new ViewModelProvider(this).get(TransaksiViewModel.class);
            transaksiViewModel.insert(transaksi);
            finish();
        }
    }

    public void Batal(View v) {
        finish();
    }

    public void Waktu(){
        edtdate = findViewById(R.id.edtdate);
        edtdate.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        if(mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    edtdate.setText(current);
                    edtdate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            
        });
    }
}