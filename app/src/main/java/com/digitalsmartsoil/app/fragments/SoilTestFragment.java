package com.digitalsmartsoil.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.digitalsmartsoil.app.models.SoilTest;
import com.digitalsmartsoil.app.viewmodels.SoilTestViewModel;

public class SoilTestFragment extends Fragment {
    private EditText nitrogenInput;
    private EditText phosphorusInput;
    private EditText potassiumInput;
    private Button submitButton;
    private SoilTestViewModel soilTestViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getContext());
        
        soilTestViewModel = new ViewModelProvider(this).get(SoilTestViewModel.class);
        
        nitrogenInput = new EditText(getContext());
        phosphorusInput = new EditText(getContext());
        potassiumInput = new EditText(getContext());
        submitButton = new Button(getContext());
        
        submitButton.setOnClickListener(v -> {
            SoilTest test = new SoilTest();
            test.setNitrogen(Double.parseDouble(nitrogenInput.getText().toString()));
            test.setPhosphorus(Double.parseDouble(phosphorusInput.getText().toString()));
            test.setPotassium(Double.parseDouble(potassiumInput.getText().toString()));
            soilTestViewModel.createSoilTest(test);
        });
        
        return view;
    }
}
