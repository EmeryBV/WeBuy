package com.appsnipp.schooleducation.ui.promotions;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.ui.accueil.AccueilFragment;

public class PromotionsFragment extends Fragment implements DetecteurClicPromotionsRecycler {


    //private int mIdMagasin;
    private static PromotionsFragment promotionsFragment = new PromotionsFragment();
    private int var;
    private RecyclerView mPromotionsRecyclerView;
    private PromotionsRecyclerViewAdapter mPromotionAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static PromotionsFragment newInstance(int index) {

        //Recupération de l’index à afficher dans les arguments d’appel
        Bundle args = new Bundle();
        args.putInt("idMagasin", index);
        promotionsFragment.setArguments(args);
        return promotionsFragment;

    }

    public int getIdMagasinEnCours() {
        return getArguments().getInt("idMagasin", 1);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_promotions, container, false);


        ImageView menu = (ImageView) root.findViewById(R.id.menu);
        ImageView accueil = (ImageView) root.findViewById(R.id.accueil);

        menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        accueil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AccueilFragment fragment = new AccueilFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });

        mPromotionsRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        mPromotionsRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mPromotionsRecyclerView.setLayoutManager(mLayoutManager);
        Log.e("","IDMAGASIN" + promotionsFragment.getIdMagasinEnCours());
        mPromotionAdapter = new PromotionsRecyclerViewAdapter(getIdMagasinEnCours(), Data.getPromotions());
        mPromotionsRecyclerView.setAdapter(mPromotionAdapter);
        mPromotionAdapter.setDetecteurDeClicSurRecycler(this);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPromotionAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int idPromotion, View v) {
        Toast.makeText(getContext(), "Clic sur la promotion avec id = "+idPromotion, Toast.LENGTH_LONG).show();
        PromotionDetailFragment promotionsDetailFragment = PromotionDetailFragment.newInstance(idPromotion);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsDetailFragment).addToBackStack(null).commit();
    }
}
