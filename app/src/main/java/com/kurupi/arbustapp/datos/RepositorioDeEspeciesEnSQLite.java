package com.kurupi.arbustapp.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kurupi.arbustapp.dominio.Especie;
import com.kurupi.arbustapp.dominio.RepositorioDeEspecies;

import java.util.List;

public class RepositorioDeEspeciesEnSQLite
        extends SQLiteOpenHelper
        implements RepositorioDeEspecies {

    private static final String BD_ESPECIES = "especies.db";
    private static final String TABLA_ESPECIES = "especies";
    private static final String COLUMNA_NOMBRE = "nombre";
    private static final String TABLA_EJEMPLARES = "ejemplares";
    private static final String COLUMNA_ALTURA = "altura";

    public RepositorioDeEspeciesEnSQLite(Context context) {
        super(context, BD_ESPECIES, null, 1);
    }

    @Override
    public List<Especie> listar_especies() {
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLA_ESPECIES
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNA_NOMBRE + " TEXT UNIQUE);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLA_EJEMPLARES
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                + COLUMNA_ALTURA + " INTEGER, "
                + COLUMNA_IMAGEN + " TEXT UNIQUE, "
                + COLUMNA_ID + " FOREIGN KEY " +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
