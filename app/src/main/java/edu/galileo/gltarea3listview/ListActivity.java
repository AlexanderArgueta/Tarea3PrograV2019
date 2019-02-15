package edu.galileo.gltarea3listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.listas_mascotas);
        lista.setAdapter(new MascotasAdapter(this, ((MascotasApp)getApplication()).getMascotas()));

    }
}
