package com.example.itscollegerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptor extends BaseAdapter {
    private Context context;
    private ArrayList<Mhs> member = new ArrayList<>();

    public void setMember(ArrayList<Mhs>member){
        this.member = member;
    }

    public Adaptor(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return member.size();
    }

    @Override
    public Object getItem(int i) {
        return member.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_mhs, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Mhs mhs = (Mhs) getItem(i);
        viewHolder.bind(mhs);
        return itemView;
    }

    private class ViewHolder{
        private TextView tvNama, tvNim;
        private ImageView imgPhoto;
        ViewHolder (View view){
            tvNama = view.findViewById(R.id.nama);
            tvNim = view.findViewById(R.id.nim);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind (Mhs mhs){
            tvNama.setText(mhs.getNama());
            tvNim.setText(mhs.getNim());
            imgPhoto.setImageResource(mhs.getPhoto());
        }
    }
}
