package com.example.webuy.ui.magasins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.webuy.R;

public class MagasinsRecyclerViewAdapter extends RecyclerView.Adapter<MagasinsRecyclerViewAdapter.ConteneurDeDonnee> {

    private ArrayList<Magasin> magasins;

    public MagasinsRecyclerViewAdapter(ArrayList<Magasin> magasins) {
        this.magasins = magasins;
    }

    @Override
    public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.magasins_recycler_item, parent, false);
        return new ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
        conteneur.nom.setText(magasins.get(position).getNom());
        conteneur.adresse.setText("Adresse: "+magasins.get(position).getRue()+", "+magasins.get(position).getVille().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return magasins.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView nom;
        TextView adresse;
        TextView promos;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            logo = (ImageView ) itemView.findViewById(R.id.imageView);
            nom = (TextView) itemView.findViewById(R.id.magasin);
            adresse = (TextView) itemView.findViewById(R.id.adresse);
            promos = (TextView) itemView.findViewById(R.id.promotions);
        }
    }

}