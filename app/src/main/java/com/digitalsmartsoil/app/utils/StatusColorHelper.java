package com.digitalsmartsoil.app.utils;

import android.graphics.Color;

public class StatusColorHelper {
    
    public static int getStatusColor(String status) {
        if (status == null) return Color.GRAY;
        
        switch (status.toLowerCase()) {
            case "low":
                return Color.parseColor("#FF6B6B");  // Red
            case "medium":
                return Color.parseColor("#FFA500");  // Orange
            case "high":
                return Color.parseColor("#4CAF50");  // Green
            default:
                return Color.GRAY;
        }
    }

    public static int getStatusTextColorRes(String status) {
        if (status == null) return android.R.color.white;
        
        switch (status.toLowerCase()) {
            case "low":
            case "medium":
                return android.R.color.white;
            case "high":
                return android.R.color.white;
            default:
                return android.R.color.white;
        }
    }

    public static String getStatusMessage(String status) {
        if (status == null) return "Unknown";
        
        switch (status.toLowerCase()) {
            case "low":
                return "Low - Needs attention";
            case "medium":
                return "Medium - Monitor";
            case "high":
                return "High - Optimal";
            default:
                return "Unknown";
        }
    }
}
