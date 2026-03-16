package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.adapters.SoilTestAdapter;
import com.digitalsmartsoil.app.viewmodels.HistoryViewModel;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SoilTestAdapter adapter;
    private HistoryViewModel historyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        
        recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new SoilTestAdapter(new ArrayList<>(), test -> {
            // Handle test click
        });
        recyclerView.setAdapter(adapter);

        historyViewModel.soilTests.observe(this, tests -> {
            adapter.updateList(tests);
        });
    }
}
