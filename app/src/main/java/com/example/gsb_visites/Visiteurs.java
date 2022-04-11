package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Visiteurs {
    @SerializedName("hydra:member") //notation retrofit2
    private List<Visiteur> _visiteurs;

    public Visiteurs(List<Visiteur> visitors) {
        this._visiteurs = visitors;
    }

    public List<Visiteur> getVisiteurs() {
        return _visiteurs;
    }

}






