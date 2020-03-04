package com.example.webuy.ui.promotions;

public class Promotion {

    private int mId;
    private String mNomProduit;
    private double mPrixAvecPromo;
    private double mPrixSansPromo;
    private int mQuantiteMin;
    private int mQuantiteRequise;
    private int mIdMagasin;

    public Promotion(int id, String nomProduit, double prixAvecPromo, double prixSansPromo, int quantiteMin, int quantiteRequise, int idMagasin) {
        mId = id;
        mNomProduit = nomProduit;
        mPrixAvecPromo = prixAvecPromo;
        mPrixSansPromo = prixSansPromo;
        mQuantiteMin = quantiteMin;
        mQuantiteRequise = quantiteRequise;
        mIdMagasin = idMagasin;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getNomProduit() {
        return mNomProduit;
    }

    public void setNomProduit(String nomProduit) {
        mNomProduit = nomProduit;
    }

    public double getPrixAvecPromo() {
        return mPrixAvecPromo;
    }

    public void setPrixAvecPromo(double prixAvecPromo) {
        mPrixAvecPromo = prixAvecPromo;
    }

    public double getPrixSansPromo() {
        return mPrixSansPromo;
    }

    public void setPrixSansPromo(double prixSansPromo) {
        mPrixSansPromo = prixSansPromo;
    }

    public int getQuantiteMin() {
        return mQuantiteMin;
    }

    public void setQuantiteMin(int quantiteMin) {
        mQuantiteMin = quantiteMin;
    }

    public int getQuantiteRequise() {
        return mQuantiteRequise;
    }

    public void setQuantiteRequise(int quantiteRequise) {
        mQuantiteRequise = quantiteRequise;
    }

    public int getIdMagasin() {
        return mIdMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        mIdMagasin = idMagasin;
    }
}
