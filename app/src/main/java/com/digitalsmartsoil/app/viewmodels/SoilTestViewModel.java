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

public class SoilTestViewModel extends AndroidViewModel {
    private SoilTestRepository soilTestRepository;
    public MutableLiveData<SoilTest> soilTest = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public SoilTestViewModel(Application application) {
        super(application);
        SessionManager sessionManager = new SessionManager(application);
        soilTestRepository = new SoilTestRepository(sessionManager);
    }

    public void createSoilTest(SoilTest test) {
        isLoading.setValue(true);
        soilTestRepository.createSoilTest(test, new Callback<SoilTest>() {
            @Override
            public void onResponse(Call<SoilTest> call, Response<SoilTest> response) {
                isLoading.setValue(false);
                if (response.isSuccessful()) {
                    soilTest.setValue(response.body());
                } else {
                    errorMessage.setValue("Failed to create soil test");
                }
            }

            @Override
            public void onFailure(Call<SoilTest> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
