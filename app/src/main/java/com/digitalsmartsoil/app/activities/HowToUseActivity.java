package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HowToUseActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView guideTextView = new TextView(this);
        guideTextView.setText("How to Use SmartSoil:\n\n" +
                "1. Sign up or login to your account\n" +
                "2. Add your farm details\n" +
                "3. Conduct soil tests\n" +
                "4. View results and recommendations\n" +
                "5. Get crop suggestions");
    }
}
