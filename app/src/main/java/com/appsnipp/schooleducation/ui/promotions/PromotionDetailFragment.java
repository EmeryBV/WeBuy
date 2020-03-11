package com.appsnipp.schooleducation.ui.promotions;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.LoginActivity;
import com.appsnipp.schooleducation.R;

public class PromotionDetailFragment extends Fragment {

    private int mIdPromotion;
    private Promotion mPromotion;
    private TextView nom;
    private TextView prix_hors_promo;
    private TextView prix_avec_promo;
    private TextView quantite_min;
    private TextView quantite_requise;
    private TextView quantite_restante;
    private Button inscription;

    public static PromotionDetailFragment newInstance(int index) {
        PromotionDetailFragment promotionDetailFragment = new PromotionDetailFragment();

        Bundle args = new Bundle();
        args.putInt("idPromotion", index);
        promotionDetailFragment.setArguments(args);

        return promotionDetailFragment;
    }

    public int getIdPromotionEnCours() {
        return getArguments().getInt("idPromotion", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_promotion_detail, container, false);

        for (Promotion promo: Data.getPromotions()) {
            if (promo.getId() == getIdPromotionEnCours()) mPromotion = promo;
        }

        nom = root.findViewById(R.id.nom);
        prix_hors_promo = root.findViewById(R.id.prix_hors_promo);
        prix_avec_promo = root.findViewById(R.id.prix_avec_promo);
        quantite_min = root.findViewById(R.id.quantite_min);
        quantite_requise = root.findViewById(R.id.quantite_requise);
        quantite_restante = root.findViewById(R.id.quantite_restante);

        nom.setText(mPromotion.getNomPromotion());
        prix_hors_promo.setText("Prix hors promo:");
        prix_avec_promo.setText("Prix promo: "+mPromotion.getPrixAvecPromo()+" $");
        quantite_min.setText("Quantité min: "+mPromotion.getQuantiteMin());
        quantite_requise.setText("Quantité à acheter: "+mPromotion.getQuantiteRequise());
        quantite_restante.setText("Quantité restante: "+mPromotion.getQuantiteRestante());

        inscription = root.findViewById(R.id.button2);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondeActivite = new Intent(getContext(), LoginActivity.class);
                startActivity(secondeActivite);
            }
        });

        return root;
    }
}
