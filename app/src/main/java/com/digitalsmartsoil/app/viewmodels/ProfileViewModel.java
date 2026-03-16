package com.digitalsmartsoil.app.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

import com.digitalsmartsoil.app.models.Profile;
import com.digitalsmartsoil.app.repository.ProfileRepository;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository profileRepository;
    public MutableLiveData<Profile> userProfile = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public ProfileViewModel(Application application) {
        super(application);
        SessionManager sessionManager = new SessionManager(application);
        profileRepository = new ProfileRepository(sessionManager);
    }

    public void loadUserProfile(String userId) {
        isLoading.setValue(true);
        profileRepository.getUserProfile(userId, new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                isLoading.setValue(false);
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    userProfile.setValue(response.body().get(0));
                } else {
                    errorMessage.setValue("Failed to load profile");
                }
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }

    public void updateProfile(String userId, Profile profile) {
        isLoading.setValue(true);
        profileRepository.updateProfile(userId, profile, new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                isLoading.setValue(false);
                if (response.isSuccessful()) {
                    userProfile.setValue(response.body());
                } else {
                    errorMessage.setValue("Failed to update profile");
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
