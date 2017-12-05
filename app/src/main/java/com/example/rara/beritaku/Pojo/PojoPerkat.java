package com.example.rara.beritaku.Pojo;

import java.util.List;

/**
 * Created by RaRa on 15/05/2017.
 */
public class PojoPerkat {

    /**
     * tb_kategori : [{"id_kategori":"5","nama_kategori":"Fashion","kategori_logo":"fashion.png"},{"id_kategori":"4","nama_kategori":"Politik","kategori_logo":"politik.png"},{"id_kategori":"3","nama_kategori":"Islami","kategori_logo":"islam.jpg"},{"id_kategori":"2","nama_kategori":"Game","kategori_logo":"game.png"},{"id_kategori":"1","nama_kategori":"Olahraga","kategori_logo":"sport.jpg"}]
     * result : 1
     * msg : semua data Kategori
     */

    private int result;
    private String msg;
    private List<TbKategoriBean> tb_kategori;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<TbKategoriBean> getTb_kategori() {
        return tb_kategori;
    }

    public void setTb_kategori(List<TbKategoriBean> tb_kategori) {
        this.tb_kategori = tb_kategori;
    }

    public static class TbKategoriBean {
        /**
         * id_kategori : 5
         * nama_kategori : Fashion
         * kategori_logo : fashion.png
         */

        private String id_kategori;
        private String nama_kategori;
        private String kategori_logo;

        public String getId_kategori() {
            return id_kategori;
        }

        public void setId_kategori(String id_kategori) {
            this.id_kategori = id_kategori;
        }

        public String getNama_kategori() {
            return nama_kategori;
        }

        public void setNama_kategori(String nama_kategori) {
            this.nama_kategori = nama_kategori;
        }

        public String getKategori_logo() {
            return kategori_logo;
        }

        public void setKategori_logo(String kategori_logo) {
            this.kategori_logo = kategori_logo;
        }
    }
}
