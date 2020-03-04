package com.example.webuy.ui.accueil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.webuy.R;

public class AccueilFragment extends Fragment {

    private AccueilViewModel AccueilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AccueilViewModel =
                ViewModelProviders.of(this).get(AccueilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_accueil, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        AccueilViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}