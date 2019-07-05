package com.kurupi.arbustapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.kurupi.arbustapp.dominio.Especie;
import com.kurupi.arbustapp.ui.ActividadEditarEspecie;
import com.kurupi.arbustapp.ui.AdaptadorListaDeEspecies;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adaptador_lista_de_especies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adaptador_lista_de_especies = new AdaptadorListaDeEspecies(lista_de_especies());
        RecyclerView vista_de_especies = findViewById(R.id.recurso_vista_de_especies);
        vista_de_especies.setLayoutManager(new LinearLayoutManager(this));
        vista_de_especies.setAdapter(adaptador_lista_de_especies);

        FloatingActionButton fab = findViewById(R.id.recurso_boton_agregar_especie);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar_actividad_para_editar_una_especie(view);
            }
        });
    }

    private List<Especie> lista_de_especies() {
        List<Especie> o = null;
        return o;
    }

    private void iniciar_actividad_para_editar_una_especie(View view) {
        Intent lanzar_actividad_para_editar_una_especie = new Intent(MainActivity.this, ActividadEditarEspecie.class);
        startActivity(lanzar_actividad_para_editar_una_especie);
        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          //      .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
