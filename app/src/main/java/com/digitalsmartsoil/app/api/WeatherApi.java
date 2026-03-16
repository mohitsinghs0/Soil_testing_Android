package com.digitalsmartsoil.app.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface WeatherApi {
    
    @GET("forecast")
    Call<WeatherResponse> getWeather(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("current") String current,
            @Query("hourly") String hourly,
            @Query("timezone") String timezone
    );

    class WeatherResponse {
        public CurrentWeather current;
        public Map<String, Object> hourly;
    }

    class CurrentWeather {
        public double temperature;
        public double relative_humidity;
        public double weather_code;
        public double wind_speed;
    }
}
