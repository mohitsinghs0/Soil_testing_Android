package com.digitalsmartsoil.app.models;

import java.io.Serializable;

public class Profile implements Serializable {
    private String id;
    private String userId;
    private String farmName;
    private String region;
    private String soilType;
    private String cropType;
    private long createdAt;
    private long updatedAt;

    public Profile() {
    }

    public Profile(String userId, String farmName, String region, String soilType, String cropType) {
        this.userId = userId;
        this.farmName = farmName;
        this.region = region;
        this.soilType = soilType;
        this.cropType = cropType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
