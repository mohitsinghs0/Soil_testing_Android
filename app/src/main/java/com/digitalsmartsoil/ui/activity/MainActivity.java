package com.digitalsmartsoil.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.digitalsmartsoil.R;
import com.digitalsmartsoil.ui.fragment.DashboardFragment;
import com.digitalsmartsoil.ui.fragment.HistoryFragment;
import com.digitalsmartsoil.ui.fragment.ProfileFragment;
import com.digitalsmartsoil.ui.fragment.SoilTestFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private FragmentManager fragmentManager;
    private Button navButton1, navButton2, navButton3, navButton4, navButton5;
    private ImageView userIcon;
    private TextView userName;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        bottomNav = findViewById(R.id.bottom_nav);
        navButton1 = findViewById(R.id.nav_button_1);
        navButton2 = findViewById(R.id.nav_button_2);
        navButton3 = findViewById(R.id.nav_button_3);
        navButton4 = findViewById(R.id.nav_button_4);
        navButton5 = findViewById(R.id.nav_button_5);
        userIcon = findViewById(R.id.user_icon);
        userName = findViewById(R.id.user_name);
        logoutButton = findViewById(R.id.logout_button);

        // Set mock user name
        userName.setText("Hi, Mohit!");

        // Bottom Navigation
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();
            
            if (itemId == R.id.nav_dashboard) {
                selectedFragment = new DashboardFragment();
            } else if (itemId == R.id.nav_soil_test) {
                selectedFragment = new SoilTestFragment();
            } else if (itemId == R.id.nav_history) {
                selectedFragment = new HistoryFragment();
            } else if (itemId == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
            }

            if (selectedFragment != null) {
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            }
            return true;
        });

        // Top navigation buttons
        navButton1.setOnClickListener(v -> selectBottomNav(R.id.nav_dashboard));
        navButton2.setOnClickListener(v -> showNavMenu());
        navButton3.setOnClickListener(v -> selectBottomNav(R.id.nav_history));
        navButton4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
        navButton5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HowToUseActivity.class)));

        userIcon.setOnClickListener(v -> selectBottomNav(R.id.nav_profile));
        logoutButton.setOnClickListener(v -> handleLogout());

        // Set default fragment
        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.nav_dashboard);
        }
    }

    private void selectBottomNav(int itemId) {
        bottomNav.setSelectedItemId(itemId);
    }

    private void showNavMenu() {
        // Placeholder menu - can add Contact here
        PopupMenu menu = new PopupMenu(this, navButton2);
        menu.getMenu().add(0, 1, 0, "Contact");
        menu.getMenu().add(0, 2, 1, "About");
        menu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == 1) {
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
                return true;
            } else if (item.getItemId() == 2) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
            }
            return false;
        });
        menu.show();
    }

    private void handleLogout() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
