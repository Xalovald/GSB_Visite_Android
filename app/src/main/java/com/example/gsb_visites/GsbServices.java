package com.example.gsb_visites;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbServices {
    @GET("/api/visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization") String authorization);
    @GET("/api/praticiens/{id}")
    Call<Praticien> getPraticien(@Header("Authorization") String authorization, @Path("id") int id);
    @GET("/api/visites")
    Call<Visites> getVisites(@Header("Authorization") String authorization);
    @POST("/api/login_check")
    Call<Token> getToken(@Body Visiteur visiteur);
}
