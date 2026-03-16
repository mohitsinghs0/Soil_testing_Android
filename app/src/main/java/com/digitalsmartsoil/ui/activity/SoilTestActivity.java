package com.digitalsmartsoil.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.model.SoilTest;
import com.digitalsmartsoil.util.MockDataGenerator;

public class SoilTestActivity extends AppCompatActivity {
    private Spinner farmSpinner;
    private ImageView imageUploadArea;
    private Button uploadImageButton, predictButton, saveResultButton;
    private ProgressBar loadingProgress;
    private LinearLayout resultsContainer;
    private TextView resultsTitle;
    private boolean imageSelected = false;
    private boolean predictionDone = false;
    private SoilTest currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test);

        farmSpinner = findViewById(R.id.farm_spinner);
        imageUploadArea = findViewById(R.id.image_upload_area);
        uploadImageButton = findViewById(R.id.upload_image_button);
        predictButton = findViewById(R.id.predict_button);
        saveResultButton = findViewById(R.id.save_result_button);
        loadingProgress = findViewById(R.id.loading_progress);
        resultsContainer = findViewById(R.id.results_container);
        resultsTitle = findViewById(R.id.results_title);

        uploadImageButton.setOnClickListener(v -> handleImageUpload());
        predictButton.setOnClickListener(v -> handlePredict());
        saveResultButton.setOnClickListener(v -> handleSaveResult());

        resultsContainer.setVisibility(android.view.View.GONE);
    }

    private void handleImageUpload() {
        // Mock: just mark image as selected
        imageSelected = true;
        imageUploadArea.setImageResource(R.drawable.ic_launcher_background); // placeholder
        Toast.makeText(this, "Image selected (mock)", Toast.LENGTH_SHORT).show();
    }

    private void handlePredict() {
        if (!imageSelected) {
            Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show loading
        loadingProgress.setVisibility(android.view.View.VISIBLE);
        predictButton.setEnabled(false);

        // Simulate prediction delay
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            currentResult = MockDataGenerator.generateSoilTestResult();
            loadingProgress.setVisibility(android.view.View.GONE);
            predictButton.setEnabled(true);
            
            // Show results
            displayResults();
            predictionDone = true;
            Toast.makeText(SoilTestActivity.this, "Prediction complete", Toast.LENGTH_SHORT).show();
        }, 2000);
    }

    private void displayResults() {
        resultsContainer.setVisibility(android.view.View.VISIBLE);
        resultsTitle.setText("Soil Analysis Results");

        // Add result cards to container
        addResultCard("SOC", currentResult.soc, "%");
        addResultCard("Nitrogen", currentResult.nitrogen, "kg/ha");
        addResultCard("Phosphorus", currentResult.phosphorus, "kg/ha");
        addResultCard("Potassium", currentResult.potassium, "kg/ha");
        addResultCard("pH", currentResult.ph, "");
    }

    private void addResultCard(String parameter, double value, String unit) {
        // Create a simple text card for each parameter
        TextView card = new TextView(this);
        String status = MockDataGenerator.getStatusLabel(value, parameter);
        card.setText(parameter + ": " + String.format("%.2f", value) + " " + unit + " (" + status + ")");
        card.setPadding(16, 16, 16, 16);
        card.setTextSize(14);
        resultsContainer.addView(card);
    }

    private void handleSaveResult() {
        if (!predictionDone) {
            Toast.makeText(this, "Please run prediction first", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Result saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
