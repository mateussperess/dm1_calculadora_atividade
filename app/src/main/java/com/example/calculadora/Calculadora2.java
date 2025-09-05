package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
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
    private Button btnCalculadora1;
    private TextView txtResult2;
    private Button btnClear;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnDot;
    private Button btnDel;
    private Button btnEquals2;
    private Button btnAdd2;
    private Button btnMinus2;
    private Button btnDiv2;

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

        btnCalculadora1 = findViewById(R.id.btnCalculadora1);
        btnCalculadora1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itCalculadora1 = new Intent(Calculadora2.this, MainActivity.class);
                startActivity(itCalculadora1);
            }
        });
    }
}