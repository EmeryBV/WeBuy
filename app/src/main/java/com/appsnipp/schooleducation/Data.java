package com.appsnipp.schooleducation;

import com.appsnipp.schooleducation.ui.magasins.Magasin;
import com.appsnipp.schooleducation.ui.promotions.Promotion;

import java.util.ArrayList;

public class Data {

    private ArrayList<Magasin> magasins = new ArrayList<>();
    private ArrayList<Promotion> promotions = new ArrayList<>();

    public Data() {
        remplirListeMagasins();
        remplirListePromotions();
    }

    public static ArrayList<Magasin> getMagasins() {

        Magasin m1 = new Magasin(1,"Carrefour","1 rue Les rosiers",37200,"Tours");
        Magasin m2 = new Magasin(2,"Casino","2 rue Les rosiers",37200,"Tours");
        Magasin m3 = new Magasin(3,"Leclerc","3 rue Les rosiers",37200,"Tours");
        Magasin m4 = new Magasin(4,"Bricorama","4 rue Les rosiers",37200,"Tours");
        Magasin m5 = new Magasin(5,"La Halle","5 rue Les rosiers",37200,"Tours");
        Magasin m6 = new Magasin(6,"Darty","6 rue Les rosiers",37200,"Tours");
        ArrayList<Magasin> magasins = new ArrayList<>();
        magasins.add(m1);
        magasins.add(m2);
        magasins.add(m3);
        magasins.add(m4);
        magasins.add(m5);
        magasins.add(m6);

        return magasins;
    }

    public static ArrayList<Integer> getImageMagasins() {
        ArrayList<Integer> imageMagasins = new ArrayList<>();
        imageMagasins.add(R.drawable.carrefour);
        imageMagasins.add(R.drawable.casino);
        imageMagasins.add(R.drawable.leclerc);
        imageMagasins.add(R.drawable.bricorama);
        imageMagasins.add(R.drawable.la_halle);
        imageMagasins.add(R.drawable.darty);
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

    public void setMagasins(ArrayList<Magasin> magasins) {
        this.magasins = magasins;
    }

    public static ArrayList<Promotion> getPromotions() {
        Promotion p1 = new Promotion(1,"Christaline 1.5L x 6", 1.00,2,2,3,true,1,6);
        Promotion p2 = new Promotion(2,"Lait Lactel 1L x 6", 2.00,3,3,1,true,1,4);
        Promotion p3 = new Promotion(3,"Colgate Max White", 2.00,2,3,3,true,2,4);
        Promotion p4 = new Promotion(4,"Head & Shoulders", 3,4,5,2,true,2,1);
        Promotion p5 = new Promotion(5,"Léa nature Pâte à tartiner", 2,3,4,2,true,3,2);
        Promotion p6 = new Promotion(6,"Laqueuille 1.5L x 6", 1.00,12,12,5,true,3,2);
        ArrayList<Promotion> promotions = new ArrayList<>();
        promotions.add(p1);
        promotions.add(p2);
        promotions.add(p3);
        promotions.add(p4);
        promotions.add(p5);
        promotions.add(p6);

        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }

    private static void remplirListeMagasins() {
        Magasin m1 = new Magasin(1,"Carrefour","1 rue Les rosiers",37200,"Tours");
        Magasin m2 = new Magasin(2,"Casino","2 rue Les rosiers",37200,"Tours");
        Magasin m3 = new Magasin(3,"Leclerc","3 rue Les rosiers",37200,"Tours");
        Magasin m4 = new Magasin(4,"Bricorama","4 rue Les rosiers",37200,"Tours");
        Magasin m5 = new Magasin(5,"La Halle","5 rue Les rosiers",37200,"Tours");
        Magasin m6 = new Magasin(6,"Darty","6 rue Les rosiers",37200,"Tours");
        ArrayList<Magasin> magasins = new ArrayList<>();
        magasins.add(m1);
        magasins.add(m2);
        magasins.add(m3);
        magasins.add(m4);
        magasins.add(m5);
        magasins.add(m6);
    }

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
