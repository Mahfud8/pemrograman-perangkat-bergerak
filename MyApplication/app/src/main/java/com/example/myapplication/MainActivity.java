package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainACT";

    //deklarasi Variabel -> spesifikasi tipe data
    String namabidang;
    int panjang, lebar;
    double luas, keliling;

    //deklarasi array hatus mengunakan kurung kotak
    //inisialisasi array bisa langsung mengisi value-nya atau dengan mendefinisikan ukuran array
    String databidang[] = {"lingkaran", "Persegi"};
    int datapanjang[] = new int[2];
    int datalebar[] = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // " (petik dua) untuk string
        // ' (petik satu) untuk char (karakter)

        datapanjang[0] = 15;
        datapanjang[1] = 20;

        for (int i=0; i<4; i++){
            datapanjang[i] = (i + 5) * 2;
            datalebar[i]= i * 3 + 6;
        }

            //looping/ perulanagaan
        int i = 0;
        while(i<4){
        //for (int i=0; i<4; i++) { //i++ = (i+=1)
            Log.i(TAG, "Perhitungan Ke-" + (i + 1));

            namabidang = databidang[i];
            panjang = datapanjang[i];
            lebar = datalebar[i];

            //kondisi
            if (namabidang.equalsIgnoreCase("Lingkaran")) {
                hitunglingkaran();
            } else if (namabidang.equalsIgnoreCase("Persegi")) {
                hitungpersegi();
            } else {
                Log.w(TAG, "Bidang" + namabidang + "Tidak Dikenali");
            }
            i++;
        }
    }

    public void hello(){
        System.out.println("selamat datang");

        Log.d(TAG,  "selamat datang");
        Log.i(TAG, "info android stodio");
        Log.w(TAG, "Peringatan khusus");
        Log.e(TAG,  "untuk menampilkan Error");
    }
    public void hitungpersegi(){
        luas = panjang * lebar;
        keliling = 2 * panjang + 2 * lebar;

        Log.i(TAG, "Bidang : " + namabidang);
        Log.i(TAG, "Panjang: " + panjang + ", Lebar : " + lebar);
        Log.i(TAG, "Luas : " + luas);
        Log.i(TAG, "Keliling : " + keliling);
    }
    public void hitunglingkaran(){
        double jari = panjang/2;

        luas = Math.PI * Math.pow(jari, 2);
        keliling = Math.PI * 2 * jari;

        Log.i(TAG, "Bidang : " + namabidang);
        Log.i(TAG, "Panjang: " + panjang + ", Lebar : " + lebar);
        Log.i(TAG, "Luas : " + luas);
        Log.i(TAG, "Keliling : " + keliling);
    }

    public void hitung() {
        // merubah tipe data
        byte angka = 10;
        // casting -> merubah satu tipe data ke tipe data lain yang sejenis
        angka = (byte) lebar;

        luas = panjang * lebar;
        keliling = 2 * panjang + 2 * lebar;

        Log.i(TAG, "Bidang : " + namabidang);
        Log.i(TAG, "Panjang: " + panjang + ", Lebar : " + lebar);
        Log.i(TAG, "Luas : " + luas);
        Log.i(TAG, "Keliling : " + keliling);

        String strLuas = "78.95";
        String strPanjang = "75";

        //merubah string ke int dan double
        panjang = Integer.parseInt(strPanjang);
        luas = Double.parseDouble(strPanjang) * 78;

        luas = 78.95;
        panjang = (int) luas;

        //merubah tipe data int dan double ke string
        Log.i(TAG, Double.toString(luas));
        Log.i(TAG, Integer.toString(panjang));
    }

}