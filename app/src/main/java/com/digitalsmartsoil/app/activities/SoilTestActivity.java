package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.digitalsmartsoil.app.models.SoilTest;
import com.digitalsmartsoil.app.viewmodels.SoilTestViewModel;

public class SoilTestActivity extends AppCompatActivity {
    private EditText nitrogenEditText;
    private EditText phosphorusEditText;
    private EditText potassiumEditText;
    private EditText pHEditText;
    private Button submitButton;
    private SoilTestViewModel soilTestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        soilTestViewModel = new ViewModelProvider(this).get(SoilTestViewModel.class);
        
        nitrogenEditText = new EditText(this);
        phosphorusEditText = new EditText(this);
        potassiumEditText = new EditText(this);
        pHEditText = new EditText(this);
        submitButton = new Button(this);
        
        submitButton.setOnClickListener(v -> {
            SoilTest test = new SoilTest();
            test.setNitrogen(Double.parseDouble(nitrogenEditText.getText().toString()));
            test.setPhosphorus(Double.parseDouble(phosphorusEditText.getText().toString()));
            test.setPotassium(Double.parseDouble(potassiumEditText.getText().toString()));
            test.setpH(Double.parseDouble(pHEditText.getText().toString()));
            soilTestViewModel.createSoilTest(test);
        });
    }
}
