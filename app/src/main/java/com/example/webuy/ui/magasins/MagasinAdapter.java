package com.example.webuy.ui.magasins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.webuy.R;
import com.example.webuy.Data;

import java.util.ArrayList;

public class MagasinAdapter extends BaseAdapter {

    private Data datas;
    private ArrayList<Magasin> magasins;
    Context MagasinsFragment;
    View itemView;

    public MagasinAdapter(ArrayList<Magasin> magasins, Context MagasinsFragment) {
        this.magasins = magasins;
        this.MagasinsFragment = MagasinsFragment;
    }

    @Override
    public int getCount() {
        return magasins.size();
    }

    @Override
    public Object getItem(int arg0) {
        return magasins.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    MagasinsFragment.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.content_magasin, null);
        }
        TextView tv1 = (TextView) itemView.findViewById(R.id.magasin);
        TextView tv2 = (TextView) itemView.findViewById(R.id.adresse);
        TextView tv3 = (TextView) itemView.findViewById(R.id.promotions);

        tv1.setText(magasins.get(position).getNom());
        tv2.setText("Adresse: "+magasins.get(position).getRue()+", "+magasins.get(position).getVille().toUpperCase());
        tv3.setText("Promos en cours: ");

        return itemView;
    }

}
