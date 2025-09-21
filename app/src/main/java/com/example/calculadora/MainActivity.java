package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private EditText etNumber1;
    private EditText etNumber2;
    private Button btnSoma;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;
    private Button btnResult;
    private int operacao;
    private double result;
    private Button btnCalculadora2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtResult = findViewById(R.id.txtResult);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);

        etNumber1.setOnClickListener(v -> { etNumber1.getText().clear(); });
        etNumber2.setOnClickListener(v -> { etNumber2.getText().clear(); });

        btnSoma = findViewById(R.id.btnSoma);
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = 1;
                Toast.makeText(MainActivity.this, "Operação SOMA selecionada", Toast.LENGTH_SHORT).show();
                try {

                    double numero1 = Double.parseDouble(etNumber1.getText().toString());
                    double numero2 = Double.parseDouble(etNumber2.getText().toString());

                    result = calcularOperacao(operacao, numero1, numero2);
                    Log.d("TESTE", "Resultado: " + result);
                } catch (Exception e) {
                    Log.d("TESTE", "Erro: " + e.getMessage());
                }
            }
        });

        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = 2;
                Toast.makeText(MainActivity.this, "Operação SUBTRAÇÃO selecionada", Toast.LENGTH_SHORT).show();

                try {
                    Double numero1 = Double.parseDouble(etNumber1.getText().toString());
                    Double numero2 = Double.parseDouble(etNumber2.getText().toString());

                    result = calcularOperacao(operacao, numero1, numero2);
                } catch (Exception e) {
                    Log.d("TESTE", "Erro: " + e.getMessage());
                }
            }
        });

        btnMult = findViewById(R.id.btnMult);
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = 3;
                Toast.makeText(MainActivity.this, "Operação MULTIPLICAÇÃO selecionada", Toast.LENGTH_SHORT).show();

                try {
                    Double numero1 = Double.parseDouble(etNumber1.getText().toString());
                    Double numero2 = Double.parseDouble(etNumber2.getText().toString());

                    result = calcularOperacao(operacao, numero1, numero2);
                } catch (Exception e) {
                    Log.d("TESTE", "Erro: " + e.getMessage());
                }
            }
        });

        btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = 4;
                Toast.makeText(MainActivity.this, "Operação DIVISÃO selecionada", Toast.LENGTH_SHORT).show();

                try {
                    Double numero2 = Double.parseDouble(etNumber2.getText().toString());
                    Double numero1 = Double.parseDouble(etNumber1.getText().toString());

                    result = calcularOperacao(operacao, numero1, numero2);
                } catch (Exception e) {
                    Log.d("TESTE", "Erro: " + e.getMessage());
                }
            }
        });

        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(String.valueOf(result));
            }
        });

        btnCalculadora2 = findViewById(R.id.btnCalculadora2);
        btnCalculadora2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCalculadora2 = new Intent(MainActivity.this, Calculadora2.class);
                startActivity(itCalculadora2);
            }
        });
    }

    public double calcularOperacao(int operacao, double numero1, double numero2)
    {
        double resultado = 0;
        switch (operacao) {
            case 1:
                Log.d("OP" , "Realizando SOMA");
                resultado = Calcular.somar(numero1, numero2);
                break;
            case 2:
                Log.d("OP" , "Realizando SUBTRAÇÃO");
                resultado = Calcular.subtrair(numero1, numero2);
                break;
            case 3:
                Log.d("OP" , "Realizando MULTIPLICAÇÃO");
                resultado = Calcular.multiplicar(numero1, numero2);
                break;
            case 4:
                Log.d("OP" , "Realizando DIVISÃO");
                resultado = Calcular.dividir(numero1, numero2);
                break;
        }

        return resultado;
    }
}