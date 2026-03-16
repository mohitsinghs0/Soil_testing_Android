package com.digitalsmartsoil.app.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface SupabaseStorageApi {
    
    @POST("object/sign/{bucket}/{path}")
    Call<String> uploadFile(
            @Header("Authorization") String token,
            @Path("bucket") String bucket,
            @Path("path") String path
    );
    
    @GET("object/sign/{bucket}/{path}")
    Call<String> getSignedUrl(
            @Header("Authorization") String token,
            @Path("bucket") String bucket,
            @Path("path") String path
    );
    
    @DELETE("object/{bucket}/{path}")
    Call<Void> deleteFile(
            @Header("Authorization") String token,
            @Path("bucket") String bucket,
            @Path("path") String path
    );
}
