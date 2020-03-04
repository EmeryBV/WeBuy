package com.example.webuy.ui.promotions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.webuy.R;
import com.example.webuy.ui.magasins.Magasin;

import java.util.ArrayList;

public class PromotionAdapter extends BaseAdapter {

    private ArrayList<Promotion> promotions;
    Context PromotionsFragment;
    View itemView;

    public PromotionAdapter(ArrayList<Promotion> promotions, Context PromotionsFragment) {
        this.promotions = promotions;
        this.PromotionsFragment = PromotionsFragment;
    }

    @Override
    public int getCount() {
        return promotions.size();
    }

    @Override
    public Object getItem(int arg0) {
        return promotions.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    PromotionsFragment.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.content_magasin, null);
        }

        return itemView;
    }
}
