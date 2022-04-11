package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Praticien implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("pra_nom")
    private String pra_nom;
    @SerializedName("pra_prenom")
    private String pra_prenom;
    @SerializedName("pra_tel")
    private String pra_tel;
    @SerializedName("pra_mail")
    private String pra_mail;
    @SerializedName("pra_rue")
    private String pra_rue;
    @SerializedName("pra_codePostal")
    private String pra_code_postal;
    @SerializedName("pra_ville")
    private String pra_ville;
    @SerializedName("pra_coef_notoriete")
    private String pra_coef_notoriete;

    public Praticien(String nom, String prenom) {
        this.pra_nom = nom;
        this.pra_prenom = prenom;
    }

    public String getPra_nom() {
        return pra_nom;
    }

    public String getPra_prenom() {
        return pra_prenom;
    }

    public Integer getId() {
        return id;
    }

    public String getPra_tel() {
        return pra_tel;
    }

    public String getPra_mail() {
        return pra_mail;
    }

    public String getPra_rue() {
        return pra_rue;
    }

    public String getPra_code_postal() {
        return pra_code_postal;
    }

    public String getPra_ville() {
        return pra_ville;
    }
}