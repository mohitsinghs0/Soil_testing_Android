package com.digitalsmartsoil.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.adapters.SoilTestAdapter;
import com.digitalsmartsoil.app.viewmodels.HistoryViewModel;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private SoilTestAdapter adapter;
    private HistoryViewModel historyViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getContext());
        
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        
        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        adapter = new SoilTestAdapter(new ArrayList<>(), test -> {
            // Handle test click
        });
        recyclerView.setAdapter(adapter);

        historyViewModel.soilTests.observe(getViewLifecycleOwner(), tests -> {
            adapter.updateList(tests);
        });
        
        return view;
    }
}
