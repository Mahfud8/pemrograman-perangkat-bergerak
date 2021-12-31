package com.example.kalkulatorandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "hasil")
public class Hasil implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo
    public String hasil;

    public Hasil(String hasil){
        this.hasil = hasil;
    }

    @Override
    public String toString() {
        return this.hasil;
    }
}



