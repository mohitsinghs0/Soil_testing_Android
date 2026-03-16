package com.digitalsmartsoil.app.activities;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        fragmentContainer = new FrameLayout(this);
        bottomNavigationView = new BottomNavigationView(this);
        
        // Set up bottom navigation listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case 1:
                    fragment = new com.digitalsmartsoil.app.fragments.DashboardFragment();
                    break;
                case 2:
                    fragment = new com.digitalsmartsoil.app.fragments.SoilTestFragment();
                    break;
                case 3:
                    fragment = new com.digitalsmartsoil.app.fragments.HistoryFragment();
                    break;
                case 4:
                    fragment = new com.digitalsmartsoil.app.fragments.ProfileFragment();
                    break;
            }
            if (fragment != null) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(fragmentContainer.getId(), fragment);
                ft.commit();
            }
            return true;
        });
    }
}
