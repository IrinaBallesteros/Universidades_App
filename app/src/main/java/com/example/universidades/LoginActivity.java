package com.example.universidades;

import static com.example.universidades.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnCrearUsuario;
        btnCrearUsuario = findViewById(id.btnCrearUsuario);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);

        btnCrearUsuario.setOnClickListener(v -> {
            startActivity(new Intent(this, RegistroActivity.class));
        });

        btnRecuperar.setOnClickListener(v -> {
            startActivity(new Intent(this, RecuperarClaveActivity.class));
        });

        btnLogin.setOnClickListener(view -> {
            String username = txtUsername.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario usuario = new Usuario(username, password);

            UsuarioService service = ApiClient.getClient().create(UsuarioService.class);
            Call<Usuario> call = service.login(usuario);

            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(@NonNull Call<Usuario> call, @NonNull Response<Usuario> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Usuario usuarioLogueado = response.body();
                        Toast.makeText(LoginActivity.this, "¡Bienvenido " + usuarioLogueado.getNombre() + "!", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(LoginActivity.this, UniversidadListActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Usuario> call, @NonNull Throwable t) {
                    Toast.makeText(LoginActivity.this, "Fallo de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}

