package com.example.rara.beritaku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rara.beritaku.Model.ModelUser;
import com.example.rara.beritaku.R;

import java.util.ArrayList;

/**
 * Created by RaRa on 09/05/2017.
 */
public class AdapterUser extends BaseAdapter {
    //buat array list model berita
    ArrayList<ModelUser> data;
    Context c;
    //buat construktor
    //agar bisa di panggil oleh activity yang menggunakan adapter
    public AdapterUser(ArrayList<ModelUser> data, Context c) {
        this.data = data;
        this.c = c;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    // buatkan class untuk menampung widget yang kita gunakan
    public class ViewHolder{
        TextView nama;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View v = convertView;
        //
        if (v == null){
            //panggil layout list_berita
            LayoutInflater layoutInflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.list_biasa, null);
            holder = new ViewHolder();
            //kenalkan widget by id
            holder.nama = (TextView)v.findViewById(R.id.TxtListBiasa);
            // set v nya
            v.setTag(holder);
        }else {
            holder = (ViewHolder)v.getTag();
        }
        // set deta kedalam image view dan text view
        ModelUser ModelUser = data.get(position);
        holder.nama.setText(ModelUser.getNamaUser());
        // tampilkan gambar ke dalam image view

        // http://192.168.4.123/berita/foto_berita/nama file dati database
        // format untuk menggunakan glide : context / url / widget
        return v;
    }
}