package com.appsnipp.schooleducation.ui.achats;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.schooleducation.MainActivity;
import com.appsnipp.schooleducation.R;
import com.appsnipp.schooleducation.ui.accueil.AccueilFragment;
import com.appsnipp.schooleducation.ui.utilisateurs.LoginFragment;

public class AchatsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_achats, container, false);

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

        TextView logIn = (TextView) root.findViewById(R.id.se_connecter);
        logIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginFragment fragment = new LoginFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });

        return root;
    }
}
