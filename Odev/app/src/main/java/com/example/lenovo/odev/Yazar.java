package com.example.lenovo.odev;

public class Yazar {
    int id;
    String baslik;
    String icerik;

    public Yazar() {
    }

    public Yazar(String baslik, String icerik) {
        this.baslik = baslik;
        this.icerik = icerik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }


}
