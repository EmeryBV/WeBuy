package com.appsnipp.schooleducation.ui.promotions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.R;

public class PromotionsFragment extends Fragment implements DetecteurClicPromotionsRecycler {

    private Data mDatas;
    //private int mIdMagasin;
    private RecyclerView mPromotionsRecyclerView;
    private PromotionsRecyclerViewAdapter mPromotionAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static PromotionsFragment newInstance(int index) {
        PromotionsFragment promotionsFragment = new PromotionsFragment();

        //Recupération de l’index à afficher dans les arguments d’appel
        Bundle args = new Bundle();
        args.putInt("idMagasin", index);
        promotionsFragment.setArguments(args);

        return promotionsFragment;
    }

    public int getIdMagasinEnCours() {
        return getArguments().getInt("idMagasin", 0);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_promotions, container, false);

        mPromotionsRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        mPromotionsRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mPromotionsRecyclerView.setLayoutManager(mLayoutManager);
        mPromotionAdapter = new PromotionsRecyclerViewAdapter(getIdMagasinEnCours(),Data.getPromotions());
        mPromotionsRecyclerView.setAdapter(mPromotionAdapter);
        mPromotionAdapter.setDetecteurDeClicSurRecycler(this);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPromotionAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int position, View v) {
        Toast.makeText(getContext(), "Clic sur l'item "+position, Toast.LENGTH_LONG).show();
    }
}
