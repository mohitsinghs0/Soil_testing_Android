package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        nameEditText = new EditText(this);
        messageEditText = new EditText(this);
        sendButton = new Button(this);
        
        sendButton.setOnClickListener(v -> {
            // Send contact message
        });
    }
}
