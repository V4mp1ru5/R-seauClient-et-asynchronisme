 package com.example.myapplication;

import static java.lang.Long.parseLong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Model.Complexe;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.http.RetrofitUtil;
import com.example.myapplication.http.Service;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


 public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Service service = RetrofitUtil.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = findViewById(R.id.editTextText);
                String nom = editText.getText().toString();
                service.listRepos(nom + "").enqueue(new Callback<Complexe>() {
                    @Override
                    public void onResponse(Call<Complexe> call, Response<Complexe> response) {
                        if (response.isSuccessful()){
                            Complexe resultat = response.body();
                            Toast.makeText(MainActivity.this, resultat.toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            
                        }
                    }

                    @Override
                    public void onFailure(Call<Complexe> call, Throwable t) {
                        Log.i("RETROFIT", t.getMessage());
                    }
                });
            }
        });
    }

}