package com.ets.yoganh;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ets.yoganh.model.DataKlub;
import com.ets.yoganh.model.Klub;

import java.util.ArrayList;
import java.util.List;

public class HalamanUtamaActivity extends AppCompatActivity implements DataKlub.KlubClickListener {
    public static final String Key_HalamanUtamaActivity="Key_HalamanUtamaActivity";

    public RecyclerView rv;
    public DataKlub dataKlub;
    public RecyclerView.LayoutManager layoutManager;
    public List<Klub> listKlub = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        rv = findViewById(R.id.rvKlub);
        listKlub.add(new Klub("1 Bali United",
                "Poin : 69",
                "https://upload.wikimedia.org/wikipedia/id/thumb/5/5e/Bali_United_logo.svg/800px-Bali_United_logo.svg.png",
                "Total Main = 31 \n"  +
                        "Menang = 21 \n "  +
                        "Seri = 6 \n" +
                        "kalah = 4 \n" +
                        "Gol Masuk = 52 \n" +
                        "Gol Kemasukan = 22 \n" +
                        "Selisih Gol = 30 "
        ));
        listKlub.add(new Klub("2 Persib",
                "Poin : 66",
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Persib_Bandung_crest_with_stars.svg/1200px-Persib_Bandung_crest_with_stars.svg.png",
                "Total Main = 31 \n"  +
                        "Menang = 20 \n "  +
                        "Seri = 6 \n" +
                        "kalah = 5 \n" +
                        "Gol Masuk = 46 \n" +
                        "Gol Kemasukan = 20 \n" +
                        "Selisih Gol = 26 "
                        ));
        listKlub.add(new Klub("3 Persebaya",
                "Poin : 59",
                "https://upload.wikimedia.org/wikipedia/en/a/a1/Persebaya_logo.svg",
                "Total Main = 31 \n"  +
                        "Menang = 17 \n "  +
                        "Seri = 8 \n" +
                        "kalah = 6 \n" +
                        "Gol Masuk = 51 \n" +
                        "Gol Kemasukan = 32 \n" +
                        "Selisih Gol = 19 "
        ));
        listKlub.add(new Klub("4 Bhayangkara FC",
                "Poin : 59",
                "https://upload.wikimedia.org/wikipedia/id/f/fe/Logo_Bhayangkara_Solo_FC.png",
                "Total Main = 31 \n"  +
                        "Menang = 17 \n "  +
                        "Seri = 8 \n" +
                        "kalah = 6 \n" +
                        "Gol Masuk = 41 \n" +
                        "Gol Kemasukan = 26 \n" +
                        "Selisih Gol = 15 "
                ));
        listKlub.add(new Klub("5 Arema",
                "Poin : 58",
                "https://upload.wikimedia.org/wikipedia/id/thumb/4/40/Logo_Arema_FC_2017_logo.svg/1200px-Logo_Arema_FC_2017_logo.svg.png",
                "Total Main = 31 \n"  +
                        "Menang = 16 \n "  +
                        "Seri = 10 \n" +
                        "kalah = 5 \n" +
                        "Gol Masuk = 38 \n" +
                        "Gol Kemasukan = 22 \n" +
                        "Selisih Gol = 16 "
        ));
        dataKlub = new DataKlub(listKlub);
        dataKlub.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(dataKlub);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Klub klub = listKlub.get(position);
        Intent apkklub = new Intent(HalamanUtamaActivity.this,HalamanDetailActivity.class);
        apkklub.putExtra(Key_HalamanUtamaActivity,klub);
        startActivity(apkklub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;//super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.halamanutama:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamandetail:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.halamantentang:
                Toast.makeText(HalamanUtamaActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;//super.onOptionsItemSelected(item);

    }
}
