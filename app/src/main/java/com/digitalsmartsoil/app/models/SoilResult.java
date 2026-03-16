package com.digitalsmartsoil.app.models;

import java.io.Serializable;

public class SoilResult implements Serializable {
    private String id;
    private String soilTestId;
    private String parameter;
    private double value;
    private String unit;
    private String interpretation;
    private String recommendation;

    public SoilResult() {
    }

    public SoilResult(String soilTestId, String parameter, double value) {
        this.soilTestId = soilTestId;
        this.parameter = parameter;
        this.value = value;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
