package com.example.gocanadiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String nama, gambar, keterangan;

    public detailFragment() {
    }

    public detailFragment(String nama, String gambar, String keterangan) {
        this.nama = nama;
        this.gambar = gambar;
        this.keterangan = keterangan;
    }


    public static detailFragment newInstance(String param1, String param2) {
        detailFragment fragment = new detailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView img_detail = view.findViewById(R.id.img_detail);
        TextView t_namaDetail = view.findViewById(R.id.t_namaDetail);
        TextView t_ketDetail = view.findViewById(R.id.t_ketDetail);
        ImageView img_location = view.findViewById(R.id.img_location);

        t_namaDetail.setText(nama);
        t_ketDetail.setText(keterangan);
        Glide.with(getContext()).load(gambar).into(img_detail);

        img_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public void backPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new dataFragment()).addToBackStack(null).commit();

    }

}