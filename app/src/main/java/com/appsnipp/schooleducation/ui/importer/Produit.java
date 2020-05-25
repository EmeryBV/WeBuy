package com.appsnipp.schooleducation.ui.importer;

import android.util.Log;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nasredine on 26/02/2018.
 */

class Produit extends BaseWeBuy {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "/achat-groupes?expand=promotion,produit&id_magasin=1";
    private String libelle;
    private String description;
    private String image;

    public String getLibelle(){
        return libelle;
    }




    public void setLibelle(String libelle){
        this.libelle=libelle;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image=image;
    }


    public static ArrayList<Produit> getAllProduit(JSONObject produit_json) {


        ArrayList<Produit> produits = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur de Produit: " + jsonStr);

        if (jsonStr != null) {
            try {new JSONArray(jsonStr);

                // Récuperer le tableau des produits
                JSONArray produits_json = new JSONArray(jsonStr);

                // Pour tous les produits

                for (int i = 0; i < produits_json.length(); i++) {
                    // récupérer les valeurs de chaque propriété

                    int id_produit = produit_json.getInt("id_produit");
                    String libelle = produit_json.getString("libelle");
                    String description = produit_json.getString("description");
                    String image = produit_json.getString("image");

                    // créer un objet produits en lui rajoutant les propriétés récupérées par json

                    Produit produit = new Produit();
                    produit.setLibelle(libelle);
                    produit.setDescription(description);
                    produit.setImage(image);
                    // rajouter le produit à la liste des produits
                    produits.add(produit);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans Produit: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return produits;

    }

}
