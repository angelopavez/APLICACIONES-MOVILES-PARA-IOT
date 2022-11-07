package com.example.prueba2amiot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2amiot.modelo.Libro;
import com.example.prueba2amiot.modelo.Funcion;

public class MostradorActivity extends AppCompatActivity {

    public Libro libro;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrador);

        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idLibro");
        libro= Funcion.getInstancia().getLibro(id);

        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(libro.getNombre());

        TextView txtAutor=(TextView) findViewById(R.id.txtAutor);
        txtAutor.setText("autor"+libro.getAutor()+" "+libro.getCondicion());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);
        if(libro.isEstado()==libro.VENDIDO)
        {
            txtEstado.setText("Estado: VENDIDO");
            estado.setText("Marcar como PENDIENTE");
        }
        else
        {
            txtEstado.setText("Estado: PENDIENTE");
            estado.setText("Marcar como Comprado");
        }
        estado.setOnClick.Listener(new view.OnClickListener() {
            @Override
            public void onClick(View view){
                libro.setEstado(!libro.isEstado());
                setResult(RESULT_OK, intent);
                finish();
            }
                                   }
        );
    }
}
