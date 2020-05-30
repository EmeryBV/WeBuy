package com.appsnipp.schooleducation.ui.produits;

import android.util.Log;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.data.BaseWeBuy;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.data.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nasredine on 26/02/2018.
 */

public class Produit extends BaseWeBuy {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "produits";
    private int id_produit;
    private String nom;
    private String logo;
    private Double prix;

    public static ArrayList<Produit> getAllProduit() {


        ArrayList<Produit> produits = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();
        String jsonStr = serviceWebHandler.makeServiceCall(api_url);


        if (jsonStr != null) {
            try {
                new JSONObject(jsonStr);

                JSONObject produits_json = new JSONObject(jsonStr);
                JSONObject embedded_JSON = produits_json.getJSONObject("_embedded");
                JSONArray produits_JSON = embedded_JSON.getJSONArray("produits");
                for (int y = 0; y < produits_JSON.length(); y++) {
                    JSONObject produit_JSON = produits_JSON.getJSONObject(y);
                    String nom = produit_JSON.getString("nom");
                    String logo = produit_JSON.getString("logo");
                    double prix = produit_JSON.getDouble("prix");
                    JSONObject links = produit_JSON.getJSONObject("_links");
                    //idProduit
                    JSONObject produitLinks_JSON = links.getJSONObject("produit");
                    String idProduit = produitLinks_JSON.getString("href");
                    String[] idProduitSplit = idProduit.split("s/");
                    Produit produit = new Produit();

                    produit.setId_produit(Integer.parseInt(idProduitSplit[1]));
                    produit.setNom(nom);
                    produit.setLogo(logo);
                    produit.setPrix(prix);
                    produits.add(produit);

                }
                Data.setProduits(produits);
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans Produit: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return produits;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
