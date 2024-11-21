package com.example.pertemuan12;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Segitiga extends AppCompatActivity {

    EditText edAlas, edTinggi, edHasil;
    Button btnHitung, btnHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Komponen
        edAlas = findViewById(R.id.edalas);
        edTinggi = findViewById(R.id.edtinggi);
        edHasil = findViewById(R.id.edhasil);
        btnHitung = findViewById(R.id.bthitung);
        btnHapus = findViewById(R.id.bthapus);

        // Fungsi tombol hitung
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasSegitiga();
            }
        });

        // Fungsi tombol hapus
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusInput();
            }
        });
    }

    private void hitungLuasSegitiga() {
        // Ambil nilai dari input
        String strAlas = edAlas.getText().toString();
        String strTinggi = edTinggi.getText().toString();

        // Validasi Input
        if (TextUtils.isEmpty(strAlas)) {
            edAlas.setError("Nilai alas tidak boleh kosong!");
            return;
        }

        if (TextUtils.isEmpty(strTinggi)) {
            edTinggi.setError("Nilai tinggi tidak boleh kosong !");
            return;
        }

        try {
            // Konversi nilai input ke angka
            double alas = Double.parseDouble(strAlas);
            double tinggi = Double.parseDouble(strTinggi);

            // Hitung luas
            double luas = 0.5 * alas * tinggi;

            // Tampilkan hasil
            edHasil.setText(String.valueOf(luas));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Input harus berupa angka!", Toast.LENGTH_SHORT).show();
        }
    }

    private void hapusInput() {
        // Kosongkan semua input
        edAlas.setText("");
        edTinggi.setText("");
        edHasil.setText("");
        edAlas.requestFocus();
    }
}