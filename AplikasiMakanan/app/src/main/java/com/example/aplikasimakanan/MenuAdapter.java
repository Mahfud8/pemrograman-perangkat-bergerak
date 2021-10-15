package com.example.aplikasimakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<Menu> listmenu;

    public MenuAdapter(ArrayList<Menu> listMenu){
        this.listmenu = listMenu;
    }
    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder= new ViewHolder(inflater.inflate(R.layout.item_makanan, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menu menu = listmenu.get(position);
        holder.txtNama.setText(menu.getNama());
        holder.txtHarga.setText(menu.getHarga());
        holder.imgFoto.setImageResource(menu.getId_gambar());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(holder.constraintLayout.getContext(), menu.getDeskripsi(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(holder.constraintLayout.getContext(), MainActivity2.class);
                intent.putExtra("txt_nama", menu.getNama());
                intent.putExtra("txt_deskripsi", menu.getDeskripsi());
                intent.putExtra("txt_harga", menu.getHarga());
                intent.putExtra("img_foto", menu.getId_gambar());

                holder.constraintLayout.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listmenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNama, txtHarga;
        public ImageView imgFoto;
        public ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txtNama);
            txtHarga = itemView.findViewById(R.id.txtHarga);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}