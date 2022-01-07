package com.example.catatuangku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private ArrayList<Transaksi> transaksiList;

    public RVAdapter(ArrayList<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder =new ViewHolder(inflater.inflate(R.layout.item_transaksi, parent, false));

        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        Transaksi transaksi = transaksiList.get(position);
        holder.txtKeterangan.setText(transaksi.keterangan);
        holder.txtNominal.setText(String.valueOf(transaksi.nominal));
        holder.txtOpsi.setText(transaksi.opsi);
        holder.txtWaktu.setText(transaksi.waktu);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, UpdateTransaksi.class);
                intent.putExtra("transaksi", transaksi);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return transaksiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtKeterangan, txtNominal, txtOpsi, txtWaktu;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtKeterangan = itemView.findViewById(R.id.txtketerangan);
            txtNominal = itemView.findViewById(R.id.txtnominal);
            txtOpsi = itemView.findViewById(R.id.txtopsi);
            txtWaktu = itemView.findViewById(R.id.txtwaktu);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }
}
