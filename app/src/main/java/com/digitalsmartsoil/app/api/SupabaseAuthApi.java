package com.digitalsmartsoil.app.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Header;

import com.digitalsmartsoil.app.models.User;

public interface SupabaseAuthApi {
    
    @POST("/signup")
    Call<AuthResponse> signup(@Body SignupRequest request);
    
    @POST("/token?grant_type=password")
    Call<AuthResponse> login(@Body LoginRequest request);
    
    @GET("/user")
    Call<User> getUser(@Header("Authorization") String token);
    
    @POST("/logout")
    Call<Void> logout(@Header("Authorization") String token);

    class SignupRequest {
        public String email;
        public String password;

        public SignupRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    class LoginRequest {
        public String email;
        public String password;

        public LoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    class AuthResponse {
        public String access_token;
        public String user;
        public String error;
    }
}
