package com.example.kalkulatorandroid;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HasilDAO {

    @Query("select * from hasil")
    LiveData<List<Hasil>> getAllhasil();

    @Insert
    void insert(Hasil hasil);

    @Delete
    void delete(Hasil hasil);
}
