package com.digitalsmartsoil.model;

public class Farm {
    public String id;
    public String name;
    public String village;
    public String city;
    public String district;
    public String cropType;
    public double latitude;
    public double longitude;
    public String lastTestDate;

    public Farm(String id, String name, String village, String city, String district, 
                String cropType, double latitude, double longitude, String lastTestDate) {
        this.id = id;
        this.name = name;
        this.village = village;
        this.city = city;
        this.district = district;
        this.cropType = cropType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastTestDate = lastTestDate;
    }
}
