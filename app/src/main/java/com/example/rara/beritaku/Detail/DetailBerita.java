package com.example.rara.beritaku.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

public class DetailBerita extends AppCompatActivity {
    TextView TxtDeskripsi, JudulTema;
    ImageView IvBack;
    String deskripsi,Logo, Judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TxtDeskripsi = (TextView)findViewById(R.id.TxtDeskripsi);
        JudulTema = (TextView)findViewById(R.id.TxtJudul);
        IvBack = (ImageView)findViewById(R.id.IvBack);

        deskripsi = getIntent().getStringExtra("deskripsi");
        Judul = getIntent().getStringExtra("judul");
        Logo = getIntent().getStringExtra("berita_gambar");

        TxtDeskripsi.setText(deskripsi);
        JudulTema.setText(Judul);

        Glide.with(this).load(Server.BASE_IMG + Logo).placeholder(R.mipmap.ic_launcher).into(IvBack);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Check it out. Your message goes here";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
            }
        });
    }
}
