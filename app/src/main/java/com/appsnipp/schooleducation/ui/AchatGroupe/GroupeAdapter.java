package com.appsnipp.schooleducation.ui.AchatGroupe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.ui.magasins.Magasin;
import com.appsnipp.schooleducation.ui.produits.Produit;
import com.appsnipp.schooleducation.ui.promotions.AchatGroupe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nasredine on 25/02/2018.
 */

public class GroupeAdapter extends BaseAdapter {


    private final Context context;
    private ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupes;
    private ArrayList<Magasin> magasins;
    private ArrayList<AchatGroupe> promotions;
    private ArrayList<Produit> produits;

    public GroupeAdapter(Context context, ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupes, ArrayList<Magasin> magasins, ArrayList<AchatGroupe> promotion, ArrayList<Produit> produits) {
        this.context = context;
        this.groupes = groupes;
        this.magasins = magasins;
        this.promotions = promotion;
        this.produits = produits;
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

        libelle.setText(String.valueOf(promotions.get(position).getNom()));
        magasin.setText(String.valueOf(magasins.get(promotions.get(position).getId_magasin()-1).getNom()));
        prix_promo.setText(promotions.get(position).getPrix_avec_promo() + "€  ");
        duree.setText(promotions.get(position).getDuree()+ " restant(s)");
        for (int i = 0; i < produits.size(); i++) {
//            Log.e("",String.valueOf(produits.get(i).getId_produit())+"<-- idProduit "+ String.valueOf(promotions.get(position).getId_produit()));
            if (produits.get(i).getId_produit() == promotions.get(position).getId_produit()) {
                prix_hors_promo.setText(String.valueOf(produits.get(i).getPrix()));
                Picasso.get().load(produits.get(i).getLogo()).into(logo);
                break;
            }
        }
    return itemView;
}

}



