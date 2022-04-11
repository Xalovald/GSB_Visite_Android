package com.example.gsb_visites;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Visites {
    @SerializedName("hydra:member") //notation retrofit2
    private List<Visite> _visites;

    public Visites(List<Visite> visites) {
        this._visites= visites;
    }

    public List<Visite> getVisites() {
        return _visites;
    }
}
