package com.digitalsmartsoil.app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.digitalsmartsoil.app.utils.Constants;

public class SupabaseClient {
    private static Retrofit retrofitInstance;

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(Constants.SUPABASE_DB_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }

    public static Retrofit getAuthRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.SUPABASE_AUTH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getWeatherRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.WEATHER_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
