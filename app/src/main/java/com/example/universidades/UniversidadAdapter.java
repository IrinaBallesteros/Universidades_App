package com.example.universidades;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UniversidadAdapter extends RecyclerView.Adapter<UniversidadAdapter.ViewHolder> {

    private final List<Universidad> universidades;

    public UniversidadAdapter(List<Universidad> universidades) {
        this.universidades = universidades;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_universidad, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Universidad u = universidades.get(position);

        holder.txtNombre.setText(u.getNombre());
        holder.txtCategoria.setText("Categoría: " + u.getCategoria());
        holder.txtCiudad.setText("Ciudad: " + u.getCiudad());
        holder.txtWeb.setText("Web: " + u.getWeb());
        holder.txtRector.setText("Rector: " + u.getRector());
        holder.txtTelefono.setText("Teléfono: " + u.getTelefono());
        holder.txtEmail.setText("Email: " + u.getEmail());
        holder.txtAcceso.setText("Acceso: " + u.getAcceso());
        holder.txtNumCarreras.setText("N° Carreras: " + u.getNumCarreras());
        holder.txtNumSedes.setText("N° Sedes: " + u.getNumSedes());
    }

    @Override
    public int getItemCount() {
        return universidades.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtCategoria, txtCiudad, txtWeb, txtRector,
                txtTelefono, txtEmail, txtAcceso, txtNumCarreras, txtNumSedes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtCategoria = itemView.findViewById(R.id.txtCategoria);
            txtCiudad = itemView.findViewById(R.id.txtCiudad);
            txtWeb = itemView.findViewById(R.id.txtWeb);
            txtRector = itemView.findViewById(R.id.txtRector);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtAcceso = itemView.findViewById(R.id.txtAcceso);
            txtNumCarreras = itemView.findViewById(R.id.txtNumCarreras);
            txtNumSedes = itemView.findViewById(R.id.txtNumSedes);
        }
    }
}
