package com.example.gocanadiapp;

public class model {
    private String gambar, keterangan, latitude, longitude, nama;

    public model() {
    }

    public model(String gambar, String keterangan, String latitude, String longitude, String nama) {
        this.gambar = gambar;
        this.keterangan = keterangan;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
