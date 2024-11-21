package com.example.pertemuan12;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuUtama extends AppCompatActivity {

    Button btnSegitiga, btnTentang, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan ID di xml dengan variabel Java
        btnSegitiga = findViewById(R.id.btnsegitiga);
        btnTentang = findViewById(R.id.btntentang);
        btnKeluar = findViewById(R.id.btnkeluar);

        // Fungsi untuk tombol luas segitiga
        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman perhitungan luas segitiga
                Intent intent = new Intent(MenuUtama.this, Segitiga.class);
                startActivity(intent);
            }
        });

        // Fungsi untuk tombol tentang aplikasi
        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman tentang
                Intent intent = new Intent(MenuUtama.this, About.class);
                startActivity(intent);
            }
        });

        // Fungsi untuk tombol keluar
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi kembali ke halaman login
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}