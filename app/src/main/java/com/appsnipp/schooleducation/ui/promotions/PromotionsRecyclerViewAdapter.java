package com.appsnipp.schooleducation.ui.promotions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.schooleducation.R;

import java.util.ArrayList;

public class PromotionsRecyclerViewAdapter extends RecyclerView.Adapter<PromotionsRecyclerViewAdapter.ConteneurDeDonnee> {

    private int mIdMagasins;
    private ArrayList<Promotion> promotions = new ArrayList<>();
    private static DetecteurClicPromotionsRecycler sDetecteurClicPromotionsRecycler;

    public PromotionsRecyclerViewAdapter(int mIdMagasins, ArrayList<Promotion> promotions) {
        this.mIdMagasins = mIdMagasins;
        for (Promotion promo: promotions){
            if (promo.getIdMagasin() == mIdMagasins) this.promotions.add(promo);
        }
    }

    @Override
    public PromotionsRecyclerViewAdapter.ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promotions_recycler_item, parent, false);
        return new PromotionsRecyclerViewAdapter.ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(PromotionsRecyclerViewAdapter.ConteneurDeDonnee conteneur, int position) {
        conteneur.nom.setText(promotions.get(position).getNomPromotion());
        conteneur.prix_avec_promo.setText("Prix promos: "+promotions.get(position).getPrixAvecPromo());
        conteneur.prix_sans_promo.setText("Prix hors promos: ");
        conteneur.quantite_min.setText("Quantité minimum: "+promotions.get(position).getQuantiteMin());
        conteneur.quantite_requise.setText("Quantité à acheter: "+promotions.get(position).getQuantiteRequise());
        conteneur.idPromotion = promotions.get(position).getIdMagasin();
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
            logo = (ImageView ) itemView.findViewById(R.id.imageView);
            nom = (TextView) itemView.findViewById(R.id.promotion);
            prix_avec_promo = (TextView) itemView.findViewById(R.id.prix_avec_promo);
            prix_sans_promo = (TextView) itemView.findViewById(R.id.prix_sans_promo);
            quantite_min = (TextView) itemView.findViewById(R.id.quantite_min);
            quantite_requise = (TextView) itemView.findViewById(R.id.quantite_requise);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicPromotionsRecycler.clicSurRecyclerItem(idPromotion,v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurClicPromotionsRecycler detecteurClicPromotionsRecycler) {
        this.sDetecteurClicPromotionsRecycler = detecteurClicPromotionsRecycler;
    }
}