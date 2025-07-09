package com.example.universidades.interfaces;

import com.example.universidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("/api/usuarios")
    Call<Void> crearUsuario(@Body Usuario usuario);

    @POST("/api/login")
    Call<Usuario> login(@Body Usuario usuario);

    @POST("/api/recuperar")
    Call<Void> recuperarClave(@Body Usuario usuario);

    @GET("/api/usuarios")
    Call<List<Usuario>> listarUsuarios();
}
