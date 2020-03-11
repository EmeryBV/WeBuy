package com.appsnipp.schooleducation.ui.promotions;

public class Promotion {

    private int mId;
    private String mNomPromotion;
    private double mPrixAvecPromo;
    private int mQuantiteMin;
    private int mQuantiteRequise;
    private int mQuantiteRestante;
    private boolean visible;
    private int mIdProduit;
    private int mIdMagasin;

    public Promotion(int mId, String mNomPromotion, double mPrixAvecPromo, int mQuantiteMin, int mQuantiteRequise, int mQuantiteRestante, boolean visible, int mIdProduit, int mIdMagasin) {
        this.mId = mId;
        this.mNomPromotion = mNomPromotion;
        this.mPrixAvecPromo = mPrixAvecPromo;
        this.mQuantiteMin = mQuantiteMin;
        this.mQuantiteRestante = mQuantiteRestante;
        this.mQuantiteRequise = mQuantiteRequise;
        this.visible = visible;
        this.mIdProduit = mIdProduit;
        this.mIdMagasin = mIdMagasin;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getNomPromotion() {
        return mNomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        mNomPromotion = nomPromotion;
    }

    public double getPrixAvecPromo() {
        return mPrixAvecPromo;
    }

    public void setPrixAvecPromo(double prixAvecPromo) {
        mPrixAvecPromo = prixAvecPromo;
    }

    public int getQuantiteMin() {
        return mQuantiteMin;
    }

    public void setQuantiteMin(int quantiteMin) {
        mQuantiteMin = quantiteMin;
    }

    public int getQuantiteRestante() {
        return mQuantiteRestante;
    }

    public void setQuantiteRestante(int quantiteRestante) {
        mQuantiteRestante = quantiteRestante;
    }

    public int getQuantiteRequise() {
        return mQuantiteRequise;
    }

    public void setQuantiteRequise(int quantiteRequise) {
        mQuantiteRequise = quantiteRequise;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getIdProduit() {
        return mIdProduit;
    }

    public void setIdProduit(int idProduit) {
        mIdProduit = idProduit;
    }

    public int getIdMagasin() {
        return mIdMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        mIdMagasin = idMagasin;
    }
}
