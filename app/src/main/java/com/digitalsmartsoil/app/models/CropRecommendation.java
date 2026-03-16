package com.digitalsmartsoil.app.models;

import java.io.Serializable;

public class CropRecommendation implements Serializable {
    private String id;
    private String soilTestId;
    private String cropName;
    private double suitabilityScore;
    private String recommendation;
    private String fertilizer;
    private String irrigation;

    public CropRecommendation() {
    }

    public CropRecommendation(String soilTestId, String cropName, double suitabilityScore) {
        this.soilTestId = soilTestId;
        this.cropName = cropName;
        this.suitabilityScore = suitabilityScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoilTestId() {
        return soilTestId;
    }

    public void setSoilTestId(String soilTestId) {
        this.soilTestId = soilTestId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public double getSuitabilityScore() {
        return suitabilityScore;
    }

    public void setSuitabilityScore(double suitabilityScore) {
        this.suitabilityScore = suitabilityScore;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }

    public String getIrrigation() {
        return irrigation;
    }

    public void setIrrigation(String irrigation) {
        this.irrigation = irrigation;
    }
}
