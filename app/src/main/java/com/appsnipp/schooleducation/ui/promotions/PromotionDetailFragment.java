package com.appsnipp.schooleducation.ui.promotions;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.ui.AchatGroupe.DetecteurClicGroupeRecycler;
import com.appsnipp.schooleducation.ui.AchatGroupe.RecyclerViewGroupesAdapter;
import com.appsnipp.schooleducation.ui.accueil.AccueilFragment;
import com.appsnipp.schooleducation.ui.utilisateurs.LoginFragment;
import com.squareup.picasso.Picasso;

public class PromotionDetailFragment extends Fragment implements DetecteurClicPromotionsRecycler{

    private static PromotionDetailFragment promotionDetailFragment = new PromotionDetailFragment();

    private int mIdPromotion;
    private AchatGroupe mPromotion;
    private TextView nom;
    private TextView prix_hors_promo;
    private TextView prix_avec_promo;
    private TextView quantite_min;
    private TextView quantite_requise;
    private TextView quantite_restante;
    private Button inscription;
    private ImageView imagePromoGrand;
    private RecyclerView RecyclerViewGroupesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewGroupesAdapter AdapterGroupes;

    public static PromotionDetailFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("idPromotion", index);
        promotionDetailFragment.setArguments(args);
        return promotionDetailFragment;
    }

    public int getIdPromotionEnCours() {
        return getArguments().getInt("idPromotion", 0);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_promotion_detail, container, false);


        imagePromoGrand = root.findViewById(R.id.imagePromoGrand);
        nom = root.findViewById(R.id.nom);
        prix_hors_promo = root.findViewById(R.id.prix_hors_promo);
        prix_hors_promo.setPaintFlags(prix_hors_promo.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        prix_avec_promo = root.findViewById(R.id.prix_avec_promo);
        quantite_min = root.findViewById(R.id.quantite_min);
        quantite_requise = root.findViewById(R.id.quantite_requise);
        quantite_restante = root.findViewById(R.id.quantite_restante);

        RecyclerViewGroupesAdapter = (RecyclerView) root.findViewById(R.id.recycler_view_groupes);
        RecyclerViewGroupesAdapter.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        RecyclerViewGroupesAdapter.setLayoutManager(mLayoutManager);
        AdapterGroupes = new RecyclerViewGroupesAdapter(getIdPromotionEnCours(),Data.getGroupe());
        RecyclerViewGroupesAdapter.setAdapter( AdapterGroupes );
//        AdapterGroupes .setDetecteurDeClicSurRecycler();
        
        for (int i = 0; i < Data.getPromotions().size(); i++) {
            if (Data.getPromotions().get(i).getId_produit() == Data.searchByIdPromotion(promotionDetailFragment.getIdPromotionEnCours()).getId_produit()) {

                prix_hors_promo.setText( String.valueOf(Data.getProduits().get(i).getPrix())+" €");
                Picasso.get().load(Data.getImageProduits().get(i)).into(imagePromoGrand);
                break;

            }
        }
        for (int i = 0; i < Data.getPromotions().size(); i++) {
            if (Data.getPromotions().get(i).getId_promotion() == promotionDetailFragment.getIdPromotionEnCours()) {
                nom.setText(Data.getPromotions().get(i).getNom());
                prix_avec_promo.setText(Data.getPromotions().get(i).getPrix_avec_promo() + " €");
                quantite_requise.setText("Pour " + Data.getPromotions().get(i).getQuantite_min() + " article(s) acheté(s), le prix unitaire revient à "
                        + Data.getPromotions().get(i).getPrix_avec_promo() + " € au lieu de " + Data.getProduits().get(i).getPrix() + " €" );
                quantite_min.setText("Nombre d'achat limité à " + Data.getPromotions().get(i).getQuantite_max()+" article(s) par groupe");


                quantite_restante.setText("Plus que " + Data.getPromotions().get(i).getStock()+" de disponible(s)");
                break;

            }
        }


        inscription = root.findViewById(R.id.button2);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment fragment = new LoginFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        ImageView menu = (ImageView) root.findViewById(R.id.menu);
        ImageView accueil = (ImageView) root.findViewById(R.id.accueil);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccueilFragment fragment = new AccueilFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        return root;
    }

    @Override
    public void clicSurRecyclerItem(int position, View v) {
        Toast.makeText(getContext(), "Clic sur la promotion avec id = "+getIdPromotionEnCours(), Toast.LENGTH_LONG).show();
        PromotionDetailFragment promotionsDetailFragment = PromotionDetailFragment.newInstance(mIdPromotion);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsDetailFragment).addToBackStack(null).commit();
    }

}
