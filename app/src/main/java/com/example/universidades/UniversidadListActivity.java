package com.example.universidades;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.universidades.interfaces.UniversidadService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UniversidadListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UniversidadAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidad_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cargarUniversidades();
    }

    private void cargarUniversidades() {
        UniversidadService service = ApiClient.getClient().create(UniversidadService.class);
        service.getUniversidades().enqueue(new Callback<List<Universidad>>() {
            @Override
            public void onResponse(@NonNull Call<List<Universidad>> call, @NonNull Response<List<Universidad>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new UniversidadAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(UniversidadListActivity.this, "Respuesta vacía o incorrecta", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Universidad>> call, @NonNull Throwable t) {
                Toast.makeText(UniversidadListActivity.this, "Fallo: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
