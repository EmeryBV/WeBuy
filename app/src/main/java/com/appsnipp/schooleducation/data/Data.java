package com.appsnipp.schooleducation.data;


import com.appsnipp.schooleducation.ui.magasins.Magasin;
import com.appsnipp.schooleducation.ui.produits.Produit;
import com.appsnipp.schooleducation.ui.promotions.AchatGroupe;
import com.appsnipp.schooleducation.ui.utilisateurs.Utilisateur;

import java.util.ArrayList;

public class Data {
private static Magasin magasin ;
private static ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupe;
private  static ArrayList<Magasin> magasins;
private static ArrayList<AchatGroupe> promotions ;
private static ArrayList<Produit> produits;
private static ArrayList<Utilisateur> utilisateurs;
private static ArrayList<String> imageMagasins = new ArrayList<>();
private static ArrayList<Integer> idPromotion = new ArrayList<>();

    public static ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> getGroupe() {
        return groupe;
    }

    public static void setGroupe(ArrayList<com.appsnipp.schooleducation.ui.AchatGroupe.AchatGroupe> groupe) {
        Data.groupe = groupe;
    }

    public static ArrayList<Magasin> getMagasins() {

        return magasins;
    }

    public static void setMagasins(ArrayList<Magasin> magasins) {
        Data.magasins = magasins;
    }

    public static ArrayList<AchatGroupe> getPromotions() {
        return promotions;
    }

    public static void setPromotions(ArrayList<AchatGroupe> promotions) {
        Data.promotions = promotions;
    }

    public static ArrayList<Produit> getProduits() {
        return produits;
    }

    public static void setProduits(ArrayList<Produit> produits) {
        Data.produits = produits;
    }

    public static ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
        Data.utilisateurs = utilisateurs;
    }

    public static ArrayList<String> getImageProduits(){
       ArrayList<String> logoProduit = new ArrayList<>();
        for(int i = 0 ; i<produits.size();i++){
          logoProduit.add(produits.get(i).getLogo());
        }
        return logoProduit;
    }

    public static ArrayList<String> getImageMagasins(){
        ArrayList<String> logoMagasins= new ArrayList<>();
        for(int i = 0 ; i<magasins.size();i++){
            logoMagasins.add(magasins.get(i).getLogo());
        }
        return logoMagasins;
    }

    public static ArrayList<Integer> getIdMagasin() {
        ArrayList<Integer> idMagasins= new ArrayList<>();
        for(int i = 0 ; i<magasins.size();i++){
            idMagasins.add(magasins.get(i).getId_magasin());
        }
        return idMagasins;
    }


    public static ArrayList<Integer> getIdPromotion() {
        ArrayList<Integer> idPromotions= new ArrayList<>();
        for(int i = 0 ; i<promotions.size();i++){
            idPromotions.add(promotions.get(i).getId_promotion());
        }
        return idPromotions;
    }

    public static ArrayList<Integer> getIdProduit() {
        ArrayList<Integer> idProduits= new ArrayList<>();
        for(int i = 0 ; i<produits.size();i++){
            idProduits.add(promotions.get(i).getId_produit());
        }
        return idProduits;
    }

    public static Produit searchByIdProduit(int id) {
       Produit produit = new Produit();
       for(int i = 0; i<produits.size();i++){
           if(produits.get(i).getId_produit()==id){
               return produit;
           }
       }
        return null;
    }

    public static AchatGroupe searchByIdPromotion(int id) {
        AchatGroupe promotion = new AchatGroupe();
        for(int i = 0; i<getPromotions().size();i++){
            if(promotions.get(i).getId_promotion()==id){
                promotion=promotions.get(i);
                return promotion;
            }
        }
        return promotion;
    }

}