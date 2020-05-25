package com.appsnipp.schooleducation.ui.importer;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.schooleducation.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by nasredine on 25/02/2018.
 */

public class GroupeAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<AchatGroupe> groupes;

    public GroupeAdapter(Context context, ArrayList<AchatGroupe> groupes) {
        this.groupes= groupes;
        this.context = context;
    }



    @Override
    public int getCount() {
        return groupes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return groupes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return groupes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    // on crée l'élément graphique qui affiche les éléments de la liste
    View itemView = convertView;
    if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.groupe_item, null);
    }
    // On fait un lien entre chaque composant d'un élément de la liste
    TextView libelle = (TextView) itemView.findViewById(R.id.libelle);
    TextView duree = (TextView) itemView.findViewById(R.id.duree);
    TextView magasin = (TextView) itemView.findViewById(R.id.magasin);
    TextView prix_hors_promo = (TextView) itemView.findViewById(R.id.prix_hors_promo);
    TextView prix_promo = (TextView) itemView.findViewById(R.id.prix_promo);
    ImageView logo = (ImageView) itemView.findViewById(R.id.logo);

//      attribuer les valeurs de nom,adresse du magasin
    libelle.setText(String.valueOf(groupes.get(position).getProduit().getLibelle()));
    duree.setText(String.valueOf(groupes.get(position).getDuree())+ " jours restants");
//    magasin.setText(groupes.get(position).getPromotion().getMagasin().getNom());
    prix_hors_promo.setPaintFlags(prix_hors_promo.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
    prix_promo.setText(String.valueOf(groupes.get(position).getPromotion().getPrix_promo())+ "€  " );
    prix_hors_promo.setText(String.valueOf(groupes.get(position).getPromotion().getPrix_hors_promo())+ "€ " );



    // On utilise la bibliothèque Picasso pour pouvoir charger l'image du logo magasin à travers un lien URI
        Picasso.get().load(groupes.get(position).getProduit().getImage()).into(logo);


    return itemView;
}

}



