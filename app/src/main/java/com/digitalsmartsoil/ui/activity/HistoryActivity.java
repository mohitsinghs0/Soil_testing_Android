package com.digitalsmartsoil.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.model.SoilTest;
import com.digitalsmartsoil.util.MockDataGenerator;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private Spinner farmFilterSpinner;
    private Button exportPdfButton;
    private LinearLayout testListContainer;
    private List<SoilTest> soilTests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        farmFilterSpinner = findViewById(R.id.farm_filter_spinner);
        exportPdfButton = findViewById(R.id.export_pdf_button);
        testListContainer = findViewById(R.id.test_list_container);

        soilTests = MockDataGenerator.generateMockSoilTests();

        exportPdfButton.setOnClickListener(v -> handleExportPdf());
        
        loadTestList();
    }

    private void loadTestList() {
        testListContainer.removeAllViews();
        
        if (soilTests.isEmpty()) {
            TextView emptyMsg = new TextView(this);
            emptyMsg.setText("No soil tests yet");
            emptyMsg.setPadding(16, 16, 16, 16);
            emptyMsg.setTextSize(16);
            testListContainer.addView(emptyMsg);
            return;
        }

        for (SoilTest test : soilTests) {
            TextView testCard = new TextView(this);
            String cardText = test.farmName + "\n" +
                    "Date: " + test.date + "\n" +
                    "SOC: " + String.format("%.2f", test.soc) + "% | " +
                    "N: " + String.format("%.0f", test.nitrogen) + " kg/ha | " +
                    "pH: " + String.format("%.1f", test.ph);
            
            testCard.setText(cardText);
            testCard.setPadding(16, 16, 16, 16);
            testCard.setTextSize(12);
            testCard.setBackgroundResource(R.drawable.card_background);
            testCard.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            ((LinearLayout.LayoutParams) testCard.getLayoutParams()).setMargins(8, 8, 8, 8);
            
            testListContainer.addView(testCard);
        }
    }

    private void handleExportPdf() {
        if (soilTests.isEmpty()) {
            Toast.makeText(this, "No tests to export", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "PDF export feature coming soon", Toast.LENGTH_SHORT).show();
    }
}
