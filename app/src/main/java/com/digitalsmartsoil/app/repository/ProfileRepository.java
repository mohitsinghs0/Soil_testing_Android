package com.digitalsmartsoil.app.repository;

import retrofit2.Callback;
import com.digitalsmartsoil.app.api.SupabaseClient;
import com.digitalsmartsoil.app.api.SupabaseDbApi;
import com.digitalsmartsoil.app.models.Profile;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class ProfileRepository {
    private SupabaseDbApi dbApi;
    private SessionManager sessionManager;

    public ProfileRepository(SessionManager sessionManager) {
        this.dbApi = SupabaseClient.getRetrofitInstance().create(SupabaseDbApi.class);
        this.sessionManager = sessionManager;
    }

    public void getUserProfile(String userId, Callback<List<Profile>> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.getUserProfile(token, userId).enqueue(callback);
    }

    public void createProfile(Profile profile, Callback<Profile> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.createProfile(token, profile).enqueue(callback);
    }

    public void updateProfile(String userId, Profile profile, Callback<Profile> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.updateProfile(token, userId, profile).enqueue(callback);
    }
}
