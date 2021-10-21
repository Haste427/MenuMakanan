package com.dikyhadhi.kulineryntkts;

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

    private ArrayList<Kuliner> listKuliner;
    private OnRecyclerViewClickListener listener;

    public interface OnRecyclerViewClickListener{
        void Onitemclick(int position);
    }

    public void OnRecyclerViewClickListener(OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    public MenuAdapter(ArrayList<Kuliner> listKuliner) {
        this.listKuliner = listKuliner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Kuliner kuliner = listKuliner.get(position);
        holder.nama.setText(kuliner.getNama());
        holder.harga.setText(kuliner.getHarga());
        holder.id_gambar.setImageResource(kuliner.getId_gambar());

        

    }

    @Override
    public int getItemCount() {
        return listKuliner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nama, harga;
        public ImageView id_gambar;
        public ConstraintLayout itemview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = (TextView) itemView.findViewById(R.id.txt_Nam);
            harga = (TextView) itemView.findViewById(R.id.txtHarga);
            id_gambar = (ImageView) itemView.findViewById(R.id.imgFoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null && getAdapterPosition()!=RecyclerView.NO_POSITION){
                        listener.Onitemclick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
