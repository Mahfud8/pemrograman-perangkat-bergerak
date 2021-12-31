package com.example.kalkulatorandroid;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HasilRepository {

    private HasilDAO hasilDAO;
    private AppDatabase appDatabase;
    private LiveData<List<Hasil>> hasilList;

    public HasilRepository(Application application) {
        appDatabase = AppDatabase.getDatabase(application);
        hasilDAO = appDatabase.hasilDAO();
        hasilList = hasilDAO.getAllhasil();

    }

    public LiveData<List<Hasil>> getAllHasil(){
        return hasilDAO.getAllhasil();
    }
    public void inserthasil(final Hasil hasil){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.hasilDAO().insert(hasil);
                return null;
            }
        }.execute();
    }

    public void deletehasil(final Hasil hasil){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.hasilDAO().delete(hasil);
                return null;
            }
        }.execute();
    }


}
