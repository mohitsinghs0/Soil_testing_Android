package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.digitalsmartsoil.app.models.Profile;
import com.digitalsmartsoil.app.viewmodels.ProfileViewModel;

public class ProfileActivity extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private Button saveButton;
    private ProfileViewModel profileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        
        firstNameEditText = new EditText(this);
        lastNameEditText = new EditText(this);
        phoneEditText = new EditText(this);
        saveButton = new Button(this);
        
        saveButton.setOnClickListener(v -> {
            Profile profile = new Profile();
            // Set profile data
            profileViewModel.updateProfile(profileViewModel.userProfile.getValue().getUserId(), profile);
        });
    }
}
