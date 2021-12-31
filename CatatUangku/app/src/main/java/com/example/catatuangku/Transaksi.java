package com.example.catatuangku;

public class Transaksi {
    private String keterangan, nominal;

    public Transaksi(String keterangan, String nominal) {
        this.keterangan = keterangan;
        this.nominal = nominal;

    }

    public String getKeterangan(){
        return keterangan;
    }
    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }
    public String getNominal(){
        return nominal;
    }
    public void setNominal(String Nominal){
        this.nominal = nominal;
    }

}
