package com.digitalsmartsoil.app.repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.digitalsmartsoil.app.api.SupabaseClient;
import com.digitalsmartsoil.app.api.SupabaseDbApi;
import com.digitalsmartsoil.app.models.Farm;
import com.digitalsmartsoil.app.utils.SessionManager;

import java.util.List;

public class FarmRepository {
    private SupabaseDbApi dbApi;
    private SessionManager sessionManager;

    public FarmRepository(SessionManager sessionManager) {
        this.dbApi = SupabaseClient.getRetrofitInstance().create(SupabaseDbApi.class);
        this.sessionManager = sessionManager;
    }

    public void getFarms(Callback<List<Farm>> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.getFarms(token).enqueue(callback);
    }

    public void createFarm(Farm farm, Callback<Farm> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.createFarm(token, farm).enqueue(callback);
    }

    public void updateFarm(String farmId, Farm farm, Callback<Farm> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.updateFarm(token, farmId, farm).enqueue(callback);
    }

    public void deleteFarm(String farmId, Callback<Void> callback) {
        String token = "Bearer " + sessionManager.getAuthToken();
        dbApi.deleteFarm(token, farmId).enqueue(callback);
    }
}
