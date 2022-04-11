package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class Visite implements Serializable {
    @SerializedName("vst_praticien")
    private String vst_praticien;
    @SerializedName("dateVisite")
    private Date dateVisite;
    @SerializedName("vst_commentaire")
    private String vst_commentaire;


    public Visite(Date dateVisite, String vst_commentaire) {
        this.dateVisite = dateVisite;
        this.vst_commentaire = vst_commentaire;
    }

    public String getCommentaire() {
        return vst_commentaire;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public String getVst_praticien() {
        return vst_praticien;
    }
}
