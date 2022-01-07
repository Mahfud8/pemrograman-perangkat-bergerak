package com.example.catatuangku;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TransaksiViewModel extends AndroidViewModel {

    private TransaksiRepository repository;
    private LiveData<List<Transaksi>> AllTransaksi;

    public TransaksiViewModel(@NonNull Application application) {
        super(application);
        repository = new TransaksiRepository(application);
        AllTransaksi = repository.getAllTransaksi();

    }
    LiveData<List<Transaksi>> getAllTransaksi(){
        return AllTransaksi;
    }

    public void insert(Transaksi transaksi){
        repository.insert(transaksi);
    }

    public void delete(Transaksi transaksi){
        repository.delete(transaksi);
    }

    public void update(Transaksi transaksi){
        repository.Update(transaksi);
    }
}
