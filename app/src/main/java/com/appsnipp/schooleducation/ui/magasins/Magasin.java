package com.appsnipp.schooleducation.ui.magasins;

public class Magasin {

    private int mId;
    private String mNom;
    private String mRue;
    private int mCodePostal;
    private String mVille;

    public Magasin(int id, String nom, String rue, int codePostal, String ville, String complement) {
        mId = id;
        mNom = nom;
        mRue = rue;
        mCodePostal = codePostal;
        mVille = ville;
        mComplement = complement;
    }

    public Magasin(int id, String nom, String rue, int codePostal, String ville) {
        mId = id;
        mNom = nom;
        mRue = rue;
        mCodePostal = codePostal;
        mVille = ville;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getNom() {
        return mNom;
    }

    public void setNom(String nom) {
        mNom = nom;
    }

    public String getRue() {
        return mRue;
    }

    public void setRue(String rue) {
        mRue = rue;
    }

    public int getCodePostal() {
        return mCodePostal;
    }

    public void setCodePostal(int codePostal) {
        mCodePostal = codePostal;
    }

    public String getVille() {
        return mVille;
    }

    public void setVille(String ville) {
        mVille = ville;
    }

    public String getComplement() {
        return mComplement;
    }

    public void setComplement(String complement) {
        mComplement = complement;
    }

    private String mComplement;


}
