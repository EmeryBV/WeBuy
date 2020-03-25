package com.appsnipp.schooleducation.ui.accueil;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.ui.magasins.DetecteurClicMagasinsRecycler;
import com.appsnipp.schooleducation.ui.magasins.MagasinsFragment;
import com.appsnipp.schooleducation.ui.promotions.PromotionsFragment;

public class AccueilFragment extends Fragment implements DetecteurClicAccueilMagasinsRecycler {

    TextView voirPlusMagasins;
    private Data mDatas;
    private RecyclerView mAccueilRecyclerViewMagasins;
    private AccueilRecyclerViewMagasinsAdapter mAccueilAdapterMagasins;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View root = (View) inflater.inflate(R.layout.fragment_accueil, container, false);
        voirPlusMagasins = (TextView) root.findViewById(R.id.voir_plus);

        voirPlusMagasins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Fragment magasinsFragment = new MagasinsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, magasinsFragment).addToBackStack(null).commit();
            }
        });

        mAccueilRecyclerViewMagasins = (RecyclerView) root.findViewById(R.id.recycler_view_magasins);
        mAccueilRecyclerViewMagasins.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        mAccueilRecyclerViewMagasins.setLayoutManager(mLayoutManager);
        mAccueilAdapterMagasins = new AccueilRecyclerViewMagasinsAdapter(Data.getImageMagasins());
        mAccueilRecyclerViewMagasins.setAdapter(mAccueilAdapterMagasins);
        mAccueilAdapterMagasins.setDetecteurDeClicSurRecycler(this);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAccueilAdapterMagasins.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int idMagasin, View v) {
        Toast.makeText(getContext(), "Clic sur le magasin avec id = "+idMagasin, Toast.LENGTH_LONG).show();
        PromotionsFragment promotionsFragment = PromotionsFragment.newInstance(idMagasin);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsFragment).addToBackStack(null).commit();
    }
}
