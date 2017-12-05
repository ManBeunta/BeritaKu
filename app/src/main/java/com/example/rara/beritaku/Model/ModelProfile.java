package com.example.rara.beritaku.Model;

import android.widget.BaseAdapter;

/**
 * Created by RaRa on 12/05/2017.
 */
public class ModelProfile {
    String NamaProfile, Email, NoHP, AlamatSaya, FotoSaya;

    public String getNamaProfile() {
        return NamaProfile;
    }

    public void setNamaProfile(String namaProfile) {
        NamaProfile = namaProfile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String noHP) {
        NoHP = noHP;
    }

    public String getAlamatSaya() {
        return AlamatSaya;
    }

    public void setAlamatSaya(String alamatSaya) {
        AlamatSaya = alamatSaya;
    }

    public String getFotoSaya() {
        return FotoSaya;
    }

    public void setFotoSaya(String fotoSaya) {
        FotoSaya = fotoSaya;
    }
}
