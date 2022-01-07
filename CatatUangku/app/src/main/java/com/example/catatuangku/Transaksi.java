package com.example.catatuangku;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "transaksi")
public class Transaksi implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo
    public String keterangan;
    @ColumnInfo
    public int nominal;
    @ColumnInfo
    public String opsi;
    @ColumnInfo
    public String waktu;

    public Transaksi(String keterangan, int nominal, String opsi, String waktu) {
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.opsi = opsi;
        this.waktu = waktu;

    }
    @NonNull
    @Override
    public String toString(){
        return this.keterangan + this.nominal + this.opsi + this.waktu;
    }
}
