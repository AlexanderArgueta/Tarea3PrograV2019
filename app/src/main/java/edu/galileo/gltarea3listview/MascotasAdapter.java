package edu.galileo.gltarea3listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MascotasAdapter extends ArrayAdapter<Mascotas>{

    private List<Mascotas> lista;
    private Context context;
    private int layout;

    public MascotasAdapter(@NonNull Context context, @NonNull List<Mascotas> objects) {
        super(context, R.layout.item_list_mascotas_layout, objects);
        this.lista = objects;
        this.context = context;
        this.layout = R.layout.item_list_mascotas_layout;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_list_mascotas_layout, null);
        }
        if (lista.get(position) != null) {
            ImageView lytImagen;
            TextView txNombre, txEdad;
            lytImagen = v.findViewById(R.id.lyt_imagen);
            txNombre = v.findViewById(R.id.tx_nombre);
            txEdad = v.findViewById(R.id.tx_edad);
            txNombre.setText(lista.get(position).getNombre());
            txEdad.setText(lista.get(position).getFecha());
            if (lista.get(position).getTipo() == 1)
            {
                lytImagen.setImageResource(R.drawable.dog);

            } else if (lista.get(position).getTipo() == 2)
            {
                lytImagen.setImageResource(R.drawable.cat);
            } else
            {
                lytImagen.setImageResource(R.drawable.bird);
            }
        }
        return v;
    }
}
