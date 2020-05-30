package com.appsnipp.schooleducation.ui.utilisateurs;

import android.util.Log;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.data.BaseWeBuy;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.data.HttpHandler;
import com.appsnipp.schooleducation.ui.magasins.Magasin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Utilisateur extends BaseWeBuy {
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "utilisateurs";

    private int id_utilisateur;
    private String email;
    private String mot_de_passe;
    private String nom;
    private String prenom;
    private String role;
    private int token;

    public static ArrayList<Utilisateur> getAllUtilisateurs() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();
        String jsonStr = serviceWebHandler.makeServiceCall(api_url);


        if (jsonStr != null) {
            try {
                new JSONObject(jsonStr);

                JSONObject utilisateurs_json = new JSONObject(jsonStr);
                JSONObject embedded_JSON = utilisateurs_json.getJSONObject("_embedded");
                JSONArray utilisateurs_JSON = embedded_JSON.getJSONArray("utilisateurs");
                for (int y = 0; y < utilisateurs_JSON.length(); y++) {
                    JSONObject utilisateur_JSON = utilisateurs_JSON.getJSONObject(y);
                    String prenom = utilisateur_JSON.getString("prenom");
                    String nom = utilisateur_JSON.getString("nom");
                    String email = utilisateur_JSON.getString("email");
                    String motDePasse = utilisateur_JSON.getString("motDePasse");
                    String role = utilisateur_JSON.getString("User");
                    int token = utilisateur_JSON.getInt("token");

                    //idMagasin
                    JSONObject links = utilisateur_JSON.getJSONObject("_links");
                    JSONObject utilisateurLinks_JSON = links.getJSONObject("utilisateur");
                    String idUtilisateur = utilisateurLinks_JSON.getString("href");
                    String[] idUtilisateurSplit = idUtilisateur.split("s/");

                    Utilisateur utilisateur = new Utilisateur();

                    utilisateur.setId_utilisateur(Integer.parseInt(idUtilisateurSplit[1]));
                    utilisateur.setPrenom(prenom);
                    utilisateur.setNom(nom);
                    utilisateur.setEmail(email);
                    utilisateur.setMot_de_passe(motDePasse);
                    utilisateur.setRole(role);
                    utilisateur.setToken(token);

                }

                Data.setUtilisateurs(utilisateurs);
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans Magasin: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return utilisateurs;

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static String getTAG() {
        return TAG;
    }

    public static void setTAG(String TAG) {
        Utilisateur.TAG = TAG;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
