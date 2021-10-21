package com.dikyhadhi.kulineryntkts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MakananActivty extends AppCompatActivity {
    private ImageView idGambar;
    private TextView dtlhraga, txtDeskrip, namatxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_activty);

        idGambar = findViewById(R.id.idGambar);
        dtlhraga = findViewById(R.id.dtlhraga);
        txtDeskrip = findViewById(R.id.textDeskrip);
        namatxt = findViewById(R.id.namatxt);

        idGambar.setImageResource(getIntent().getIntExtra("ImgINTENT", R.drawable.ayamgepek));
        namatxt.setText(getIntent().getStringExtra("NamaINTENT"));
        dtlhraga.setText(getIntent().getStringExtra("HargaINTENT"));
    }
}