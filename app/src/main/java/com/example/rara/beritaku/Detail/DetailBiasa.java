package com.example.rara.beritaku.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

public class DetailBiasa extends AppCompatActivity {
    String Nama, Email, Hp, Alamat, Foto;
    TextView TxtNama, TxtEmailSaya, TxtHP, TxtAlamat;
    ImageView IvProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_biasa);
        TxtNama = (TextView)findViewById(R.id.TxtNamaSaya);
        TxtEmailSaya = (TextView)findViewById(R.id.TxtEmailSaya);
        TxtHP = (TextView)findViewById(R.id.TxtHP);
        TxtAlamat = (TextView)findViewById(R.id.TxtAlamat);
        IvProfile = (ImageView)findViewById(R.id.IvProfile);

        Nama = getIntent().getStringExtra("nama_saya");
        Email = getIntent().getStringExtra("email_saya");
        Hp = getIntent().getStringExtra("hp_saya");
        Alamat = getIntent().getStringExtra("alamat_saya");
        Foto = getIntent().getStringExtra("foto_saya");

        TxtNama.setText(Nama);
        TxtEmailSaya.setText(Email);
        TxtHP.setText(Hp);
        TxtAlamat.setText(Foto);

        Glide.with(this).load(Server.BASE_IMG + Foto).placeholder(R.mipmap.ic_launcher).into(IvProfile);

    }
}
