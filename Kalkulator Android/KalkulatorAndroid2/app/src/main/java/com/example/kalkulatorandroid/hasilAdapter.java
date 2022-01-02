package com.example.kalkulatorandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class hasilAdapter extends RecyclerView.Adapter<hasilAdapter.ViewHolder> {
    private List<Hasil> hasilList;


    public hasilAdapter(List<Hasil> hasilList) {
        this.hasilList = hasilList;
    }


    @NonNull
    @Override
    public hasilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder =new hasilAdapter.ViewHolder(inflater.inflate(R.layout.item_hitung, parent, false));

        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final hasilAdapter.ViewHolder holder, int position) {
        Hasil hasil = hasilList.get(position);
        holder.txtriwayat.setText(hasil.hasil);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Toast.makeText(holder.constraintLayout.getContext(), hasil.getHasil(),Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Hapus");
                builder.setMessage("Yakin ingin menghapus?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppDatabase db = AppDatabase.getDatabase(view.getContext());
                        HasilDAO hasilDAO = db.hasilDAO();
                        hasilDAO.deleteHasil(hasil);
                        hasilList.get(position);
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
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
