package com.kurupi.arbustapp.dominio;

import java.util.List;

public class Especie {
    public static List<Especie> lista_de_especies_del_repositorio(RepositorioDeEspecies repositorio) {
        return repositorio.listar_especies();
    }

    public String su_nombre() {
        return null;
    }

    public String su_fichero_de_imagen() {
        return null;
    }
}
