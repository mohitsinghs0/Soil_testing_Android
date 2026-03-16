package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.models.Farm;
import com.digitalsmartsoil.app.viewmodels.DashboardViewModel;

public class AddFarmActivity extends AppCompatActivity {
    private EditText farmNameEditText;
    private EditText latitudeEditText;
    private EditText longitudeEditText;
    private Button addButton;
    private DashboardViewModel dashboardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        
        farmNameEditText = new EditText(this);
        latitudeEditText = new EditText(this);
        longitudeEditText = new EditText(this);
        addButton = new Button(this);
        
        addButton.setOnClickListener(v -> {
            Farm farm = new Farm();
            farm.setFarmName(farmNameEditText.getText().toString());
            farm.setLatitude(Double.parseDouble(latitudeEditText.getText().toString()));
            farm.setLongitude(Double.parseDouble(longitudeEditText.getText().toString()));
        });
    }
}
