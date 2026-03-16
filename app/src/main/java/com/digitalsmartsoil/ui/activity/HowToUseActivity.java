package com.digitalsmartsoil.ui.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;

public class HowToUseActivity extends AppCompatActivity {
    private LinearLayout stepsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        stepsContainer = findViewById(R.id.steps_container);

        addStepCard(1, "Take Photo", "Take a clear photo of your soil sample or test tube in natural sunlight");
        addStepCard(2, "Upload Image", "Upload the photo to the app");
        addStepCard(3, "Get Predictions", "AI predicts soil parameters instantly");
        addStepCard(4, "View Recommendations", "Get crop recommendations based on results");
    }

    private void addStepCard(int stepNum, String title, String description) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(16, 16, 16, 16);
        card.setBackgroundResource(R.drawable.card_background);

        TextView stepView = new TextView(this);
        stepView.setText("Step " + stepNum);
        stepView.setTextSize(12);
        stepView.setTypeface(null, android.graphics.Typeface.BOLD);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(16);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        titleView.setPadding(0, 8, 0, 0);

        TextView descView = new TextView(this);
        descView.setText(description);
        descView.setTextSize(14);
        descView.setPadding(0, 8, 0, 0);

        card.addView(stepView);
        card.addView(titleView);
        card.addView(descView);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(8, 8, 8, 8);
        card.setLayoutParams(cardParams);

        stepsContainer.addView(card);
    }
}
