package com.digitalsmartsoil.app.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.digitalsmartsoil.app.api.SupabaseAuthApi;
import com.digitalsmartsoil.app.repository.AuthRepository;
import com.digitalsmartsoil.app.utils.SessionManager;

public class AuthViewModel extends AndroidViewModel {
    private AuthRepository authRepository;
    private SessionManager sessionManager;
    public MutableLiveData<String> authToken = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public AuthViewModel(Application application) {
        super(application);
        sessionManager = new SessionManager(application);
        authRepository = new AuthRepository(sessionManager);
    }

    public void signup(String email, String password) {
        isLoading.setValue(true);
        authRepository.signup(email, password, new Callback<SupabaseAuthApi.AuthResponse>() {
            @Override
            public void onResponse(Call<SupabaseAuthApi.AuthResponse> call, Response<SupabaseAuthApi.AuthResponse> response) {
                isLoading.setValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    authToken.setValue(response.body().access_token);
                    sessionManager.saveAuthToken(response.body().access_token);
                } else {
                    errorMessage.setValue("Signup failed");
                }
            }

            @Override
            public void onFailure(Call<SupabaseAuthApi.AuthResponse> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }

    public void login(String email, String password) {
        isLoading.setValue(true);
        authRepository.login(email, password, new Callback<SupabaseAuthApi.AuthResponse>() {
            @Override
            public void onResponse(Call<SupabaseAuthApi.AuthResponse> call, Response<SupabaseAuthApi.AuthResponse> response) {
                isLoading.setValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    authToken.setValue(response.body().access_token);
                    sessionManager.saveAuthToken(response.body().access_token);
                    sessionManager.setLoggedIn(true);
                } else {
                    errorMessage.setValue("Login failed");
                }
            }

            @Override
            public void onFailure(Call<SupabaseAuthApi.AuthResponse> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }

    public void logout() {
        authRepository.logout(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                sessionManager.logout();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                sessionManager.logout();
            }
        });
    }

    public boolean isLoggedIn() {
        return authRepository.isLoggedIn();
    }
}
