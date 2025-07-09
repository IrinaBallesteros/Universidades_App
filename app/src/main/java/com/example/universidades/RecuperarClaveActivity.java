package com.example.universidades;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.universidades.interfaces.UsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecuperarClaveActivity extends AppCompatActivity {

    private EditText txtEmail;
    private Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_clave);

        inicializarVistas();
        configurarEventos();
    }

    private void inicializarVistas() {
        txtEmail = findViewById(R.id.txtEmail);
        btnRecuperar = findViewById(R.id.btnRecuperar);
    }

    private void configurarEventos() {
        btnRecuperar.setOnClickListener(v -> recuperarClave());
    }

    private void recuperarClave() {
        String email = txtEmail.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Ingresa un correo válido", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        UsuarioService service = ApiClient.getClient().create(UsuarioService.class);
        service.recuperarClave(usuario).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RecuperarClaveActivity.this,
                            "Si el correo está registrado, recibirás instrucciones para recuperar tu clave.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RecuperarClaveActivity.this,
                            "No se pudo procesar la solicitud", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                Toast.makeText(RecuperarClaveActivity.this,
                        "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
