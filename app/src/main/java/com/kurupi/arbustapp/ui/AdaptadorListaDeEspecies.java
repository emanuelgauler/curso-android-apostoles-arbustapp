package com.kurupi.arbustapp.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kurupi.arbustapp.R;
import com.kurupi.arbustapp.dominio.Especie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class AdaptadorListaDeEspecies extends RecyclerView.Adapter<AdaptadorListaDeEspecies.PortaEspecie> {
    private List<Especie> lista_de_especies;

    public AdaptadorListaDeEspecies(List<Especie> especies) {
        establecer_lista_de_especies(especies);
    }

    private void establecer_lista_de_especies(List<Especie> especies) {
        this.lista_de_especies = especies;
    }

    @NonNull
    @Override
    public PortaEspecie onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.esquema_vista_de_especie, viewGroup, false);
        return new PortaEspecie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortaEspecie viewHolder, int posicion) {
        Especie especie = lista_de_especies.get(posicion);
        try {
            viewHolder.cambiar_contenido_segun_especie(especie);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return lista_de_especies.size();
    }

    public static class PortaEspecie extends RecyclerView.ViewHolder {
        public PortaEspecie(@NonNull View itemView) {
            super(itemView);
        }

        public void cambiar_contenido_segun_especie(Especie especie) throws FileNotFoundException {
            cambiar_imagen_segun_especie(especie);
            cambiar_nombre_segun_especie(especie);
        }

        private void cambiar_nombre_segun_especie(Especie especie) throws FileNotFoundException {
            ImageView view = itemView.findViewById(R.id.recurso_imagen_del_ejemplar);
            view.setImageBitmap(bitmap_del_ejemplar(especie));
        }

        private Bitmap bitmap_del_ejemplar(Especie especie) throws FileNotFoundException {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 10;
            FileInputStream stream_especie = new FileInputStream(especie.su_fichero_de_imagen());
            return BitmapFactory
                    .decodeStream(stream_especie, null, opts);
        }

        private void cambiar_imagen_segun_especie(Especie especie) {
            TextView view = itemView.findViewById(R.id.recurso_nombre_de_especie);
            view.setText(especie.su_nombre());
        }
    }
}
