package com.digitalsmartsoil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;

public class ProfileActivity extends AppCompatActivity {
    private ImageView userAvatar;
    private Button editButton;
    private EditText nameInput, mobileInput, emailInput;
    private Spinner genderSpinner;
    private Button saveButton, logoutButton;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userAvatar = findViewById(R.id.user_avatar);
        editButton = findViewById(R.id.edit_button);
        nameInput = findViewById(R.id.name_input);
        mobileInput = findViewById(R.id.mobile_input);
        emailInput = findViewById(R.id.email_input);
        genderSpinner = findViewById(R.id.gender_spinner);
        saveButton = findViewById(R.id.save_button);
        logoutButton = findViewById(R.id.logout_button);

        // Load mock data
        nameInput.setText("Mohit Singh");
        mobileInput.setText("9876543210");
        emailInput.setText("mohit@example.com");

        editButton.setOnClickListener(v -> toggleEditMode());
        saveButton.setOnClickListener(v -> saveProfile());
        logoutButton.setOnClickListener(v -> handleLogout());

        // Initial state: disabled
        setFieldsEnabled(false);
    }

    private void toggleEditMode() {
        isEditing = !isEditing;
        setFieldsEnabled(isEditing);
        editButton.setText(isEditing ? "Cancel" : "Edit");
    }

    private void setFieldsEnabled(boolean enabled) {
        nameInput.setEnabled(enabled);
        mobileInput.setEnabled(enabled);
        genderSpinner.setEnabled(enabled);
    }

    private void saveProfile() {
        Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show();
        isEditing = false;
        setFieldsEnabled(false);
        editButton.setText("Edit");
    }

    private void handleLogout() {
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
