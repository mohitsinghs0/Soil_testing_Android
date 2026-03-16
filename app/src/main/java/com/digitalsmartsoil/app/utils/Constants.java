package com.digitalsmartsoil.app.utils;

public class Constants {
    // Supabase Configuration
    public static final String SUPABASE_URL = "https://your-project.supabase.co";
    public static final String SUPABASE_ANON_KEY = "your-anon-key-here";
    
    // API Endpoints
    public static final String SUPABASE_AUTH_URL = SUPABASE_URL + "/auth/v1";
    public static final String SUPABASE_DB_URL = SUPABASE_URL + "/rest/v1";
    public static final String SUPABASE_STORAGE_URL = SUPABASE_URL + "/storage/v1";
    
    // Weather API
    public static final String WEATHER_API_URL = "https://api.open-meteo.com/v1";
    
    // Database Tables
    public static final String TABLE_USERS = "users";
    public static final String TABLE_FARMS = "farms";
    public static final String TABLE_SOIL_TESTS = "soil_tests";
    public static final String TABLE_SOIL_RESULTS = "soil_results";
    public static final String TABLE_WEATHER = "weather_data";
    public static final String TABLE_PROFILES = "profiles";
    
    // SharedPreferences Keys
    public static final String PREF_AUTH_TOKEN = "auth_token";
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_USER_EMAIL = "user_email";
    public static final String PREF_LOGGED_IN = "is_logged_in";
    public static final String PREF_SELECTED_FARM = "selected_farm_id";
    
    // Status Values
    public static final String STATUS_LOW = "Low";
    public static final String STATUS_MEDIUM = "Medium";
    public static final String STATUS_HIGH = "High";
    
    // Soil Parameters
    public static final String PARAM_NITROGEN = "Nitrogen";
    public static final String PARAM_PHOSPHORUS = "Phosphorus";
    public static final String PARAM_POTASSIUM = "Potassium";
    public static final String PARAM_PH = "pH";
    public static final String PARAM_ORGANIC_MATTER = "Organic Matter";
    public static final String PARAM_MOISTURE = "Moisture";
}
