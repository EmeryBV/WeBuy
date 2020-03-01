package com.example.webuy;

import java.util.ArrayList;

public class Data {

    private ArrayList<Magasin> magasins = new ArrayList<>();

    public Data() {
        remplirListeMagasins();
    }

    public ArrayList<Magasin> getMagasins() {
        return magasins;
    }

    public void setMagasins(ArrayList<Magasin> magasins) {
        this.magasins = magasins;
    }

    private void remplirListeMagasins() {
        Magasin m1 = new Magasin("Carrefour","1 rue Les rosiers",37200,"Tours");
        Magasin m2 = new Magasin("Casino","2 rue Les rosiers",37200,"Tours");
        Magasin m3 = new Magasin("Leclerc","3 rue Les rosiers",37200,"Tours");
        Magasin m4 = new Magasin("Bricorama","4 rue Les rosiers",37200,"Tours");

        magasins.add(m1);
        magasins.add(m2);
        magasins.add(m3);
        magasins.add(m4);
    }
}
