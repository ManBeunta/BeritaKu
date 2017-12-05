package com.example.rara.beritaku.MenuDrawer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.rara.beritaku.Adapter.AdapterKategori;
import com.example.rara.beritaku.Adapter.AdapterProfile;
import com.example.rara.beritaku.Detail.DetailBiasa;
import com.example.rara.beritaku.Model.ModelKategori;
import com.example.rara.beritaku.Model.ModelProfile;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    ListView LvProfile;
    ArrayList<ModelProfile> data;
    AQuery aQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setView();
        getProfile();

        LvProfile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelProfile b = data.get(position);
                Intent a = new Intent(getApplicationContext(), DetailBiasa.class);
                a.putExtra("nama_saya", b.getNamaProfile());
                a.putExtra("email_saya", b.getEmail());
                a.putExtra("hp_saya", b.getNoHP());
                a.putExtra("alamat_saya", b.getAlamatSaya());
                a.putExtra("foto_saya", b.getFotoSaya());
                startActivity(a);
            }
        });
    }

    private void getProfile() {
        // buatkan String URL JSON getBerita.php
        String url = Server.BASE_URL + "getContact.php";
        // buat progress dialog
        ProgressDialog pd = new ProgressDialog(this);
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
                                JSONArray jsonArray = json.getJSONArray("contact");
                                // lakukan perulangan data
                                for (int a = 0; a <jsonArray.length(); a++){
                                    //ambil object yang ada dalam array object data
                                    JSONObject jsonObject = jsonArray.getJSONObject(a);
                                    //masukan data ke dalam model berita
                                    ModelProfile b = new ModelProfile();
                                    b.setNamaProfile(jsonObject.getString("nama_saya"));
                                    b.setEmail(jsonObject.getString("email_saya"));
                                    b.setNoHP(jsonObject.getString("hp_saya"));
                                    b.setAlamatSaya(jsonObject.getString("alamat_saya"));
                                    b.setFotoSaya(jsonObject.getString("foto_saya"));
                                    // masukan ke dalam array list
                                    data.add(b);
                                    // setelah itu panggil dadapter berita
                                    AdapterProfile adapterProfile = new AdapterProfile(data, Profile.this);
                                    // kemudian tampilkan kedalam listview
                                    LvProfile.setAdapter(adapterProfile);
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

    private void setView() {
        LvProfile = (ListView)findViewById(R.id.LvProfile);
        data = new ArrayList<>();
        aQuery = new AQuery(this);
    }
}
