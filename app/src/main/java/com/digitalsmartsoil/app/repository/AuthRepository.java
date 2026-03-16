package com.digitalsmartsoil.app.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.digitalsmartsoil.app.api.SupabaseAuthApi;
import com.digitalsmartsoil.app.api.SupabaseClient;
import com.digitalsmartsoil.app.models.User;
import com.digitalsmartsoil.app.utils.SessionManager;

public class AuthRepository {
    private SupabaseAuthApi authApi;
    private SessionManager sessionManager;

    public AuthRepository(SessionManager sessionManager) {
        this.authApi = SupabaseClient.getAuthRetrofitInstance().create(SupabaseAuthApi.class);
        this.sessionManager = sessionManager;
    }

    public void signup(String email, String password, Callback<SupabaseAuthApi.AuthResponse> callback) {
        SupabaseAuthApi.SignupRequest request = new SupabaseAuthApi.SignupRequest(email, password);
        authApi.signup(request).enqueue(callback);
    }

    public void login(String email, String password, Callback<SupabaseAuthApi.AuthResponse> callback) {
        SupabaseAuthApi.LoginRequest request = new SupabaseAuthApi.LoginRequest(email, password);
        authApi.login(request).enqueue(callback);
    }

    public void logout(Callback<Void> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        authApi.logout(token).enqueue(callback);
        sessionManager.logout();
    }

    public void getUser(Callback<User> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        authApi.getUser(token).enqueue(callback);
    }

    public boolean isLoggedIn() {
        return sessionManager.isLoggedIn() && sessionManager.getAuthToken() != null;
    }
}
