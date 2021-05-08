package com.example.gocanadiapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adapter extends FirebaseRecyclerAdapter<Model,Adapter.ViewHolder> {

    public Adapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {
        holder.t_keterangan.setText(model.getKeterangan());
        holder.t_nama.setText(model.getNama());
        Glide.with(holder.img.getContext()).load(model.getGambar()).into(holder.img);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView t_nama, t_keterangan;
        Button b_detail;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            img = itemView.findViewById(R.id.img);
            t_nama = itemView.findViewById(R.id.t_nama);
            t_keterangan = itemView.findViewById(R.id.t_keterangan);
            b_detail = itemView.findViewById(R.id.b_detail);
        }
    }
}
