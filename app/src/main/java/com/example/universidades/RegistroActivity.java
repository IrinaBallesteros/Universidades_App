package com.example.universidades;

import android.annotation.SuppressLint;
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

public class RegistroActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword, txtNombre, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnCrearUsuario = findViewById(R.id.btnCrearUsuario);

        btnCrearUsuario.setOnClickListener(v -> {
            if (camposVacios()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString().trim()).matches()) {
                Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show();
                return;
            }

            if (txtPassword.getText().toString().trim().length() < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setUsername(txtUsername.getText().toString().trim());
            usuario.setPassword(txtPassword.getText().toString().trim());
            usuario.setNombre(txtNombre.getText().toString().trim());
            usuario.setEmail(txtEmail.getText().toString().trim());

            UsuarioService service = ApiClient.getClient().create(UsuarioService.class);
            service.crearUsuario(usuario).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(RegistroActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                        finish(); // Vuelve al login
                    } else {
                        Toast.makeText(RegistroActivity.this, "Error al crear usuario", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Toast.makeText(RegistroActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    private boolean camposVacios() {
        return txtUsername.getText().toString().trim().isEmpty() ||
                txtPassword.getText().toString().trim().isEmpty() ||
                txtNombre.getText().toString().trim().isEmpty() ||
                txtEmail.getText().toString().trim().isEmpty();
    }
}
