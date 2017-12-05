package com.example.rara.beritaku.Model;

/**
 * Created by RaRa on 10/05/2017.
 */
public class ModelBerita {
    String judulBerita, deskripsi, tanggal, logoBerita, status, kategori;

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLogoBerita() {
        return logoBerita;
    }

    public void setLogoBerita(String logoBerita) {
        this.logoBerita = logoBerita;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
