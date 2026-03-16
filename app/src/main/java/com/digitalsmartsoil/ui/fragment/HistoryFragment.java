package com.digitalsmartsoil.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.model.SoilTest;
import com.digitalsmartsoil.util.MockDataGenerator;

import java.util.List;

public class HistoryFragment extends Fragment {
    private Spinner farmFilterSpinner;
    private Button exportPdfButton;
    private LinearLayout testListContainer;
    private List<SoilTest> soilTests;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        farmFilterSpinner = view.findViewById(R.id.farm_filter_spinner);
        exportPdfButton = view.findViewById(R.id.export_pdf_button);
        testListContainer = view.findViewById(R.id.test_list_container);

        soilTests = MockDataGenerator.generateMockSoilTests();

        exportPdfButton.setOnClickListener(v -> handleExportPdf());
        loadTestList();
    }

    private void loadTestList() {
        testListContainer.removeAllViews();

        if (soilTests.isEmpty()) {
            TextView emptyMsg = new TextView(requireContext());
            emptyMsg.setText("No soil tests yet");
            emptyMsg.setPadding(16, 16, 16, 16);
            emptyMsg.setTextSize(16);
            testListContainer.addView(emptyMsg);
            return;
        }

        for (SoilTest test : soilTests) {
            addTestCard(test);
        }
    }

    private void addTestCard(SoilTest test) {
        LinearLayout card = new LinearLayout(requireContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(16, 12, 16, 12);
        card.setBackgroundResource(R.drawable.card_background);

        TextView farmView = new TextView(requireContext());
        farmView.setText(test.farmName);
        farmView.setTextSize(14);
        farmView.setTypeface(null, android.graphics.Typeface.BOLD);

        TextView dateView = new TextView(requireContext());
        dateView.setText("Date: " + test.date);
        dateView.setTextSize(12);
        dateView.setPadding(0, 4, 0, 0);

        TextView dataView = new TextView(requireContext());
        dataView.setText("SOC: " + String.format("%.2f", test.soc) + "% | N: " + String.format("%.0f", test.nitrogen) + " kg/ha | pH: " + String.format("%.1f", test.ph));
        dataView.setTextSize(12);
        dataView.setPadding(0, 4, 0, 0);

        card.addView(farmView);
        card.addView(dateView);
        card.addView(dataView);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(4, 4, 4, 4);
        card.setLayoutParams(cardParams);

        testListContainer.addView(card);
    }

    private void handleExportPdf() {
        if (soilTests.isEmpty()) {
            Toast.makeText(getContext(), "No tests to export", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getContext(), "PDF export coming soon", Toast.LENGTH_SHORT).show();
    }
}
