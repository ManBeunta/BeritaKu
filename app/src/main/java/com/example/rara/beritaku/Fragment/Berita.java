package com.example.rara.beritaku.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.rara.beritaku.Adapter.AdapterBerita;
import com.example.rara.beritaku.Detail.DetailBerita;
import com.example.rara.beritaku.Model.ModelBerita;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Berita extends Fragment {
    ListView LvBerita;
    ArrayList<ModelBerita> data;
    AQuery aQuery;

    public Berita() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_berita, container, false);
        LvBerita = (ListView)view.findViewById(R.id.LvBerita);
        LvBerita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelBerita b = data.get(position);
                Intent a = new Intent(getActivity(), DetailBerita.class);
                a.putExtra("deskripsi", b.getDeskripsi());
                a.putExtra("judul", b.getJudulBerita());
                a.putExtra("berita_gambar", b.getLogoBerita());
                startActivity(a);
            }
        });
        data = new ArrayList<>();
        aQuery = new AQuery(getActivity());

        getUser();
        return view;
    }
    private void getUser() {
        // buatkan String URL JSON getBerita.php
        String url = Server.BASE_URL + "getPortal.php";
        // buat progress dialog
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setTitle("Informasi");
        pd.setMessage("Sedang Mengambil Data....");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        // kirimkan url ke server
        try {
            aQuery.progress(pd).ajax(url,String.class, new AjaxCallback<String>(){
                // ambil nilai pengembalian dari server menggunakan methode callback

                @Override
                public void callback(String url, String object, AjaxStatus status) {
                    Toast.makeText(getActivity(), "Muncul Dari Tanah", Toast.LENGTH_LONG).show();
                    // kita cek apakah ada nilai pengembalian atau tidak??

                    if (object != null){
                        // ambil nilai pengembalian jika ada
                        try {
                            JSONObject json = new JSONObject(object);
                            // tampung object json ke dalam string
                            String sts = json.getString("status");
                            String msg = json.getString("msg");
                            if (sts.equalsIgnoreCase("1")){
                                // ambil object yang ada pada array data
                                JSONArray jsonArray = json.getJSONArray("berita");
                                // lakukan perulangan data
                                for (int a = 0; a <jsonArray.length(); a++){
                                    //ambil object yang ada dalam array object data
                                    JSONObject jsonObject = jsonArray.getJSONObject(a);
                                    //masukan data ke dalam model berita
                                    ModelBerita b = new ModelBerita();
                                    b.setJudulBerita(jsonObject.getString("judul"));
                                    b.setTanggal(jsonObject.getString("tanggal"));
                                    b.setKategori(jsonObject.getString("nama_kategori"));
                                    b.setLogoBerita(jsonObject.getString("berita_gambar"));
                                    b.setDeskripsi(jsonObject.getString("deskripsi"));
                                    // masukan ke dalam array list
                                    data.add(b);
                                    // setelah itu panggil dadapter berita
                                    AdapterBerita adapterBerita = new AdapterBerita(data, getActivity());
                                    // kemudian tampilkan kedalam listview
                                    LvBerita.setAdapter(adapterBerita);
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                }
            });

        }catch (Exception e){

        }
    }

}
