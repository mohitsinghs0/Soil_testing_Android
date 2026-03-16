package com.digitalsmartsoil.util;

import com.digitalsmartsoil.model.Farm;
import com.digitalsmartsoil.model.SoilTest;
import com.digitalsmartsoil.model.WeatherData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockDataGenerator {
    private static final Random random = new Random();
    private static final String[] CROPS = {"Wheat", "Soybean", "Rice", "Sugarcane", "Cotton", "Jowar", "Bajra"};
    private static final String[] CITIES = {"Pune", "Mumbai", "Nagpur", "Nashik", "Aurangabad"};
    private static final String[] VILLAGES = {"Hadapsar", "Kothrud", "Baner", "Indiranagar", "Yerwada"};
    private static final String[] DISTRICTS = {"Pune", "Nashik", "Nagpur", "Aurangabad", "Solapur"};

    public static List<Farm> generateMockFarms() {
        List<Farm> farms = new ArrayList<>();
        farms.add(new Farm("1", "Sharad Farm", "Hadapsar", "Pune", "Pune", "Wheat", 18.5, 73.8, "15 Mar 2026"));
        farms.add(new Farm("2", "Green Valley", "Kothrud", "Pune", "Pune", "Sugarcane", 18.48, 73.76, "12 Mar 2026"));
        farms.add(new Farm("3", "Heritage Fields", "Baner", "Pune", "Pune", "Cotton", 18.57, 73.81, "10 Mar 2026"));
        return farms;
    }

    public static List<SoilTest> generateMockSoilTests() {
        List<SoilTest> tests = new ArrayList<>();
        String[] dates = {"15 Mar 2026", "12 Mar 2026", "10 Mar 2026", "08 Mar 2026", "05 Mar 2026"};
        String[] farms = {"Sharad Farm", "Green Valley", "Heritage Fields", "Sharad Farm", "Green Valley"};
        
        for (int i = 0; i < dates.length; i++) {
            tests.add(new SoilTest(
                String.valueOf(i + 1),
                String.valueOf((i % 3) + 1),
                farms[i],
                dates[i],
                "",
                randomDouble(0.3, 2.3),
                randomDouble(50, 350),
                randomDouble(5, 65),
                randomDouble(50, 450),
                randomDouble(5.0, 8.0),
                "Wheat, Sugarcane"
            ));
        }
        return tests;
    }

    public static List<String> generateRecommendedCrops() {
        List<String> crops = new ArrayList<>();
        crops.add("Wheat");
        crops.add("Sugarcane");
        crops.add("Soybean");
        return crops;
    }

    public static WeatherData generateMockWeather() {
        return new WeatherData(
            randomDouble(20, 35),    // temperature
            randomDouble(40, 80),    // humidity
            randomDouble(5, 20),     // wind speed
            "Partly Cloudy"
        );
    }

    public static SoilTest generateSoilTestResult() {
        return new SoilTest(
            "" + System.currentTimeMillis(),
            "1",
            "Current Farm",
            getCurrentDate(),
            "",
            randomDouble(0.3, 2.3),
            randomDouble(50, 350),
            randomDouble(5, 65),
            randomDouble(50, 450),
            randomDouble(5.0, 8.0),
            "Wheat, Sugarcane"
        );
    }

    private static double randomDouble(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    private static String getCurrentDate() {
        return "17 Mar 2026";
    }

    public static String getStatusLabel(double value, String parameter) {
        if ("SOC".equals(parameter)) {
            return value < 0.5 ? "Low" : (value < 1.2 ? "Medium" : "High");
        } else if ("Nitrogen".equals(parameter)) {
            return value < 120 ? "Low" : (value < 240 ? "Medium" : "High");
        } else if ("Phosphorus".equals(parameter)) {
            return value < 15 ? "Low" : (value < 35 ? "Medium" : "High");
        } else if ("Potassium".equals(parameter)) {
            return value < 120 ? "Low" : (value < 280 ? "Medium" : "High");
        } else if ("pH".equals(parameter)) {
            return value < 6.0 ? "Low" : (value < 7.5 ? "Medium" : "High");
        }
        return "Normal";
    }

    public static int getStatusColor(String status) {
        if ("Low".equals(status)) return 0xFFFF6B6B;
        if ("Medium".equals(status)) return 0xFFFFC107;
        if ("High".equals(status)) return 0xFF4CAF50;
        return 0xFF757575;
    }
}
