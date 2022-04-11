package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsb_visites.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String _token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        final Button button = binding.btnConnect;
        EditText editUsername = binding.editName;
        EditText editPassword = binding.editPassword;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    binding.tvError.setText("");
                    getToken(editUsername.getText().toString(),editPassword.getText().toString());
            }
        });
        //getToken();
        //getUsers();
    }

    public void getToken(String email, String password) {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Token> call = service.getToken(new Visiteur(password, email));
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                Token token = response.body();
                //for(Visiteur v : visiteurs.getVisiteurs()){
                //binding.tvToken.setText(token.getToken());
                if (response.code() == 200) {
                    _token = token.getToken();

                    Intent intent = new Intent(MainActivity.this, PraticienActivity.class);
                    intent.putExtra("token",_token);
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);
                    startActivity(intent);
                } else if (response.code() == 401) {
                    binding.tvError.setText("Le mot de passe ou le nom d'utilisateur est incorrect");
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}