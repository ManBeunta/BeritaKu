package com.example.rara.beritaku.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.rara.beritaku.Adapter.AdapterUser;
import com.example.rara.beritaku.Model.ModelUser;
import com.example.rara.beritaku.R;
import com.example.rara.beritaku.Server.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class User extends Fragment {



    ListView LvUser;
    ArrayList<ModelUser> data;
    AQuery aQuery;

    public User() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        LvUser = (ListView)view.findViewById(R.id.LvUser);
        data = new ArrayList<>();
        aQuery = new AQuery(getActivity());

        getUser();
        return view;
    }
    private void getUser() {
        // buatkan String URL JSON getBerita.php
        String url = Server.BASE_URL + "getUser.php";
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
                                JSONArray jsonArray = json.getJSONArray("user");
                                // lakukan perulangan data
                                for (int a = 0; a <jsonArray.length(); a++){
                                    //ambil object yang ada dalam array object data
                                    JSONObject jsonObject = jsonArray.getJSONObject(a);
                                    //masukan data ke dalam model berita
                                    ModelUser b = new ModelUser();
                                    b.setNamaUser(jsonObject.getString("nama_user"));
                                    // masukan ke dalam array list
                                    data.add(b);
                                    // setelah itu panggil dadapter berita
                                    AdapterUser AdapterUser = new AdapterUser(data, getActivity());
                                    // kemudian tampilkan kedalam listview
                                    LvUser.setAdapter(AdapterUser);
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





