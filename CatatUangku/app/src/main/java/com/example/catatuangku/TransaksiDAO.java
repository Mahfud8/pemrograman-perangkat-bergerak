package com.example.catatuangku;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransaksiDAO {

    @Query("SELECT *FROM transaksi ")
    LiveData<List<Transaksi>> getAllTransaksi();

    @Insert
    void InsertTransaksi(Transaksi transaksi);

    @Update
    void UpdateTransaksi(Transaksi transaksi);

    @Delete
    void DeleteTransaksi(Transaksi transaksi);

}

