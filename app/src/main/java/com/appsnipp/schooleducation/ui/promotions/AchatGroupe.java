package com.appsnipp.schooleducation.ui.promotions;

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

public class AchatGroupe extends BaseWeBuy {
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "promotions";
    private int id_promotion;
    private String description;
    private String duree;
    private String nom;
    private double prix_avec_promo;
    private int quantite_max;
    private int quantite_min;
    private int stock;
    private int id_magasin;
    private int id_produit;


    public static ArrayList<AchatGroupe> getAllPromotions() {

        ArrayList<AchatGroupe> promotions = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();
        String jsonStr = serviceWebHandler.makeServiceCall(api_url);
        if (jsonStr != null) {
            try {
                new JSONObject(jsonStr);

                JSONObject promotions_json = new JSONObject(jsonStr);
                JSONObject embedded_JSON = promotions_json.getJSONObject("_embedded");
                JSONArray promotions_JSON = embedded_JSON.getJSONArray("promotions");

                for (int y = 0; y < promotions_JSON.length(); y++) {
                    JSONObject promotion_JSON = promotions_JSON.getJSONObject(y);
                    String nom = promotion_JSON.getString("nom");
                    String description = promotion_JSON.getString("description");
                    double prixAvecPromo = promotion_JSON.getDouble("prixAvecPromo");
                    int quantiteMin = promotion_JSON.getInt("quantiteMin");
                    int quantiteMax = promotion_JSON.getInt("quantiteMax");
                    int stock = promotion_JSON.getInt("stock");
                    String duree = promotion_JSON.getString("duree");
                    JSONObject links = promotion_JSON.getJSONObject("_links");

                    //idPromotion
                    JSONObject promotionLinks_JSON = links.getJSONObject("promotion");
                    String idPromotion = promotionLinks_JSON.getString("href");
                    String[] idPromotionSplit = idPromotion.split("s/");


                    //idMagasin
                    JSONObject magasinLinks_JSON = links.getJSONObject("magasin");
                    String hrefMagasin_JSON = magasinLinks_JSON.getString("href");
                    String lienMagasin = serviceWebHandler.makeServiceCall(hrefMagasin_JSON);
                    JSONObject magasin_Json = new JSONObject(lienMagasin);
                    JSONObject linksMagasin_JSON = magasin_Json.getJSONObject("_links");
                    JSONObject lienMagasin_Magasin_Json = linksMagasin_JSON.getJSONObject("magasin");
                    String hrefMagasin_Magasin_JSON = lienMagasin_Magasin_Json.getString("href");
                    String[] idMagasinSplit = hrefMagasin_Magasin_JSON.split("s/");


                    //idProduit
                    JSONObject produitLinks_JSON = links.getJSONObject("produit");
                    String hrefProduit_JSON = produitLinks_JSON.getString("href");
                    String lienProduit = serviceWebHandler.makeServiceCall(hrefProduit_JSON);
                    JSONObject produit_Json = new JSONObject(lienProduit);
                    JSONObject produit_JSON = produit_Json.getJSONObject("_links");
                    JSONObject lienProduit_Produit_Json = produit_JSON.getJSONObject("produit");
                    String hrefProduit_Produit_JSON = lienProduit_Produit_Json.getString("href");
                    String[] idProduitSplit = hrefProduit_Produit_JSON.split("s/");
//                    Log.e("","Produit "+ y +" "+idProduitSplit[1]);


                    AchatGroupe promotion = new AchatGroupe();
                    promotion.setNom(nom);
                    promotion.setDescription(description);
                    promotion.setPrix_avec_promo(prixAvecPromo);
                    promotion.setQuantite_min(quantiteMin);
                    promotion.setQuantite_max(quantiteMax);
                    promotion.setStock(stock);
                    promotion.setDuree(duree);
                    promotion.setId_promotion(Integer.parseInt(idPromotionSplit[1]));
                    promotion.setId_magasin(Integer.parseInt(idMagasinSplit[1]));
                    promotion.setId_produit(Integer.parseInt(idProduitSplit[1]));

                    promotions.add(promotion);

                }

                Data.setPromotions(promotions);

            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans promotion : " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return promotions;

    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix_avec_promo() {
        return prix_avec_promo;
    }

    public void setPrix_avec_promo(double prix_avec_promo) {
        this.prix_avec_promo = prix_avec_promo;
    }

    public int getQuantite_max() {
        return quantite_max;
    }

    public void setQuantite_max(int quantite_max) {
        this.quantite_max = quantite_max;
    }

    public int getQuantite_min() {
        return quantite_min;
    }

    public void setQuantite_min(int quantite_min) {
        this.quantite_min = quantite_min;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
}
