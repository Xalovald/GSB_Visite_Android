package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Praticiens {
    @SerializedName("hydra:member") //notation retrofit2
    private List<Praticien> _praticiens;

    public Praticiens(List<Praticien> praticiens) {
        this._praticiens = praticiens;
    }

    public List<Praticien> getPraticiens() {
        return _praticiens;
    }

}