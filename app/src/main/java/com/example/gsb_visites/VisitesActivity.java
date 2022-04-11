package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visites.Adapters.RecyclerViewAdapterPraticiens;
import com.example.gsb_visites.Adapters.RecyclerViewAdapterVisites;
import com.example.gsb_visites.Interfaces.RecyclerViewClickListener;
import com.example.gsb_visites.Listeners.RecyclerTouchListener;
import com.example.gsb_visites.databinding.ActivityVisitesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitesActivity extends AppCompatActivity {

    private ActivityVisitesBinding binding;
    private String _token;
    private String _id;
    private ArrayList<Visite> _listVisites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rvVisites.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvVisites.setLayoutManager(layoutManager);
        binding.rvVisites.setFocusable(false);
        _listVisites = new ArrayList<Visite>();

        Intent intent = getIntent();
        _token = intent.getStringExtra("token");
        _id = intent.getStringExtra("id");
        getPraticien(Integer.valueOf(_id));
        getVisites();
    }

    public void getPraticien(int intPraticien) {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Praticien> call = service.getPraticien("Bearer " + _token, intPraticien);
        call.enqueue(new Callback<Praticien>() {

            @Override
            public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                Praticien praticien = response.body();

                binding.tvNom.setText(praticien.getPra_nom());
                binding.tvPrenom.setText(praticien.getPra_prenom());
                binding.tvMail.setText(praticien.getPra_mail());
                binding.tvTel.setText(praticien.getPra_tel());
                binding.tvCodePostal.setText(praticien.getPra_code_postal());
                binding.tvVille.setText(praticien.getPra_ville());
                binding.tvRue.setText(praticien.getPra_rue());
            }

            @Override
            public void onFailure(Call<Praticien> call, Throwable t) {
                Toast.makeText(VisitesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getVisites() {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Visites> call = service.getVisites("Bearer " + _token);
        call.enqueue(new Callback<Visites>() {

            @Override
            public void onResponse(Call<Visites> call, Response<Visites> response) {
                Visites visites = response.body();
                for(Visite visite : visites.getVisites()) {
                    if (visite.getVst_praticien().substring(16).equals(_id)) {
                        _listVisites.add(visite);
                        RecyclerViewAdapterVisites adapter = new RecyclerViewAdapterVisites(_listVisites);
                        binding.rvVisites.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Visites> call, Throwable t) {
                Toast.makeText(VisitesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}