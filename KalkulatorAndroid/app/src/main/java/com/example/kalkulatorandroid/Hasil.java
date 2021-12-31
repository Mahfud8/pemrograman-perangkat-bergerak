package com.example.kalkulatorandroid;

public class Hasil {
    private String hasil;

    public Hasil(String hasil){
        this.hasil = hasil;
    }
    @Override
    public String toString() {
        return getHasil();
    }

    public String getHasil() {
        return hasil;
    }

}
