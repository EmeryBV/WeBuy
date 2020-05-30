package com.appsnipp.schooleducation.ui.accueil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AccueilRecyclerViewMagasinsAdapter extends RecyclerView.Adapter<AccueilRecyclerViewMagasinsAdapter.ConteneurDeDonnee> {

    private ArrayList<String> imageMagasins = new ArrayList<>();
    private static DetecteurClicAccueilRecycler sDetecteurClicAccueilRecycler;

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
        Picasso.get().load(imageMagasins.get(position)).into(conteneur.logo);

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
            logo = (ImageView ) itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicAccueilRecycler.clicSurRecyclerItem(idMagasin,v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurClicAccueilRecycler detecteurClicAccueilRecycler) {
        this.sDetecteurClicAccueilRecycler = detecteurClicAccueilRecycler;
    }
}
