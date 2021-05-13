package com.example.gocanadiapp;
import android.os.Parcel;
import android.os.Parcelable;
public class Candi implements Parcelable {
    private String gambar, keterangan, latitude, longitude, nama;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
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
    public Candi() {
    }

    protected Candi(Parcel in) {
        nama = in.readString();
        gambar = in.readString();
        keterangan = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<Candi> CREATOR = new Creator<Candi>() {
        @Override
        public Candi createFromParcel(Parcel in) {
            return new Candi(in);
        }

        @Override
        public Candi[] newArray(int size) {
            return new Candi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(gambar);
        parcel.writeString(keterangan);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
    }
}
