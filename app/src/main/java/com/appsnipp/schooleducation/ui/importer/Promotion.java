package com.appsnipp.schooleducation.ui.importer;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.HttpHandler;
import com.appsnipp.schooleducation.ui.magasins.Magasin;

import java.util.ArrayList;

/**
 * Created by nasredine on 26/02/2018.
 */

public class Promotion extends BaseWeBuy {

    private double prix_hors_promo;
    private double prix_promo;
    private int quantite_min;
    private Magasin magasin;
    private Produit produit;
    private ArrayList<Magasin> magasins;

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "/achat-groupes?expand=promotion,produit&id_magasin=1";
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrix_hors_promo() {
        return prix_hors_promo;
    }

    public void setPrix_hors_promo(double prix_hors_promo) {
        this.prix_hors_promo = prix_hors_promo;
    }

    public double getPrix_promo() {
        return prix_promo;
    }

    public void setPrix_promo(double prix_promo) {
        this.prix_promo = prix_promo;
    }

    public int getQuantite_min() {
        return quantite_min;
    }

    public void setQuantite_min(int quantite_min) {
        this.quantite_min = quantite_min;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public ArrayList<Magasin> getMagasins() {
        return magasins;
    }

    public void setMagasins(ArrayList<Magasin> magasins) {
        this.magasins = magasins;
    }

    public static ArrayList<Promotion> getAllPromotions(JSONObject promotion_json ) {


        ArrayList<Promotion> promotions = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur de Promotion: " + jsonStr);

        if (jsonStr != null) {
            try {new JSONArray(jsonStr);

                // Récuperer le tableau des promotions
                JSONArray promotions_json = new JSONArray(jsonStr);

                // Pour toutes les promotions


                for (int i = 0; i < promotions_json.length(); i++) {
                    // récupérer les valeurs de chaque propriété
//                    JSONObject promotion_json = promotions_json.getJSONObject(i);


                    int id_promotion = promotion_json.getInt("id_promotion");
                    double prix_hors_promo = promotion_json.getDouble("prix_hors_promo");
                    double prix_promo = promotion_json.getDouble("prix_promo");
                    int quantite_min = promotion_json.getInt("quantite_min");
                    int id_produit = promotion_json.getInt("id_produit");
                    int id_magasin = promotion_json.getInt("id_magasin");



                    // créer un objet produits en lui rajoutant les propriétés récupérées par json
                    Magasin magasin = new Magasin();
                    Produit produit = new Produit();
                    Promotion promotion = new Promotion();
                    promotion.setMagasins(magasin.getAllMagasins());
                    promotion.setQuantite_min(quantite_min);
                    promotion.setPrix_hors_promo(prix_hors_promo);
                    promotion.setPrix_promo(prix_promo);
                    if(!Data.getMagasins().contains(magasin)){
                        promotion.setMagasin(Data.getMagasins().get(i));

                    }


                    promotions.add(promotion);
                    // rajouter le produit à la liste des produits
                }

            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans promotion : " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return promotions;

    }





}
