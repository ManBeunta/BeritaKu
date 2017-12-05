package com.example.rara.beritaku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rara.beritaku.Pojo.PojoPerkat;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

import java.util.List;

/**
 * Created by RaRa on 15/05/2017.
 */
public class AdapterPerkat extends BaseAdapter {

    List<PojoPerkat.TbKategoriBean> data;
    Context context;

    public AdapterPerkat(List<PojoPerkat.TbKategoriBean> data, Context context) {
        this.data = data;
        this.context = context;
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

    public class ViewHolder {
        TextView txtPerkat;
        ImageView imgPerkat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        AdapterPerkat.ViewHolder holder = null;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_gambar, null);
            holder = new AdapterPerkat.ViewHolder();
            holder.txtPerkat = (TextView) v.findViewById(R.id.TxtTulis);
            holder.imgPerkat = (ImageView) v.findViewById(R.id.IvGambar);
            v.setTag(holder);
        } else {
            holder = (AdapterPerkat.ViewHolder) v.getTag();
        }

        holder.txtPerkat.setText(data.get(position).getNama_kategori());
//        Picasso.with(context).load(Server.BASE_URL_IMG+ data.get(position).getPondok_img())
//                .placeholder(R.mipmap.ic_launcher).into(holder.imgbg);

        Glide.with(context).load(Server.BASE_IMG + data.get(position).getKategori_logo())
                .placeholder(R.mipmap.ic_launcher).into(holder.imgPerkat);

        return v;
    }

}
