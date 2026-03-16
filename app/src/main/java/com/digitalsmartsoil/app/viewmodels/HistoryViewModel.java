package com.digitalsmartsoil.app.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

import com.digitalsmartsoil.app.models.SoilTest;
import com.digitalsmartsoil.app.repository.SoilTestRepository;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private SoilTestRepository soilTestRepository;
    public MutableLiveData<List<SoilTest>> soilTests = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public HistoryViewModel(Application application) {
        super(application);
        SessionManager sessionManager = new SessionManager(application);
        soilTestRepository = new SoilTestRepository(sessionManager);
    }

    public void loadSoilTests(String farmId) {
        isLoading.setValue(true);
        soilTestRepository.getSoilTestsByFarm(farmId, new Callback<List<SoilTest>>() {
            @Override
            public void onResponse(Call<List<SoilTest>> call, Response<List<SoilTest>> response) {
                isLoading.setValue(false);
                if (response.isSuccessful()) {
                    soilTests.setValue(response.body());
                } else {
                    errorMessage.setValue("Failed to load soil tests");
                }
            }

            @Override
            public void onFailure(Call<List<SoilTest>> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
