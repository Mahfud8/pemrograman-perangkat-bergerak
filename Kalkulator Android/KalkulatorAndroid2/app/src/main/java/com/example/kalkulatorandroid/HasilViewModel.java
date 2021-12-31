package com.example.kalkulatorandroid;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HasilViewModel extends AndroidViewModel {

    HasilRepository hasilRepository;
    LiveData<List<Hasil>> hasilList;

    public HasilViewModel(@NonNull Application application) {
        super(application);
        hasilRepository = new HasilRepository(application);
        hasilList = hasilRepository.getAllHasil();
    }

    public LiveData<List<Hasil>> getAllHasil(){
        return hasilRepository.getAllHasil();
    }

    public void insert(Hasil hasil){
        hasilRepository.inserthasil(hasil);
    }
    public void delete(Hasil hasil){
        hasilRepository.deletehasil(hasil);
    }
}
