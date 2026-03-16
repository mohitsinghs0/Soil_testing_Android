package com.digitalsmartsoil.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREFS_NAME = "SmartSoilPrefs";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveAuthToken(String token) {
        editor.putString(Constants.PREF_AUTH_TOKEN, token);
        editor.apply();
    }

    public String getAuthToken() {
        return sharedPreferences.getString(Constants.PREF_AUTH_TOKEN, null);
    }

    public void saveUserId(String userId) {
        editor.putString(Constants.PREF_USER_ID, userId);
        editor.apply();
    }

    public String getUserId() {
        return sharedPreferences.getString(Constants.PREF_USER_ID, null);
    }

    public void saveUserEmail(String email) {
        editor.putString(Constants.PREF_USER_EMAIL, email);
        editor.apply();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(Constants.PREF_USER_EMAIL, null);
    }

    public void setLoggedIn(boolean isLoggedIn) {
        editor.putBoolean(Constants.PREF_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(Constants.PREF_LOGGED_IN, false);
    }

    public void saveSelectedFarm(String farmId) {
        editor.putString(Constants.PREF_SELECTED_FARM, farmId);
        editor.apply();
    }

    public String getSelectedFarm() {
        return sharedPreferences.getString(Constants.PREF_SELECTED_FARM, null);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}
