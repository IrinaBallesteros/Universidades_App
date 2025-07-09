package com.example.universidades;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("email")
    private String email;


    public Usuario() {}

    // Constructor para login
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @NonNull
    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

