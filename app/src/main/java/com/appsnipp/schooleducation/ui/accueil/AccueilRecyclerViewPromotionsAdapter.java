package com.appsnipp.schooleducation.ui.accueil;

import android.graphics.Paint;
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

public class AccueilRecyclerViewPromotionsAdapter extends RecyclerView.Adapter<AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee> {

    private ArrayList<AchatGroupe> promotions = new ArrayList<>();
    private ArrayList<String> imagePromotions = new ArrayList<>();
    private static DetecteurClicAccueilRecycler sDetecteurClicAccueilPromotionsRecycler;

    public AccueilRecyclerViewPromotionsAdapter(ArrayList<AchatGroupe> promotions) {
        this.promotions = promotions;
        imagePromotions = Data.getImageProduits();
    }

    @Override
    public AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accueil_promotions_recycler_item, parent, false);
        return new AccueilRecyclerViewPromotionsAdapter.ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {

    
        conteneur.nom.setText(Data.getProduits().get(position).getNom());
        conteneur.prix_avec_promo.setText(String.valueOf(promotions.get(position).getPrix_avec_promo())+" €");
        for (int i = 0; i < Data.getProduits().size(); i++) {
            if (Data.getProduits().get(i).getId_produit() == promotions.get(position).getId_produit()) {
                conteneur.prix_sans_promo.setText(String.valueOf(Data.getProduits().get(i).getPrix())+ " €");
                Picasso.get().load(imagePromotions.get(i)).into(conteneur.logo);
            }



        }
        conteneur.quantite_min.setText("Quantité minimum: "+promotions.get(position).getQuantite_min());
        conteneur.quantite_requise.setText("Quantité requise: "+promotions.get(position).getQuantite_min());
        conteneur.idPromotion = promotions.get(position).getId_promotion();

    }

    @Override
    public int getItemCount() {
        return 5;
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
            prix_sans_promo.setPaintFlags(prix_sans_promo.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
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