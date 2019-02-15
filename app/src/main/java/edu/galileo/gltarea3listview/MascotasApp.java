package edu.galileo.gltarea3listview;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MascotasApp extends Application {
    private List<Mascotas> listmascotas;


    @Override
    public void onCreate() {
        super.onCreate();
        listmascotas = new ArrayList<Mascotas>();
    }

    public void insertaMascotas (Mascotas mascotas){
        listmascotas.add(mascotas);
    }

    public List<Mascotas> getMascotas(){
        return listmascotas;

    }
}
