package edu.galileo.gltarea3listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre, txtFechaNacimiento;
    private RadioGroup rgTipo;
    private Button btnGrabar, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.et_nombre);
        txtFechaNacimiento= findViewById(R.id.et_fecha);
        rgTipo = findViewById(R.id.rg_tipo);
        btnGrabar = findViewById(R.id.btn_guardar);
        btnConsultar = findViewById(R.id.btn_consultar);

        btnGrabar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Mascotas temp;
        Intent intent;
        switch (v.getId()){

            case R.id.btn_consultar:
                Toast.makeText(this, "Click sobre consultar", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_guardar:
                temp = new Mascotas();
                temp.setNombre(txtNombre.getText().toString());
                temp.setFecha(txtFechaNacimiento.getText().toString());
                int tip=0;
                    switch (rgTipo.getCheckedRadioButtonId()){
                        case R.id.Perro:
                            tip = 1;
                        break;
                        case R.id.Gato:
                            tip = 2;
                        break;
                        case R.id.Ave:
                            tip = 3;
                        break;
                    }
                temp.setTipo(tip);
                txtNombre.setText("");
                txtFechaNacimiento.setText("");
                ((MascotasApp)getApplication()).insertaMascotas(temp);

                Toast.makeText(this, "Click sobre Guardar", Toast.LENGTH_SHORT).show();
             break;

        }

    }
}
