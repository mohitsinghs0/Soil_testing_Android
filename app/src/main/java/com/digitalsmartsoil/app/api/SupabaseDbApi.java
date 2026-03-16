package com.digitalsmartsoil.app.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.digitalsmartsoil.app.models.Farm;
import com.digitalsmartsoil.app.models.SoilTest;
import com.digitalsmartsoil.app.models.Profile;
import com.digitalsmartsoil.app.models.User;

import java.util.List;

public interface SupabaseDbApi {
    
    // Farms
    @GET("farms")
    Call<List<Farm>> getFarms(@Header("Authorization") String token);
    
    @POST("farms")
    Call<Farm> createFarm(@Header("Authorization") String token, @Body Farm farm);
    
    @PUT("farms?id=eq.{farmId}")
    Call<Farm> updateFarm(@Header("Authorization") String token, @Path("farmId") String farmId, @Body Farm farm);
    
    @DELETE("farms?id=eq.{farmId}")
    Call<Void> deleteFarm(@Header("Authorization") String token, @Path("farmId") String farmId);
    
    // Soil Tests
    @GET("soil_tests")
    Call<List<SoilTest>> getSoilTests(@Header("Authorization") String token);
    
    @POST("soil_tests")
    Call<SoilTest> createSoilTest(@Header("Authorization") String token, @Body SoilTest soilTest);
    
    @GET("soil_tests?farm_id=eq.{farmId}")
    Call<List<SoilTest>> getSoilTestsByFarm(@Header("Authorization") String token, @Path("farmId") String farmId);
    
    // Profiles
    @GET("profiles?user_id=eq.{userId}")
    Call<List<Profile>> getUserProfile(@Header("Authorization") String token, @Path("userId") String userId);
    
    @POST("profiles")
    Call<Profile> createProfile(@Header("Authorization") String token, @Body Profile profile);
    
    @PUT("profiles?user_id=eq.{userId}")
    Call<Profile> updateProfile(@Header("Authorization") String token, @Path("userId") String userId, @Body Profile profile);
}
