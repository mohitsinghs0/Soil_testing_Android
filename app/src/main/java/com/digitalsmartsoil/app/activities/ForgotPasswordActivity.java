package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText emailEditText;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        emailEditText = new EditText(this);
        resetButton = new Button(this);
        
        resetButton.setOnClickListener(v -> {
            // Send password reset email
        });
    }
}
