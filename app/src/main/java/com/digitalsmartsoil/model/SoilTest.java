package com.digitalsmartsoil.model;

import java.io.Serializable;

public class SoilTest implements Serializable {
    public String id;
    public String farmId;
    public String farmName;
    public String date;
    public String imageUrl;
    public double soc; // Soil Organic Carbon
    public double nitrogen;
    public double phosphorus;
    public double potassium;
    public double ph;
    public String recommendedCrops;

    public SoilTest(String id, String farmId, String farmName, String date, String imageUrl,
                    double soc, double nitrogen, double phosphorus, double potassium, double ph, String recommendedCrops) {
        this.id = id;
        this.farmId = farmId;
        this.farmName = farmName;
        this.date = date;
        this.imageUrl = imageUrl;
        this.soc = soc;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.ph = ph;
        this.recommendedCrops = recommendedCrops;
    }
}
