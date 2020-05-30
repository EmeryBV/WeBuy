package com.appsnipp.schooleducation.ui.AchatGroupe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.data.Data;

import java.util.ArrayList;

public class RecyclerViewGroupesAdapter extends RecyclerView.Adapter<RecyclerViewGroupesAdapter.ConteneurDeDonnee> {

    private ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupe = new ArrayList<>();

    private static DetecteurClicGroupeRecycler sDetecteurClicGroupesRecycler;
        int mIdPromotionEnCours;
    public RecyclerViewGroupesAdapter(int idPromotionEnCours,ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupe) {

        this.mIdPromotionEnCours=idPromotionEnCours;
        for (AchatGroupe achatGroupe : groupe) {
            if(achatGroupe.getId_promotion() == mIdPromotionEnCours) this.groupe.add(achatGroupe);
        }
    }



    @Override
    public RecyclerViewGroupesAdapter.ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groupes_recycler_item, parent, false);
        return new RecyclerViewGroupesAdapter.ConteneurDeDonnee(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewGroupesAdapter.ConteneurDeDonnee conteneur, int position) {

        for (int i = 0; i < Data.getGroupe().size(); i++) {
            if (Data.getGroupe().get(i).getId_groupe() == groupe.get(position).getId_groupe()) {
                conteneur.groupe1.setText("Groupe "+Data.getGroupe().get(i).getId_groupe());

            }}


    }

    @Override
    public int getItemCount() {
        return groupe.size();
    }

    public static class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView groupe1;
        int idGroupe;


        public ConteneurDeDonnee(View itemView) {
            super(itemView);
            groupe1 = (TextView) itemView.findViewById(R.id.groupe1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            sDetecteurClicGroupesRecycler.clicSurRecyclerItem(idGroupe,v);
        }
    }

    public void setDetecteurDeClicSurRecycler(DetecteurClicGroupeRecycler detecteurClicGroupelRecycler) {
        this.sDetecteurClicGroupesRecycler = detecteurClicGroupelRecycler;
    }
}
