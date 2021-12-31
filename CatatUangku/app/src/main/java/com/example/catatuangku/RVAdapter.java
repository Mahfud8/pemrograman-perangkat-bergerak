package com.example.catatuangku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private ArrayList<Transaksi> transactionlist;

    public RVAdapter(ArrayList<Transaksi> transactionlist) {
        this.transactionlist = transactionlist;
    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder =new ViewHolder(inflater.inflate(R.layout.item_transaction, parent, false));

        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        Transaksi transaksi = transactionlist.get(position);
        holder.txtketerangan.setText(transaksi.getKeterangan());
        holder.txtnominal.setText(transaksi.getNominal());

    }

    @Override
    public int getItemCount() {
        return transactionlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtketerangan, txtnominal;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtketerangan = itemView.findViewById(R.id.txtketerangan);
            txtnominal = itemView.findViewById(R.id.txtnominal);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }
}
