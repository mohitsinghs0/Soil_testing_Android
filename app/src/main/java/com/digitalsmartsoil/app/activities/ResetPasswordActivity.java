package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        newPasswordEditText = new EditText(this);
        confirmPasswordEditText = new EditText(this);
        resetButton = new Button(this);
        
        resetButton.setOnClickListener(v -> {
            // Reset password with new password
        });
    }
}
