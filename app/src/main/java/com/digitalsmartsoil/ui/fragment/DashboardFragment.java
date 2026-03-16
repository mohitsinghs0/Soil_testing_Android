package com.digitalsmartsoil.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.model.Farm;
import com.digitalsmartsoil.ui.activity.AddFarmActivity;
import com.digitalsmartsoil.ui.activity.HistoryActivity;
import com.digitalsmartsoil.ui.activity.SoilTestActivity;
import com.digitalsmartsoil.util.MockDataGenerator;

import java.util.List;

public class DashboardFragment extends Fragment {
    private LinearLayout farmsContainer;
    private Button addFarmButton;
    private List<Farm> farms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        farmsContainer = view.findViewById(R.id.farms_container);
        addFarmButton = view.findViewById(R.id.add_farm_button);

        farms = MockDataGenerator.generateMockFarms();

        addFarmButton.setOnClickListener(v -> startActivity(new Intent(requireContext(), AddFarmActivity.class)));

        loadFarms();
    }

    private void loadFarms() {
        farmsContainer.removeAllViews();

        if (farms.isEmpty()) {
            TextView emptyMsg = new TextView(requireContext());
            emptyMsg.setText("No farms yet. Add your first farm!");
            emptyMsg.setPadding(16, 32, 16, 32);
            emptyMsg.setTextSize(16);
            farmsContainer.addView(emptyMsg);
            return;
        }

        for (Farm farm : farms) {
            addFarmCard(farm);
        }
    }

    private void addFarmCard(Farm farm) {
        LinearLayout card = new LinearLayout(requireContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(16, 16, 16, 16);
        card.setBackgroundResource(R.drawable.card_background);

        // Farm name
        TextView nameView = new TextView(requireContext());
        nameView.setText(farm.name);
        nameView.setTextSize(18);
        nameView.setTypeface(null, android.graphics.Typeface.BOLD);

        // Location
        TextView locationView = new TextView(requireContext());
        locationView.setText("📍 " + farm.village + ", " + farm.district);
        locationView.setTextSize(12);
        locationView.setPadding(0, 8, 0, 0);

        // Crop & Last test
        TextView infoView = new TextView(requireContext());
        infoView.setText("Crop: " + farm.cropType + " | Last test: " + farm.lastTestDate);
        infoView.setTextSize(12);
        infoView.setPadding(0, 4, 0, 0);

        // Buttons
        LinearLayout buttonRow = new LinearLayout(requireContext());
        buttonRow.setOrientation(LinearLayout.HORIZONTAL);
        buttonRow.setPadding(0, 12, 0, 0);

        Button testButton = new Button(requireContext());
        testButton.setText("Test");
        testButton.setOnClickListener(v -> startActivity(new Intent(requireContext(), SoilTestActivity.class)));
        testButton.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        Button historyButton = new Button(requireContext());
        historyButton.setText("History");
        historyButton.setOnClickListener(v -> startActivity(new Intent(requireContext(), HistoryActivity.class)));
        historyButton.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        ((LinearLayout.LayoutParams) historyButton.getLayoutParams()).leftMargin = 8;

        buttonRow.addView(testButton);
        buttonRow.addView(historyButton);

        card.addView(nameView);
        card.addView(locationView);
        card.addView(infoView);
        card.addView(buttonRow);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(8, 8, 8, 8);
        card.setLayoutParams(cardParams);

        farmsContainer.addView(card);
    }
}
