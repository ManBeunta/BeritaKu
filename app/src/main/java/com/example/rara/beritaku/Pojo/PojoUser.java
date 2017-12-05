package com.example.rara.beritaku.Pojo;

import java.util.List;

/**
 * Created by RaRa on 10/05/2017.
 */
public class PojoUser {

    /**
     * user : [{"id_user":"1","nama_user":"Ramadhany","email_user":"ramadhany.ananta@gmail.com","status_user":"Remaja"},{"id_user":"2","nama_user":"Yusuf Hadi","email_user":"hadiyus321@gmail.com","status_user":"Anak-Anak"},{"id_user":"3","nama_user":"Furqan","email_user":"furqan.jaya@gmail.com","status_user":"Remaja"},{"id_user":"4","nama_user":"Daffa Fawwaz Maulana","email_user":"daffafawwaz@gamil.com","status_user":"Remaja"}]
     * status : 1
     * msg : Data semua User
     */

    private String status;
    private String msg;
    private List<UserBean> user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id_user : 1
         * nama_user : Ramadhany
         * email_user : ramadhany.ananta@gmail.com
         * status_user : Remaja
         */

        private String id_user;
        private String nama_user;
        private String email_user;
        private String status_user;

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

        public String getNama_user() {
            return nama_user;
        }

        public void setNama_user(String nama_user) {
            this.nama_user = nama_user;
        }

        public String getEmail_user() {
            return email_user;
        }

        public void setEmail_user(String email_user) {
            this.email_user = email_user;
        }

        public String getStatus_user() {
            return status_user;
        }

        public void setStatus_user(String status_user) {
            this.status_user = status_user;
        }
    }
}
