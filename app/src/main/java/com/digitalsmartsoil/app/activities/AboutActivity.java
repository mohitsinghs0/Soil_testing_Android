package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView aboutTextView = new TextView(this);
        aboutTextView.setText("SmartSoil - Digital Soil Testing Application\nVersion 1.0\nPowered by Supabase and Open-Meteo");
    }
}
