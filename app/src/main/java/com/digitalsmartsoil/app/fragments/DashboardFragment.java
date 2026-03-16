package com.digitalsmartsoil.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.adapters.FarmAdapter;
import com.digitalsmartsoil.app.viewmodels.DashboardViewModel;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private RecyclerView farmRecyclerView;
    private FarmAdapter farmAdapter;
    private DashboardViewModel dashboardViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getContext());
        
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        
        farmRecyclerView = new RecyclerView(getContext());
        farmRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        farmAdapter = new FarmAdapter(new ArrayList<>(), new FarmAdapter.OnFarmClickListener() {
            @Override
            public void onFarmClick(com.digitalsmartsoil.app.models.Farm farm) {
                // Handle farm click
            }

            @Override
            public void onFarmDelete(com.digitalsmartsoil.app.models.Farm farm) {
                dashboardViewModel.deleteFarm(farm.getId());
            }
        });
        farmRecyclerView.setAdapter(farmAdapter);

        dashboardViewModel.farms.observe(getViewLifecycleOwner(), farms -> {
            farmAdapter.updateList(farms);
        });

        dashboardViewModel.loadFarms();
        
        return view;
    }
}
