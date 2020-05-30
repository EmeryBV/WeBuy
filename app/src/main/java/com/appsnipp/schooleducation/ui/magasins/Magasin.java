package com.appsnipp.schooleducation.ui.magasins;

import android.util.Log;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.data.BaseWeBuy;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.data.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nasredine on 25/02/2018.
 */

public class Magasin extends BaseWeBuy {


    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "magasins";
    private int id_magasin;
    private String adresse;
    private double latitude;
    private String logo;
    private double longitude;
    private String nom;


    public static ArrayList<Magasin> getAllMagasins() {

        ArrayList<Magasin> magasins = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();
        String jsonStr = serviceWebHandler.makeServiceCall(api_url);


        if (jsonStr != null) {
            try {
                new JSONObject(jsonStr);

                JSONObject magasins_json = new JSONObject(jsonStr);
                JSONObject embedded_JSON = magasins_json.getJSONObject("_embedded");
                JSONArray magasins_JSON = embedded_JSON.getJSONArray("magasins");
                for (int y = 0; y < magasins_JSON.length(); y++) {
                    JSONObject magasin_JSON = magasins_JSON.getJSONObject(y);
                    String nom = magasin_JSON.getString("nom");
                    String adresse = magasin_JSON.getString("adresse");
                    String logo = magasin_JSON.getString("logo");
                    double latitude = magasin_JSON.getDouble("latitude");
                    double longitude = magasin_JSON.getDouble("longitude");

                   //idMagasin
                    JSONObject links = magasin_JSON.getJSONObject("_links");
                    JSONObject magasinLinks_JSON = links.getJSONObject("magasin");
                    String idMagasin = magasinLinks_JSON.getString("href");
                    String[] idMagasinSplit = idMagasin.split("s/");

                    Magasin magasin = new Magasin();

                    magasin.setId_magasin(Integer.parseInt(idMagasinSplit[1]));
                    magasin.setNom(nom);
                    magasin.setLongitude(latitude);
                    magasin.setLatitude(longitude);
                    magasin.setAdresse(adresse);
                    magasin.setLogo(logo);
                    magasins.add(magasin);

                    HttpHandler testPost = new HttpHandler();
                    HashMap<String,String> test = new HashMap();
                    test.put("id_magasin","45");
                    testPost.performPostCall(api_url,test);
                }

                Data.setMagasins(magasins);
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans Magasin: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return magasins;

    }

    public static HashMap<String, String>   sendPost( HashMap<String, String> postDataParams){

        return postDataParams;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}