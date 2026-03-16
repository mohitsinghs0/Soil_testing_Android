package com.digitalsmartsoil.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.ui.activity.LoginActivity;

public class ProfileFragment extends Fragment {
    private ImageView userAvatar;
    private Button editButton;
    private EditText nameInput, mobileInput, emailInput;
    private Spinner genderSpinner;
    private Button saveButton, logoutButton;
    private boolean isEditing = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userAvatar = view.findViewById(R.id.user_avatar);
        editButton = view.findViewById(R.id.edit_button);
        nameInput = view.findViewById(R.id.name_input);
        mobileInput = view.findViewById(R.id.mobile_input);
        emailInput = view.findViewById(R.id.email_input);
        genderSpinner = view.findViewById(R.id.gender_spinner);
        saveButton = view.findViewById(R.id.save_button);
        logoutButton = view.findViewById(R.id.logout_button);

        // Load mock data
        nameInput.setText("Mohit Singh");
        mobileInput.setText("9876543210");
        emailInput.setText("mohit@example.com");

        editButton.setOnClickListener(v -> toggleEditMode());
        saveButton.setOnClickListener(v -> saveProfile());
        logoutButton.setOnClickListener(v -> handleLogout());

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
        Toast.makeText(getContext(), "Profile saved", Toast.LENGTH_SHORT).show();
        isEditing = false;
        setFieldsEnabled(false);
        editButton.setText("Edit");
    }

    private void handleLogout() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        requireActivity().finish();
    }
}
