package com.appsnipp.schooleducation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.appsnipp.schooleducation.ui.promotions.PromotionsFragment;

public class AccueilFragment extends Fragment {

    TextView voirPlusMagasins;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = (View) inflater.inflate(R.layout.fragment_accueil, container, false);
        voirPlusMagasins = (TextView) root.findViewById(R.id.voir_plus);

        voirPlusMagasins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Fragment accueilFragment = new AccueilFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, accueilFragment).addToBackStack(null).commit();
            }
        });
        return root;
    }
}
