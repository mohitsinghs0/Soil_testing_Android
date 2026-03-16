package com.digitalsmartsoil.app.utils;

import java.util.ArrayList;
import java.util.List;

public class CropRecommender {
    
    private static final String[] CROPS_RICE = {"Rice", "Wheat", "Corn"};
    private static final String[] CROPS_LOAMY = {"Tomato", "Potato", "Cucumber", "Carrot"};
    private static final String[] CROPS_SANDY = {"Peanut", "Watermelon", "Muskmelon"};
    
    public static List<String> recommendCrops(String soilType) {
        List<String> crops = new ArrayList<>();
        
        if (soilType == null) return crops;
        
        switch (soilType.toLowerCase()) {
            case "clay":
                for (String crop : CROPS_RICE) crops.add(crop);
                break;
            case "loamy":
                for (String crop : CROPS_LOAMY) crops.add(crop);
                break;
            case "sandy":
                for (String crop : CROPS_SANDY) crops.add(crop);
                break;
            default:
                crops.add("Consult agricultural expert");
        }
        
        return crops;
    }

    public static double calculateSuitabilityScore(String cropType, double soilHealth) {
        if (cropType == null) return 0.0;
        
        // Mock calculation based on soil health
        return Math.min(100, soilHealth * 1.5);
    }

    public static String getFertilizerRecommendation(String cropType) {
        if (cropType == null) return "Balanced fertilizer";
        
        switch (cropType.toLowerCase()) {
            case "rice":
                return "NPK 10:26:26 - Rice specific fertilizer";
            case "wheat":
                return "NPK 20:20:0 - Wheat fertilizer";
            case "tomato":
                return "NPK 5:10:10 - Fruiting crop fertilizer";
            case "potato":
                return "NPK 10:15:20 - Tuber crop fertilizer";
            default:
                return "Balanced NPK fertilizer (10:10:10)";
        }
    }
}
