package com.digitalsmartsoil.app.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

import com.digitalsmartsoil.app.models.Farm;
import com.digitalsmartsoil.app.repository.FarmRepository;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {
    private FarmRepository farmRepository;
    public MutableLiveData<List<Farm>> farms = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public DashboardViewModel(Application application) {
        super(application);
        SessionManager sessionManager = new SessionManager(application);
        farmRepository = new FarmRepository(sessionManager);
    }

    public void loadFarms() {
        isLoading.setValue(true);
        farmRepository.getFarms(new Callback<List<Farm>>() {
            @Override
            public void onResponse(Call<List<Farm>> call, Response<List<Farm>> response) {
                isLoading.setValue(false);
                if (response.isSuccessful()) {
                    farms.setValue(response.body());
                } else {
                    errorMessage.setValue("Failed to load farms");
                }
            }

            @Override
            public void onFailure(Call<List<Farm>> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }

    public void deleteFarm(String farmId) {
        farmRepository.deleteFarm(farmId, new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    loadFarms();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
