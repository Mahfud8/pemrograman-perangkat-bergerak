package com.example.kalkulatorandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hasilAdapter extends RecyclerView.Adapter<hasilAdapter.ViewHolder> {
    private ArrayList<Hasil> hasilList;

    public hasilAdapter(ArrayList<Hasil> hasilList) {
        this.hasilList = hasilList;
    }

    @NonNull
    @Override
    public hasilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder =new ViewHolder(inflater.inflate(R.layout.item_hitung, parent, false));

        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull hasilAdapter.ViewHolder holder, int position) {
        Hasil hasil = hasilList.get(position);
        holder.txtriwayat.setText(hasil.getHasil());

        holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Toast.makeText(holder.constraintLayout.getContext(), hasil.getHasil(),Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext())
                        .setTitle("Hapus")
                        .setMessage("Yakin ingin menghapus?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                hasilList.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return hasilList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtriwayat;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtriwayat = itemView.findViewById(R.id.txtriwayat);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
