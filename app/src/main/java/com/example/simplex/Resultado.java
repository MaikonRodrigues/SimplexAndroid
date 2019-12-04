package com.example.simplex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends AppCompatActivity {
    TextView resultadoTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultadoTxt = (TextView)findViewById(R.id.idLabel);
        String resultado;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                resultado= null;
              //  Toast.makeText(Resultado.this,"Veio nulo", Toast.LENGTH_LONG).show();
            } else {
                resultado= extras.getString("resultado");
                //Toast.makeText(Resultado.this,"Veio "+resultado, Toast.LENGTH_LONG).show();
            }
        } else {
            resultado= (String) savedInstanceState.getSerializable("resultado");
        }
        resultadoTxt.setText(resultado);

    }
}
