package com.appsnipp.schooleducation.ui.accueil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.Data;
import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.ui.importer.AchatGroupe;
import com.appsnipp.schooleducation.ui.importer.GroupeAdapter;
import com.appsnipp.schooleducation.ui.magasins.MagasinsFragment;
import com.appsnipp.schooleducation.ui.promotions.PromotionDetailFragment;
import com.appsnipp.schooleducation.ui.promotions.PromotionsFragment;

import java.util.ArrayList;

public class AccueilFragment extends Fragment implements DetecteurClicAccueilRecycler {

    TextView voirPlusMagasins;
    private Data mDatas;
    private RecyclerView mAccueilRecyclerViewMagasins;
    private AccueilRecyclerViewMagasinsAdapter mAccueilAdapterMagasins;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mPromotionsRecyclerView;
    private AccueilRecyclerViewPromotionsAdapter mPromotionAdapter;
    private RecyclerView.LayoutManager mLayoutManager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = 0 ;
        super.onCreate(savedInstanceState);

        View root = (View) inflater.inflate(R.layout.fragment_accueil, container, false);
        voirPlusMagasins = (TextView) root.findViewById(R.id.voir_plus);
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


        mPromotionsRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_promotions);
        mPromotionsRecyclerView.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        mPromotionsRecyclerView.setLayoutManager(mLayoutManager2);
        mPromotionAdapter = new AccueilRecyclerViewPromotionsAdapter(Data.getPromotions());
        mPromotionsRecyclerView.setAdapter(mPromotionAdapter);
        mPromotionAdapter.notifyDataSetChanged();
        mPromotionAdapter.setDetecteurDeClicSurRecyclerPromos(this);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAccueilAdapterMagasins.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int idMagasin, View v) {
        Toast.makeText(getContext(), "Clic sur le magasin avec id = "+(idMagasin+1), Toast.LENGTH_LONG).show();
        PromotionsFragment promotionsFragment = PromotionsFragment.newInstance(idMagasin+1);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsFragment).addToBackStack(null).commit();
    }

    @Override
    public void clicSurRecyclerItemPromos(int position, View v) {
        Toast.makeText(getContext(), "Clic sur la promotion avec id = "+position, Toast.LENGTH_LONG).show();
        PromotionDetailFragment promotionsDetailFragment = PromotionDetailFragment.newInstance(position);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsDetailFragment).addToBackStack(null).commit();
    }




}
