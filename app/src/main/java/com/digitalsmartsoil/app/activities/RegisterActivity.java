package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.digitalsmartsoil.app.viewmodels.AuthViewModel;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button registerButton;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        
        emailEditText = new EditText(this);
        passwordEditText = new EditText(this);
        firstNameEditText = new EditText(this);
        lastNameEditText = new EditText(this);
        registerButton = new Button(this);
        
        registerButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            authViewModel.signup(email, password);
        });
    }
}
