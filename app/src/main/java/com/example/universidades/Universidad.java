package com.example.universidades;

import com.google.gson.annotations.SerializedName;

public class Universidad {

    @SerializedName("id")
    private String id;  // Cambiar a int si el backend devuelve número

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("web")
    private String web;

    @SerializedName("rector")
    private String rector;

    @SerializedName("email")
    private String email;

    @SerializedName("acceso")
    private String acceso;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("ciudad")
    private String ciudad;

    @SerializedName("num_carreras")
    private int numCarreras;

    @SerializedName("num_sedes")
    private int numSedes;

    // Constructor vacío necesario para Gson
    public Universidad() {}

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getWeb() { return web; }
    public String getRector() { return rector; }
    public String getEmail() { return email; }
    public String getAcceso() { return acceso; }
    public String getTelefono() { return telefono; }
    public String getCiudad() { return ciudad; }
    public int getNumCarreras() { return numCarreras; }
    public int getNumSedes() { return numSedes; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setWeb(String web) { this.web = web; }
    public void setRector(String rector) { this.rector = rector; }
    public void setEmail(String email) { this.email = email; }
    public void setAcceso(String acceso) { this.acceso = acceso; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setNumCarreras(int numCarreras) { this.numCarreras = numCarreras; }
    public void setNumSedes(int numSedes) { this.numSedes = numSedes; }
}
