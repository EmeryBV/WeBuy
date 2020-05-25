package com.appsnipp.schooleducation.ui.importer;

import android.util.Log;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nasredine on 26/02/2018.
 */

public class AchatGroupe extends BaseWeBuy {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "/achat-groupes?expand=promotion,produit&id_magasin=1";
    private  int id;
    private int duree;
    private int quantite_achat;
    private Promotion promotion;
    private Produit produit;
    private ArrayList<AchatGroupe> groupes;

    public int getDuree(){
        return duree;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setDuree(int duree){
        this.duree=duree;
    }

    public int getQuantite_achat(){
        return quantite_achat;
    }

    public void setQuantite_achat(int quantite_achat){
        this.quantite_achat=quantite_achat;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion getPromotion() {
        return this.promotion;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public static ArrayList<AchatGroupe> getAllGroupes() {

        Promotion promotion = new Promotion();
        ArrayList<AchatGroupe> groupes = new ArrayList<>();

        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

       Log.e(TAG, "Réponse Serveur de Groupe: " + jsonStr);

        if (jsonStr != null) {
            try {new JSONArray(jsonStr);

                // Récuperer le tableau des magasins
                JSONArray groupes_json = new JSONArray(jsonStr);

                // Pour tous les magasins

                for (int i = 0; i < groupes_json.length(); i++) {
                    // récupérer les valeurs de chaque propriété
                    JSONObject groupe_json = groupes_json.getJSONObject(i);

                    int id_achat_groupe = groupe_json.getInt("id_achat_groupe");
                    int duree = groupe_json.getInt("duree");
                    int quantite_achat = groupe_json.getInt("quantite_achat");

                    JSONObject promotionsArray =  groupe_json.getJSONObject("promotion");
                    JSONObject produitsArray =  groupe_json.getJSONObject("produit");

                    // créer un objet magasin en lui rajoutant les propriétés récupérées par json
                    AchatGroupe groupe = new AchatGroupe();
                    Produit produit = new Produit();
                    groupe.setId(id_achat_groupe);
                    groupe.setDuree(duree);
                    groupe.setPromotion(promotion.getAllPromotions(promotionsArray).get(0));
                    groupe.setProduit(produit.getAllProduit(produitsArray).get(0));
                    // réjouter le magasin à la liste des magasins
                    groupes.add(groupe);

                }
                Data.setGroupe(groupes);

            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans groupe: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON de AchatGroupe");
        }

        return groupes;

    }

}
