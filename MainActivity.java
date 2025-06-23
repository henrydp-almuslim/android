package com.example.itscollegerlist;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Adaptor adaptor;
    private String[] dataNama;
    private String[] dataNim;
    private TypedArray dataPhoto;
    private ArrayList<Mhs> mhslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adaptor = new Adaptor(this);
        listView.setAdapter(adaptor);

        persiapan();
        addItem();

        listView.setOnItemClickListener((adapterView, view, i, l) ->
                Toast.makeText(MainActivity.this, mhslist.get(i).getNama(), Toast.LENGTH_SHORT).show()
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void persiapan() {
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataNim = getResources().getStringArray(R.array.data_nim);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        mhslist = new ArrayList<>();
        for (int i = 0; i < dataNama.length; i++) {
            Mhs mhs = new Mhs();
            mhs.setPhoto(dataPhoto.getResourceId(i, -1));
            mhs.setNama(dataNama[i]);
            mhs.setNim(dataNim[i]);
            mhslist.add(mhs); // <== tambahkan ini!
        }
        adaptor.setMember(mhslist);
    }
}
