package com.appsnipp.schooleducation.ui.magasins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.ui.promotions.AchatGroupe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MagasinsRecyclerViewAdapter extends RecyclerView.Adapter<MagasinsRecyclerViewAdapter.ConteneurDeDonnee> {

    private ArrayList<Magasin> magasins;
    private ArrayList<AchatGroupe> promotions;
    private ArrayList<String> imageMagasins = new ArrayList<>();
    private static DetecteurClicMagasinsRecycler sDetecteurClicMagasinsRecycler;

    public MagasinsRecyclerViewAdapter(ArrayList<Magasin> magasins, ArrayList<AchatGroupe> promotions) {
        this.magasins = magasins;
        this.promotions = promotions;
        imageMagasins = Data.getImageMagasins();
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
        conteneur.adresse.setText("Adresse: "+magasins.get(position).getAdresse());
        conteneur.promos.setText("Promos en cours: "+countPromos(position));
        conteneur.idMagasin = magasins.get(position).getId_magasin();
        Picasso.get().load(magasins.get(position).getLogo()).into(conteneur.logo);
    }

    private int countPromos(int position) {
        int total = 0;
        for (AchatGroupe promo: promotions) {
            if (promo.getId() == magasins.get(position).getId()) total++;
        }
        return total;
    }

    @Override
    public int getItemCount() {
        return magasins.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView logo;
        TextView nom;
        TextView adresse;
        TextView promos;
        int idMagasin;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            logo = (ImageView ) itemView.findViewById(R.id.imageMagasin);
            nom = (TextView) itemView.findViewById(R.id.magasin);
            adresse = (TextView) itemView.findViewById(R.id.adresse);
            promos = (TextView) itemView.findViewById(R.id.promotions);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicMagasinsRecycler.clicSurRecyclerItem(idMagasin,v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurClicMagasinsRecycler detecteurClicMagasinsRecycler) {
        this.sDetecteurClicMagasinsRecycler = detecteurClicMagasinsRecycler;
    }
}