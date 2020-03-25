package com.appsnipp.schooleducation.ui.accueil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.appsnipp.schooleducation.R;

import java.util.ArrayList;

public class AccueilRecyclerViewMagasinsAdapter extends RecyclerView.Adapter<AccueilRecyclerViewMagasinsAdapter.ConteneurDeDonnee> {

    private ArrayList<String> imageMagasins;
    private static DetecteurClicAccueilMagasinsRecycler sDetecteurClicAccueilMagasinsRecycler;

    public AccueilRecyclerViewMagasinsAdapter(ArrayList<String> imageMagasins) {
        this.imageMagasins = imageMagasins;
    }

    @Override
    public AccueilRecyclerViewMagasinsAdapter.ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_magasins_recycler_item, parent, false);
        return new AccueilRecyclerViewMagasinsAdapter.ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(AccueilRecyclerViewMagasinsAdapter.ConteneurDeDonnee conteneur, int position) {
        //conteneur.logo.setImageResource(R.drawable.darty);
        conteneur.idMagasin = position;
    }

    @Override
    public int getItemCount() {
        return imageMagasins.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView logo;
        int idMagasin;

        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            logo = (ImageView ) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicAccueilMagasinsRecycler.clicSurRecyclerItem(idMagasin,v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurClicAccueilMagasinsRecycler detecteurClicAccueilMagasinsRecycler) {
        this.sDetecteurClicAccueilMagasinsRecycler = detecteurClicAccueilMagasinsRecycler;
    }
}
