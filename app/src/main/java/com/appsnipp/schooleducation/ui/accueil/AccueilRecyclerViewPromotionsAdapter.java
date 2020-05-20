package com.appsnipp.schooleducation.ui.accueil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.ui.promotions.DetecteurClicPromotionsRecycler;
import com.appsnipp.schooleducation.ui.promotions.Promotion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AccueilRecyclerViewPromotionsAdapter extends RecyclerView.Adapter<AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee> {

    private ArrayList<Promotion> promotions = new ArrayList<>();
    private ArrayList<Integer> imagePromotions = new ArrayList<>();
    private static DetecteurClicAccueilRecycler sDetecteurClicAccueilPromotionsRecycler;

    public AccueilRecyclerViewPromotionsAdapter(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
        imagePromotions = Data.getImagePromotions();
    }

    @Override
    public AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accueil_promotions_recycler_item, parent, false);
        return new AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee conteneur, int position) {
        conteneur.logo.setImageResource(imagePromotions.get(position));
        conteneur.nom.setText(promotions.get(position).getNomPromotion());
        conteneur.prix_avec_promo.setText("Prix promos: "+promotions.get(position).getPrixAvecPromo());
        conteneur.prix_sans_promo.setText("Prix hors promos: ");
        conteneur.quantite_min.setText("Quantité minimum: "+promotions.get(position).getQuantiteMin());
        conteneur.quantite_requise.setText("Quantité à acheter: "+promotions.get(position).getQuantiteRequise());
        conteneur.idPromotion = promotions.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView logo;
        TextView nom;
        TextView prix_avec_promo;
        TextView prix_sans_promo;
        TextView quantite_min;
        TextView quantite_requise;
        int idPromotion;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            logo = (ImageView ) itemView.findViewById(R.id.imagePromo);
            nom = (TextView) itemView.findViewById(R.id.promotion);
            prix_avec_promo = (TextView) itemView.findViewById(R.id.prix_avec_promo);
            prix_sans_promo = (TextView) itemView.findViewById(R.id.prix_sans_promo);
            quantite_min = (TextView) itemView.findViewById(R.id.quantite_min);
            quantite_requise = (TextView) itemView.findViewById(R.id.quantite_requise);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicAccueilPromotionsRecycler.clicSurRecyclerItemPromos(idPromotion,v);
        }
    }

    public void setDetecteurDeClicSurRecyclerPromos(DetecteurClicAccueilRecycler detecteurClicAccueilPromotionsRecycler) {
        this.sDetecteurClicAccueilPromotionsRecycler = detecteurClicAccueilPromotionsRecycler;
    }
}