package com.example.simplex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplex.Classes.Expressao;
import com.example.simplex.Classes.Problema;
import com.example.simplex.Classes.Simplex;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    double lista[];
    Button btnResult;
    String result ="vazioooo";
    private RadioGroup radioGroup;
    Simplex simplex = new Simplex();
    RadioButton check1, check2, check3, check4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1 = (RadioButton)findViewById(R.id.check1);
        check2   = (RadioButton)findViewById(R.id.check2);
        check3   = (RadioButton)findViewById(R.id.check3);
        check4   = (RadioButton)findViewById(R.id.check4);

        btnResult = (Button)findViewById(R.id.btnSolucao);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.check1) {

                    Problema problema = new Problema();
                    problema.setObjetivo("max");
                    problema.setFuncao(new Expressao(2, 4, 5, 3));

                    problema.addRestricao(new Expressao("<=", 40, 0.3, 0.3, 0.5, 0.4));
                    problema.addRestricao(new Expressao("<=", 40, 0.4, 0.3,0.2, 0.4));
                    problema.addRestricao(new Expressao("<=", 60, 0.3, 0.4, 0.3, 0.2));
                    simplex.setProblema(problema);
                    simplex.calcula();
                }
                else if(i == R.id.check2) {

                    Problema problema = new Problema();
                    problema.setObjetivo("max");
                    problema.setFuncao(new Expressao(1, 2, 3, 4));
                    problema.addRestricao(new Expressao("<=", 10, 0, 2, 3, 0));
                    problema.addRestricao(new Expressao("<=", 20.4, 1, 0, 0, 4));
                    simplex.setProblema(problema);
                    simplex.calcula();
                    Toast.makeText(MainActivity.this,"entrou no 2 "+ simplex.getResultado()  , Toast.LENGTH_LONG).show();
                }
                else if(i == R.id.check3) {

                    Problema problema = new Problema();
                    problema.setObjetivo("max");
                    problema.setFuncao(new Expressao(1, 1.2, 1.5));
                    problema.addRestricao(new Expressao("<=", 10, 4, 1, 0.8));
                    problema.addRestricao(new Expressao("<=", 9.5, 0.9, 1, 5));
                    problema.addRestricao(new Expressao("<=", 11, 1.2, 3, 1.5));
                    simplex.setProblema(problema);
                    simplex.calcula();
                }
                else if(i == R.id.check4) {

                    Problema problema = new Problema();
                    problema.setObjetivo("max");
                    problema.setFuncao(new Expressao(1, 1));
                    problema.addRestricao(new Expressao("<=", 20, 5, 2));
                    problema.addRestricao(new Expressao(">=", 2, 2, -1));
                    problema.addRestricao(new Expressao(">=", 15, 3, 5));
                    simplex.setProblema(problema);
                    simplex.calcula();
                }

            }
        });





        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity.this, Resultado.class);
                i.putExtra("resultado", simplex.getResultado());
                startActivity(i);
            }
        });
    }
}
