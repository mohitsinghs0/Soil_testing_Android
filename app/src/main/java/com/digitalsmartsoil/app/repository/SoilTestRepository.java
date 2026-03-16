package com.digitalsmartsoil.app.repository;

import retrofit2.Callback;
import com.digitalsmartsoil.app.api.SupabaseClient;
import com.digitalsmartsoil.app.api.SupabaseDbApi;
import com.digitalsmartsoil.app.models.SoilTest;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class SoilTestRepository {
    private SupabaseDbApi dbApi;
    private SessionManager sessionManager;

    public SoilTestRepository(SessionManager sessionManager) {
        this.dbApi = SupabaseClient.getRetrofitInstance().create(SupabaseDbApi.class);
        this.sessionManager = sessionManager;
    }

    public void getSoilTests(Callback<List<SoilTest>> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.getSoilTests(token).enqueue(callback);
    }

    public void createSoilTest(SoilTest soilTest, Callback<SoilTest> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.createSoilTest(token, soilTest).enqueue(callback);
    }

    public void getSoilTestsByFarm(String farmId, Callback<List<SoilTest>> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.getSoilTestsByFarm(token, farmId).enqueue(callback);
    }
}
