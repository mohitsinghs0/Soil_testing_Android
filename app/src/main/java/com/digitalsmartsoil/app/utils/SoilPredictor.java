package com.digitalsmartsoil.app.utils;

public class SoilPredictor {
    
    public static String predictSoilStatus(double nitrogen, double phosphorus, double potassium) {
        int score = 0;
        
        if (nitrogen >= 40 && nitrogen <= 60) score++;
        if (phosphorus >= 25 && phosphorus <= 50) score++;
        if (potassium >= 200 && potassium <= 350) score++;
        
        if (score >= 2) {
            return Constants.STATUS_HIGH;
        } else if (score == 1) {
            return Constants.STATUS_MEDIUM;
        } else {
            return Constants.STATUS_LOW;
        }
    }

    public static String getRecommendation(String parameter, double value) {
        switch (parameter) {
            case Constants.PARAM_NITROGEN:
                if (value < 40) return "Nitrogen level is low. Add nitrogen fertilizer.";
                if (value > 60) return "Nitrogen level is high. Reduce nitrogen input.";
                return "Nitrogen level is optimal.";
                
            case Constants.PARAM_PHOSPHORUS:
                if (value < 25) return "Phosphorus level is low. Add phosphorus fertilizer.";
                if (value > 50) return "Phosphorus level is high. Reduce phosphorus input.";
                return "Phosphorus level is optimal.";
                
            case Constants.PARAM_POTASSIUM:
                if (value < 200) return "Potassium level is low. Add potassium fertilizer.";
                if (value > 350) return "Potassium level is high. Reduce potassium input.";
                return "Potassium level is optimal.";
                
            case Constants.PARAM_PH:
                if (value < 6.0) return "Soil is too acidic. Add lime.";
                if (value > 7.5) return "Soil is too alkaline. Add sulfur.";
                return "Soil pH is optimal.";
                
            default:
                return "Continue monitoring this parameter.";
        }
    }
}
