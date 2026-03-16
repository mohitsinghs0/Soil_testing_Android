package com.digitalsmartsoil.ui.activity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;

public class AboutActivity extends AppCompatActivity {
    private LinearLayout aboutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutContainer = findViewById(R.id.about_container);

        addInfoCard("Our Mission", "Empowering Maharashtra farmers with AI-driven soil health insights for better crop yields and sustainable agriculture.", R.drawable.ic_launcher_background);
        addInfoCard("Research-Backed", "Based on PhD research using MobileNetV2 CNN model trained with ICAR lab data for accurate soil analysis.", R.drawable.ic_launcher_background);
        addInfoCard("Collaboration", "Developed in partnership with agricultural research institutes in Maharashtra to serve farming communities.", R.drawable.ic_launcher_background);
    }

    private void addInfoCard(String title, String content, int iconRes) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(16, 16, 16, 16);
        card.setBackgroundResource(R.drawable.card_background);
        
        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(18);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        
        TextView contentView = new TextView(this);
        contentView.setText(content);
        contentView.setTextSize(14);
        contentView.setPadding(0, 8, 0, 0);
        
        card.addView(titleView);
        card.addView(contentView);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(8, 8, 8, 8);
        card.setLayoutParams(cardParams);
        
        aboutContainer.addView(card);
    }
}
