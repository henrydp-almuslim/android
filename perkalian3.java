package com.example.perkalian3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText bil1;
    private EditText bil2;
    private EditText bil3;
    private Button hitung;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inisialisasi view harus di luar setOnApplyWindowInsetsListener
        bil1 = findViewById(R.id.text_bil1);
        bil2 = findViewById(R.id.text_bil2);
        bil3 = findViewById(R.id.text_bil3);
        hitung = findViewById(R.id.bt_hitung);
        hasil = findViewById(R.id.text_hasil);

        hitung.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_hitung) {
            String inputbil1 = bil1.getText().toString().trim();
            String inputbil2 = bil2.getText().toString().trim();
            String inputbil3 = bil3.getText().toString().trim();

            boolean isKosong = false;
            if (inputbil1.isEmpty()) {
                isKosong = true;
                bil1.setError("Wajib diisi!");
            }
            if (inputbil2.isEmpty()) {
                isKosong = true;
                bil2.setError("Wajib diisi!");
            }
            if (inputbil3.isEmpty()) {
                isKosong = true;
                bil3.setError("Wajib diisi!");
            }

            if (!isKosong) {
                double nilaibil1 = Double.parseDouble(inputbil1);
                double nilaibil2 = Double.parseDouble(inputbil2);
                double nilaibil3 = Double.parseDouble(inputbil3);
                double samadengan = nilaibil1 * nilaibil2 * nilaibil3;
                hasil.setText(String.valueOf(samadengan));
            }
        }
    }
}
