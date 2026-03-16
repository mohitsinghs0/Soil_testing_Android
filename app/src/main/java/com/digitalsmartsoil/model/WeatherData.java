package com.digitalsmartsoil.model;

public class WeatherData {
    public double temperature;
    public double humidity;
    public double windSpeed;
    public String condition;

    public WeatherData(double temperature, double humidity, double windSpeed, String condition) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }
}
