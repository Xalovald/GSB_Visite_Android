package com.example.gsb_visites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gsb_visites.Adapters.RecyclerViewAdapterPraticiens;
import com.example.gsb_visites.Interfaces.RecyclerViewClickListener;
import com.example.gsb_visites.Listeners.RecyclerTouchListener;
import com.example.gsb_visites.databinding.ActivityPraticienBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.example.gsb_visites.Adapters.RecyclerViewAdapterPraticiens;

public class PraticienActivity extends AppCompatActivity {

    private  ActivityPraticienBinding binding;
    private String _email;
    private String _password;
    private String _token;
    private ArrayList<Visiteur> _allVisiteurs;
    private ArrayList<Praticien> _praticiens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPraticienBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        _token = intent.getStringExtra("token");
        _email = intent.getStringExtra("email");
        this._praticiens = new ArrayList<Praticien>();
        getVisiteurs();
        /*binding.rvPraticiens.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvPraticiens.setLayoutManager(layoutManager);
        binding.rvPraticiens.setFocusable(false);

       RecyclerViewAdapterPraticiens adapter = new RecyclerViewAdapterPraticiens(_mesItems);

        binding.rvPraticiens.setAdapter(adapter);
        binding.rvPraticiens.addOnItemTouchListener(new RecyclerTouchListener(this, binding.rvPraticiens, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(PraticienActivity.this, ResultatActivity.class);
                intent.putExtra("ville",getPraticiens(position));
                setIntent(intent);
                startActivity(intent);
            }
        }));*/
    }
       /* public void getPraticiens() {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Praticiens> call = service.getAllPraticiens("Bearer " + _token);

        call.enqueue(new Callback<Praticiens>() {
            @Override
            public void onResponse(Call<Praticiens> call, Response<Praticiens> response) {
                String result = "";
                Praticiens praticiens = response.body();
                for (Praticien v : praticiens.getPraticiens()) {
                    result += "\n" + v.toString();
                }
                //binding.tvToken.setText(result);
            }

            @Override
            public void onFailure(Call<Praticiens> call, Throwable t) {
                Toast.makeText(PraticienActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    public void getVisiteurs() {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Visiteurs> call = service.getAllVisiteurs("Bearer " + _token);
        call.enqueue(new Callback<Visiteurs>() {

            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
                Visiteurs visiteurs = response.body();
                    for(Visiteur visiteur : visiteurs.getVisiteurs()) {
                        if(visiteur.getEmail().equals(_email)){

                            binding.rvPraticiens.setHasFixedSize(true);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                            binding.rvPraticiens.setLayoutManager(layoutManager);
                            binding.rvPraticiens.setFocusable(false);

                            binding.tvUsername.setText(binding.tvUsername.getText() + visiteur.getUsername());
                            binding.tvEmail.setText(binding.tvEmail.getText() + visiteur.getVis_tel());
                            binding.tvNom.setText(binding.tvNom.getText() + visiteur.getVis_nom());
                            binding.tvPrenom.setText(binding.tvPrenom.getText() + visiteur.getVis_prenom());
                            for(String praticien : visiteur.getVisiteur_praticien()){
                                getPraticien(Integer.valueOf(praticien.substring(16)));
                            }
                            binding.rvPraticiens.addOnItemTouchListener(new RecyclerTouchListener(PraticienActivity.this, binding.rvPraticiens, new RecyclerViewClickListener() {
                                @Override
                                public void onClick(View view, int position) {
                                    Intent intent = new Intent(PraticienActivity.this, VisitesActivity.class);
                                    intent.putExtra("token",_token);
                                    intent.putExtra("id",getCurrentPraticien(position).getId().toString());
                                    setIntent(intent);
                                    startActivity(intent);
                                }
                            }));
                        }
                    }
                }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(PraticienActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Praticien getCurrentPraticien(int unInt)
    {
        Praticien praticien = _praticiens.get(unInt);
        return praticien;
    }
    public void getPraticien(int intPraticien) {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Praticien> call = service.getPraticien("Bearer " + _token, intPraticien);
        call.enqueue(new Callback<Praticien>() {

            @Override
            public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                Praticien praticien = response.body();


                _praticiens.add(praticien);
                RecyclerViewAdapterPraticiens adapter = new RecyclerViewAdapterPraticiens(_praticiens);

                binding.rvPraticiens.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Praticien> call, Throwable t) {
                Toast.makeText(PraticienActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}