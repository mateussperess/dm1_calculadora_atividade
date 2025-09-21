package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculadora2 extends AppCompatActivity {
    Button btnCalculadora1;
    private TextView txtResult2;
    String n1 = "";
    String n2 = "";
    String operacao = "";
    String expressao = "";
    String resultado = "";
    int flagNum= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtResult2 = findViewById(R.id.txtResult2);

    }
    public void clickBtnClear(View view) {
        txtResult2.setText("0,00");
        n1 = "";
        n2 = "";
        operacao = "";
        expressao = "";
    }

    public void clickNumbers(View view) {
        Button btn = (Button) view;

        if(flagNum == 1)
        {
            n1 += btn.getText().toString();
            expressao = n1;
            Log.d("NUMERO1", n1 + " clicado");
        }

        if(flagNum == 2)
        {
            n2 += btn.getText().toString();
            expressao = n1 + operacao + n2;
            Log.d("NUMERO2", n2 + " clicado");
        }

        txtResult2.setText(expressao);
    }

    public void clickBtnDot(View view) {
        if(flagNum == 1) {
            if (!n1.contains(".")) {
                if(n1 == "") {
                    n1 = "0.";
                } else {
                    n1 += ".";
                }
            }
        } else if (flagNum == 2) {
            if(!n2.contains(".")) {
                if(n2.equals("")) {
                    n2 = "0.";
                } else {
                    n2 += ".";
                }
                expressao = n1 + operacao + n2;
            }
        }

        txtResult2.setText(expressao);
    }

    public void clickBtnDel(View view) {
        if (flagNum == 1) {
            if (!n1.isEmpty()) {
                n1 = n1.substring(0, n1.length() - 1);
            }
            expressao = n1;

        } else if (flagNum == 2) {
            if (!n2.isEmpty()) {
                n2 = n2.substring(0, n2.length() - 1);

            } else if (!operacao.isEmpty()) {
                operacao = "";
                flagNum = 1;
            }

            expressao = n1 + operacao + n2;
        }

        if (expressao.isEmpty()) {
            expressao = "0";
        }

        txtResult2.setText(expressao);
    }

    public void clickBtnOp2(View view) {
        Button btn = (Button) view;

        switch (btn.getText().toString()) {
            case "+":
                Log.d("OPERACAO SELECIONADA", "OPERACAO SOMA CLICADA");
                operacao = "+";
                flagNum = 2;
                break;
            case "-":
                Log.d("OPERACAO SELECIONADA", "OPERACAO SUBTRACAO CLICADA");
                operacao = "-";
                flagNum = 2;
                break;
            case "*":
                Log.d("OPERACAO SELECIONADA", "OPERACAO MULTIPLICACAO CLICADA");
                operacao = "*";
                flagNum = 2;
                break;
            case "/":
                Log.d("OPERACAO SELECIONADA", "OPERACAO DIVISAO CLICADA");
                operacao = "/";
                flagNum = 2;
                break;
        }

        expressao = n1 + operacao;
        txtResult2.setText(expressao);
    }

    public void clickBtnEquals2(View view) {
        if (n1.isEmpty() || n2.isEmpty() || operacao.isEmpty()) {
            txtResult2.setText("0,00");
            return;
        }

        float numero1 = Float.parseFloat(n1);
        float numero2 = Float.parseFloat(n2);
        float result = 0;

        switch (operacao) {
            case "+":
                result = Calcular.somar(numero1, numero2);
                break;
            case "-":
                result = Calcular.subtrair(numero1, numero2);
                break;
            case "*":
                result = Calcular.multiplicar(numero1, numero2);
                break;
            case "/":
                if (numero2 == 0) {
                    txtResult2.setText("Divisão por 0");
                    return;
                }
                result = Calcular.dividir(numero1, numero2);
                break;
        }

        txtResult2.setText(String.valueOf(result));
        n1 = String.valueOf(result);
        n2 = "";
        flagNum = 1;
    }
}