package com.example.webuy.ui.promotions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.webuy.Data;
import com.example.webuy.R;
import com.example.webuy.ui.promotions.PromotionsViewModel;

public class PromotionsFragment extends Fragment {

    private com.example.webuy.ui.promotions.PromotionsViewModel PromotionsViewModel;
    ListView listview;
    PromotionAdapter adapter;
    Data datas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PromotionsViewModel =
                ViewModelProviders.of(this).get(PromotionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_magasins, container, false);
        /*
        final TextView textView = root.findViewById(R.id.text_gallery);
        MagasinsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        datas = new Data();
        listview = (ListView) root.findViewById(R.id.listView);
        adapter = new PromotionAdapter(datas.getPromotions(),getContext());
        listview.setAdapter(adapter);

        return root;
    }
}
