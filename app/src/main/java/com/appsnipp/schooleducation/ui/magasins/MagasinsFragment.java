package com.appsnipp.schooleducation.ui.magasins;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.data.Data;
import com.appsnipp.schooleducation.ui.AchatGroupe.GroupeAdapter;
import com.appsnipp.schooleducation.ui.accueil.AccueilFragment;
import com.appsnipp.schooleducation.ui.promotions.PromotionsFragment;

public class MagasinsFragment extends Fragment implements DetecteurClicMagasinsRecycler {


    GroupeAdapter adapter;
    ListView listeMagasinView;
    int i = 0;
    private ProgressDialog pDialog;

    private RecyclerView mMagasinsRecyclerView;
    private MagasinsRecyclerViewAdapter mMagasinAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_magasins, container, false);

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



        mMagasinsRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        mMagasinsRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mMagasinsRecyclerView.setLayoutManager(mLayoutManager);
        mMagasinAdapter = new MagasinsRecyclerViewAdapter(Data.getMagasins(),Data.getPromotions());
        mMagasinsRecyclerView.setAdapter(mMagasinAdapter);
        mMagasinAdapter.setDetecteurDeClicSurRecycler(this);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMagasinAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int idMagasin, View v) {
        Toast.makeText(getContext(), "Clic sur le magasin avec id = "+idMagasin, Toast.LENGTH_LONG).show();
        PromotionsFragment promotionsFragment = PromotionsFragment.newInstance(idMagasin);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, promotionsFragment).addToBackStack(null).commit();
    }




}