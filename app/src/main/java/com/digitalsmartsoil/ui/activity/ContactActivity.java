package com.digitalsmartsoil.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digitalsmartsoil.R;

public class ContactActivity extends AppCompatActivity {
    private EditText nameInput, mobileInput, messageInput;
    private Button submitButton, callSupportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nameInput = findViewById(R.id.name_input);
        mobileInput = findViewById(R.id.mobile_input);
        messageInput = findViewById(R.id.message_input);
        submitButton = findViewById(R.id.submit_button);
        callSupportButton = findViewById(R.id.call_support_button);

        submitButton.setOnClickListener(v -> handleSubmit());
        callSupportButton.setOnClickListener(v -> handleCallSupport());
    }

    private void handleSubmit() {
        String name = nameInput.getText().toString().trim();
        String mobile = mobileInput.getText().toString().trim();
        String message = messageInput.getText().toString().trim();

        if (name.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Thank you! We'll get back to you soon", Toast.LENGTH_SHORT).show();
        
        // Clear form
        nameInput.setText("");
        mobileInput.setText("");
        messageInput.setText("");
    }

    private void handleCallSupport() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919999999999"));
        startActivity(intent);
    }
}
