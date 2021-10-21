package com.dikyhadhi.kulineryntkts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recMenu;
    private ArrayList<Kuliner> listkuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listkuliner = new ArrayList<>();
        listkuliner.add(new Kuliner("Ayam Geprek", "Harga : Rp. 12.000", R.drawable.ayamgepek));
        listkuliner.add(new Kuliner("Ayam Bakar", "Harga : Rp. 12.500", R.drawable.ayambakar));
        listkuliner.add(new Kuliner("Tempe Geprek", "Harga : Rp. 8.000", R.drawable.tempegeprek));
        listkuliner.add(new Kuliner("Pecel Lele", "Harga : Rp. 6.000", R.drawable.pecellele));
        listkuliner.add(new Kuliner("Nasi Goreng", "Harga : Rp. 10.000", R.drawable.nasigoreng));

        recMenu = findViewById(R.id.mainLayout);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        MenuAdapter adapter = new MenuAdapter(listkuliner);

        recMenu.setLayoutManager(layoutManager);
        recMenu.setAdapter(adapter);

        adapter.OnRecyclerViewClickListener(new MenuAdapter.OnRecyclerViewClickListener() {
            @Override
            public void Onitemclick(int position) {
                Intent intent = new Intent(MainActivity.this, MakananActivty.class);
                intent.putExtra("NamaINTENT", listkuliner.get(position).getNama());
                intent.putExtra("ImgINTENT", listkuliner.get(position).getId_gambar());
                intent.putExtra("HargaINTENT", listkuliner.get(position).getHarga());
                startActivity(intent);
            }
        });
    }
}