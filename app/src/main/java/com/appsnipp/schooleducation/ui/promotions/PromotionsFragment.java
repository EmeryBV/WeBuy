package com.appsnipp.schooleducation.ui.promotions;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

    public void clicSurRecyclerItem(int idPromotion, View v) {
        Toast.makeText(getContext(), "Clic sur la promotion avec id = "+idPromotion, Toast.LENGTH_LONG).show();
        PromotionDetailFragment promotionsDetailFragment = PromotionDetailFragment.newInstance(idPromotion);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsDetailFragment).addToBackStack(null).commit();
    }
}
