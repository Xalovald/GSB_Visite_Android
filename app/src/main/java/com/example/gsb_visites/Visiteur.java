package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Visiteur implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("username")
    private String username;
    @SerializedName("vis_nom")
    private String vis_nom;
    @SerializedName("vis_prenom")
    private String vis_prenom;
    @SerializedName("vis_tel")
    private String vis_tel;
    @SerializedName("Praticien_Visiteur")
    private List<String> visiteur_praticien;

    public Visiteur(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public Integer getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getVis_nom() {
        return vis_nom;
    }

    public String getVis_prenom() {
        return vis_prenom;
    }

    public String getVis_tel() {
        return vis_tel;
    }

    public List<String> getVisiteur_praticien() {
        return visiteur_praticien;
    }

}
