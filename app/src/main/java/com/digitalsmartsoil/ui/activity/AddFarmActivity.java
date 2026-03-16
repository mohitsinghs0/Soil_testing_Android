package com.digitalsmartsoil.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;

public class AddFarmActivity extends AppCompatActivity {
    private EditText farmNameInput, villageInput, cityInput, districtInput;
    private Spinner cropTypeSpinner;
    private Button saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);

        farmNameInput = findViewById(R.id.farm_name_input);
        villageInput = findViewById(R.id.village_input);
        cityInput = findViewById(R.id.city_input);
        districtInput = findViewById(R.id.district_input);
        cropTypeSpinner = findViewById(R.id.crop_type_spinner);
        saveButton = findViewById(R.id.save_button);
        cancelButton = findViewById(R.id.cancel_button);

        saveButton.setOnClickListener(v -> saveFarm());
        cancelButton.setOnClickListener(v -> finish());
    }

    private void saveFarm() {
        String farmName = farmNameInput.getText().toString().trim();
        String village = villageInput.getText().toString().trim();
        String city = cityInput.getText().toString().trim();
        String district = districtInput.getText().toString().trim();
        String cropType = cropTypeSpinner.getSelectedItem().toString();

        if (farmName.isEmpty() || village.isEmpty()) {
            Toast.makeText(this, "Farm name and village are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Farm added successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
