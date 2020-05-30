package com.appsnipp.schooleducation.ui.AchatGroupe;

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

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MainActivity.class.getSimpleName();
    private static String api_url = BaseWeBuy.api_url + "groupes";

    private int id_groupe;
    private boolean visible;
    private int id_promotion;

    private ArrayList<AchatGroupe> groupes;

    public static ArrayList<AchatGroupe> getAllGroupes() {

        ArrayList<AchatGroupe> groupes = new ArrayList<>();
        HttpHandler serviceWebHandler = new HttpHandler();
        String jsonStr = serviceWebHandler.makeServiceCall(api_url);
        if (jsonStr != null) {
            try {
                new JSONObject(jsonStr);

                JSONObject groupes_json = new JSONObject(jsonStr);
                JSONObject embedded_JSON = groupes_json.getJSONObject("_embedded");
                JSONArray groupes_JSON = embedded_JSON.getJSONArray("groupes");

                for (int y = 0; y < groupes_JSON.length(); y++) {
                    JSONObject groupe_JSON = groupes_JSON.getJSONObject(y);
//                        Log.e("","Groupe "+ y +groupe_JSON.toString() );
                    JSONObject links_JSON = groupe_JSON.getJSONObject("_links");
                    boolean visible = groupe_JSON.getBoolean("visible");

                    //idGroupe
                    JSONObject groupeLinks_JSON = links_JSON.getJSONObject("groupe");
                    String hrefGroupe_JSON = groupeLinks_JSON.getString("href");
                    String[] idGroupeSplit = hrefGroupe_JSON.split("s/");


                    //idPromo
                    JSONObject promotion_JSON = links_JSON.getJSONObject("promotion");
                    String hrefPromo_JSON = promotion_JSON.getString("href");
                    String lienPromo = serviceWebHandler.makeServiceCall(hrefPromo_JSON);
                    JSONObject promotion_Json = new JSONObject(lienPromo);
                    JSONObject linksPromo_JSON = promotion_Json.getJSONObject("_links");
                    JSONObject lienPromo_Promo_Json = linksPromo_JSON.getJSONObject("promotion");
                    String hrefPromo_Promo_JSON = lienPromo_Promo_Json.getString("href");
                    String[] idPromotionSplit = hrefPromo_Promo_JSON.split("s/");

                    AchatGroupe groupe = new AchatGroupe();
                    groupe.setVisible(visible);
                    groupe.setId_groupe(Integer.parseInt(idGroupeSplit[1]));
                    groupe.setId_promotion(Integer.valueOf(idPromotionSplit[1]));
                    groupes.add(groupe);
                }
                Data.setGroupe(groupes);

            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON dans groupe: " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON de AchatGroupe");
        }

        return groupes;

    }


    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }


}
