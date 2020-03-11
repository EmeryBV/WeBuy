package com.appsnipp.schooleducation.ui.magasins;

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
import com.appsnipp.schooleducation.ui.promotions.PromotionsFragment;

public class MagasinsFragment extends Fragment implements DetecteurClicMagasinsRecycler {

    private Data mDatas;
    private RecyclerView mMagasinsRecyclerView;
    private MagasinsRecyclerViewAdapter mMagasinAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_magasins, container, false);

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

        /*
        Intent secondeActivite = new Intent(getContext(), AchatGroupe_activity.class);
        secondeActivite.putExtra("idMagasin", idMagasin);
        startActivity(secondeActivite);*/
        PromotionsFragment promotionsFragment = PromotionsFragment.newInstance(idMagasin);
        getFragmentManager().beginTransaction().replace(android.R.id.content, promotionsFragment).commit();
    }
}
