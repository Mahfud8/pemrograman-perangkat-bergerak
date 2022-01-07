package com.example.catatuangku;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TransaksiRepository {

    private TransaksiDAO transaksiDAO;
    private LiveData<List<Transaksi>> AllTransaksi;

    TransaksiRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        transaksiDAO = db.transaksiDAO();
        AllTransaksi = transaksiDAO.getAllTransaksi();
    }

    LiveData<List<Transaksi>> getAllTransaksi(){
        return AllTransaksi;
    }

    void insert(Transaksi transaksi){
        AppDatabase.dbWriter.execute(() ->{
            transaksiDAO.InsertTransaksi(transaksi);
        });
    }

    void delete(Transaksi transaksi){
        AppDatabase.dbWriter.execute(()->{
            transaksiDAO.DeleteTransaksi(transaksi);
        });
    }

    void Update(Transaksi transaksi){
        AppDatabase.dbWriter.execute(()->{
            transaksiDAO.UpdateTransaksi(transaksi);
        });
    }
}
