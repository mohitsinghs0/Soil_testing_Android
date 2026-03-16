package com.digitalsmartsoil.app.models;

import java.io.Serializable;

public class SoilTest implements Serializable {
    private String id;
    private String farmId;
    private String userId;
    private double nitrogen;
    private double phosphorus;
    private double potassium;
    private double pH;
    private double organic_matter;
    private double moisture;
    private String status;
    private long testDate;
    private long createdAt;

    public SoilTest() {
    }

    public SoilTest(String farmId, String userId) {
        this.farmId = farmId;
        this.userId = userId;
        this.testDate = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(double nitrogen) {
        this.nitrogen = nitrogen;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getOrganic_matter() {
        return organic_matter;
    }

    public void setOrganic_matter(double organic_matter) {
        this.organic_matter = organic_matter;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTestDate() {
        return testDate;
    }

    public void setTestDate(long testDate) {
        this.testDate = testDate;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
