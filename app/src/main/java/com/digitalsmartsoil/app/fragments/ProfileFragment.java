package com.digitalsmartsoil.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.digitalsmartsoil.app.models.Profile;
import com.digitalsmartsoil.app.viewmodels.ProfileViewModel;

public class ProfileFragment extends Fragment {
    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText phoneInput;
    private Button updateButton;
    private ProfileViewModel profileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getContext());
        
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        
        firstNameInput = new EditText(getContext());
        lastNameInput = new EditText(getContext());
        phoneInput = new EditText(getContext());
        updateButton = new Button(getContext());
        
        updateButton.setOnClickListener(v -> {
            Profile profile = new Profile();
            profile.setFarmName(firstNameInput.getText().toString());
            // Update profile
        });

        profileViewModel.userProfile.observe(getViewLifecycleOwner(), profile -> {
            if (profile != null) {
                firstNameInput.setText(profile.getFarmName());
            }
        });
        
        return view;
    }
}
