package com.digitalsmartsoil.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.model.SoilTest;
import com.digitalsmartsoil.ui.activity.SoilTestActivity;
import com.digitalsmartsoil.util.MockDataGenerator;

public class SoilTestFragment extends Fragment {
    private Spinner farmSpinner;
    private ImageView imageUploadArea;
    private Button uploadImageButton, predictButton;
    private ProgressBar loadingProgress;
    private LinearLayout resultsContainer;
    private boolean imageSelected = false;
    private SoilTest currentResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soil_test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        farmSpinner = view.findViewById(R.id.farm_spinner);
        imageUploadArea = view.findViewById(R.id.image_upload_area);
        uploadImageButton = view.findViewById(R.id.upload_image_button);
        predictButton = view.findViewById(R.id.predict_button);
        loadingProgress = view.findViewById(R.id.loading_progress);
        resultsContainer = view.findViewById(R.id.results_container);

        uploadImageButton.setOnClickListener(v -> handleImageUpload());
        predictButton.setOnClickListener(v -> handlePredict());

        resultsContainer.setVisibility(View.GONE);
    }

    private void handleImageUpload() {
        imageSelected = true;
        imageUploadArea.setImageResource(R.drawable.ic_launcher_background);
        Toast.makeText(getContext(), "Image selected (mock)", Toast.LENGTH_SHORT).show();
    }

    private void handlePredict() {
        if (!imageSelected) {
            Toast.makeText(getContext(), "Please select an image first", Toast.LENGTH_SHORT).show();
            return;
        }

        loadingProgress.setVisibility(View.VISIBLE);
        predictButton.setEnabled(false);

        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            currentResult = MockDataGenerator.generateSoilTestResult();
            loadingProgress.setVisibility(View.GONE);
            predictButton.setEnabled(true);
            displayResults();
            Toast.makeText(getContext(), "Prediction complete", Toast.LENGTH_SHORT).show();
        }, 2000);
    }

    private void displayResults() {
        resultsContainer.setVisibility(View.VISIBLE);
        resultsContainer.removeAllViews();

        TextView titleView = new TextView(requireContext());
        titleView.setText("Soil Analysis Results");
        titleView.setTextSize(18);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        resultsContainer.addView(titleView);

        addResultCard("SOC", currentResult.soc, "%");
        addResultCard("Nitrogen", currentResult.nitrogen, "kg/ha");
        addResultCard("Phosphorus", currentResult.phosphorus, "kg/ha");
        addResultCard("Potassium", currentResult.potassium, "kg/ha");
        addResultCard("pH", currentResult.ph, "");
    }

    private void addResultCard(String parameter, double value, String unit) {
        TextView card = new TextView(requireContext());
        String status = MockDataGenerator.getStatusLabel(value, parameter);
        card.setText(parameter + ": " + String.format("%.2f", value) + " " + unit + " (" + status + ")");
        card.setPadding(16, 12, 16, 12);
        card.setTextSize(14);
        resultsContainer.addView(card);
    }
}
