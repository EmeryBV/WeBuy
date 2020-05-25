package com.appsnipp.schooleducation;


import android.util.Log;

import com.appsnipp.schooleducation.ui.importer.AchatGroupe;
import com.appsnipp.schooleducation.ui.magasins.Magasin;
import com.appsnipp.schooleducation.ui.promotions.Promotion;

import java.util.ArrayList;

public class Data {
private static Magasin magasin ;
private static ArrayList<AchatGroupe> groupe;
private  static ArrayList<Magasin> magasins;
private static ArrayList<Promotion> promotions = new ArrayList<>();
private static ArrayList<String> imageMagasins = new ArrayList<>();


    public static ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public static void setPromotions(ArrayList<Promotion> promotions) {
        Log.i("test 1","");
        Data.promotions = promotions;
    }

    public static void setMagasins(ArrayList<Magasin> magasins) {
        Log.i("test 1","");
        Data.magasins = magasins;
    }

    public static ArrayList<Magasin> getMagasins()
    {

        return magasins;

    }

    public static  ArrayList<AchatGroupe> getGroupe(){
        return groupe;
}
    public static void setGroupe(ArrayList<AchatGroupe> groupe) {
        Data.groupe = groupe;
    }


    public static void setImageMagasins() {
        imageMagasins.clear();
        for(int i = 0 ; i<magasins.size();i++){
            imageMagasins.add(magasins.get(i).getLogo());
        }
    }

    public static ArrayList<String> getImageMagasins() {
        return imageMagasins;
    }

    public static ArrayList<Integer> getImagePromotions() {
        ArrayList<Integer> imagePromotions = new ArrayList<>();
        imagePromotions.add(R.drawable.cristaline);
        imagePromotions.add(R.drawable.lactel);
        imagePromotions.add(R.drawable.colgate);
        imagePromotions.add(R.drawable.heads);
        imagePromotions.add(R.drawable.lea_nature);
        imagePromotions.add(R.drawable.laqueuille);
        return imagePromotions;
    }


//    public static ArrayList<Promotion> getPromotions() {
//        Promotion p1 = new Promotion(1,"Christaline 1.5L x 6", 1.00,2,2,3,true,1,4);
//        Promotion p2 = new Promotion(2,"Lait Lactel 1L x 6", 2.00,3,3,1,true,1,3);
//        Promotion p3 = new Promotion(3,"Colgate Max White", 2.00,2,3,3,true,2,3);
//        Promotion p4 = new Promotion(4,"Head & Shoulders", 3,4,5,2,true,2,1);
//        Promotion p5 = new Promotion(5,"Léa nature Pâte à tartiner", 2,3,4,2,true,3,1);
//        Promotion p6 = new Promotion(6,"Laqueuille 1.5L x 6", 1.00,12,12,5,true,3,2);
//        ArrayList<Promotion> promotions = new ArrayList<>();
//        promotions.add(p1);
//        promotions.add(p2);
//        promotions.add(p3);
//        promotions.add(p4);
//        promotions.add(p5);
//        promotions.add(p6);
//
//        return promotions;
//    }
//
//    public void setPromotions(ArrayList<Promotion> promotions) {
//        this.promotions = promotions;
//    }


    private void remplirListePromotions() {
        Promotion p1 = new Promotion(1,"Christaline 1.5L x 6", 1.00,2,2,3,true,1,6);
        Promotion p2 = new Promotion(2,"Lait Lactel 1L x 6", 2.00,3,3,1,true,1,4);
        Promotion p3 = new Promotion(3,"Colgate Max White", 2.00,2,3,3,true,2,4);
        Promotion p4 = new Promotion(4,"Head & Shoulders", 3,4,5,2,true,2,1);
        Promotion p5 = new Promotion(5,"Léa nature Pâte à tartiner", 2,3,4,2,true,3,2);
        Promotion p6 = new Promotion(6,"Laqueuille 1.5L x 6", 1.00,12,12,5,true,3,2);

        promotions.add(p1);
        promotions.add(p2);
        promotions.add(p3);
        promotions.add(p4);
        promotions.add(p5);
        promotions.add(p6);
    }
}