package com.appsnipp.schooleducation.ui.magasins;

import android.os.Build;
import android.util.Log;

import androidx.fragment.app.FragmentTransaction;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.HttpHandler;
import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.ui.importer.BaseWeBuy;
import com.appsnipp.schooleducation.ui.importer.Promotion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nasredine on 25/02/2018.
 */

public class Magasin extends BaseWeBuy {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "/magasins";

    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    private String logo; // chaîne de caractère représente le lien  vers l'image du logo

    // liste des promos d'un magasin, à récupérer aussi via le service Web
    private ArrayList<Promotion> promotions;



    /**
     * renvoyer tous les magasins qui proposent des promos
     *
     * @return
     */

    public static ArrayList<Magasin> getAllMagasins() {


        ArrayList<Magasin> magasins = new ArrayList<>();

        HttpHandler serviceWebHandler = new HttpHandler();

        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String jsonStr = serviceWebHandler.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur de Magasin: " + jsonStr);

        if (jsonStr != null) {
            try {new JSONArray(jsonStr);

                // Récuperer le tableau des magasins
                JSONArray magasins_json = new JSONArray(jsonStr);

                // Pour tous les magasins

                for (int i = 0; i < magasins_json.length(); i++) {
                    // récupérer les valeurs de chaque propriété
                    JSONObject magasin_json = magasins_json.getJSONObject(i);


                    int id_magasin = magasin_json.getInt("id_magasin");
                    String nom = magasin_json.getString("nom");
                    String adresse = magasin_json.getString("adresse");
                    double latitude = magasin_json.getDouble("latitude");
                    double longitude = magasin_json.getDouble("longitude");
                    String logo = magasin_json.getString("logo");

                    // créer un objet magasin en lui rajoutant les propriétés récupérées par json

                    Magasin magasin = new Magasin();
                    magasin.setId(id_magasin);
                    magasin.setNom(nom);
                    magasin.setLongitude(latitude);
                    magasin.setLatitude(longitude);
                    magasin.setAdresse(adresse);
                    magasin.setLogo(logo);
                    // réjouter le magasin à la liste des magasins
                    magasins.add(magasin);

                }

                Data.setMagasins(magasins);
                Data.setImageMagasins();
//                for(int i =0 ; i <Data.getImageMagasins2().size();i++) {
//                   Log.i("IMAGE MAGASIN" ,Data.getImageMagasins2().get(i));
//
//                }


            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans Magasin: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return magasins;

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


}