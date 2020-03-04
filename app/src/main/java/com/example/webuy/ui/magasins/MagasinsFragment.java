package com.example.webuy.ui.magasins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.Data;
import com.example.webuy.R;


public class MagasinsFragment extends Fragment {

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
        mMagasinAdapter = new MagasinsRecyclerViewAdapter(Data.getMagasins());
        mMagasinsRecyclerView.setAdapter(mMagasinAdapter);

        return root;
    }
}
