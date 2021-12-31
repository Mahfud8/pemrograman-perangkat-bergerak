package com.example.simplenotes;

public class Notes {
    String judul, catatan;

    public Notes(String judul, String catatan){
        this.judul = judul;
        this.catatan = catatan;
    }

    @Override
    public String toString() {
        return judul + '\n' + "------------- \n" + catatan + "\n ============ \n";
    }
}
