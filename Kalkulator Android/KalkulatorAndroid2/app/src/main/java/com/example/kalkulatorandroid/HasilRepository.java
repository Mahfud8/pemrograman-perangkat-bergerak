package com.example.kalkulatorandroid;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HasilRepository {

    private HasilDAO hasilDAO;
    private LiveData<List<Hasil>> AllHasil;

    public HasilRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        hasilDAO = db.hasilDAO();
        AllHasil = hasilDAO.getAllhasil();

    }

    public LiveData<List<Hasil>> getAllHasil(){
        return AllHasil;
    }
    public void inserthasil(Hasil hasil){
        AppDatabase.dbWriter.execute(() -> {
            hasilDAO.insertHasil(hasil);
        });
    }

    public void deletehasil(Hasil hasil){
        AppDatabase.dbWriter.execute(() -> {
            hasilDAO.deleteHasil(hasil);
        });
    }


}
