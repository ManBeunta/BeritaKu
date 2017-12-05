package com.example.rara.beritaku.Model;

/**
 * Created by RaRa on 10/05/2017.
 */
public class ModelKategori {
    String NamaKat, LogoKat, id_kategori;

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNamaKat() {
        return NamaKat;
    }

    public void setNamaKat(String namaKat) {
        NamaKat = namaKat;
    }

    public String getLogoKat() {
        return LogoKat;
    }

    public void setLogoKat(String logoKat) {
        LogoKat = logoKat;
    }
}
