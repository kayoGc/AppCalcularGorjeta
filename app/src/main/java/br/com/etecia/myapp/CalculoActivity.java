package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.EventListener;

public class CalculoActivity extends AppCompatActivity {

    TextInputEditText txtValor;
    TextInputEditText txtValorTotal;
    TextInputEditText txtValorGorjeta;
    Spinner spinner;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        btnCalcular = findViewById(R.id.btnCalcular);
        spinner = findViewById(R.id.spinner);
        txtValor = findViewById(R.id.txtValor);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        txtValorGorjeta = findViewById(R.id.txtValorGorjeta);

        txtValorTotal.setEnabled(false);
        txtValorGorjeta.setEnabled(false);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gorjeta gorjeta = new Gorjeta();
                gorjeta.valor = Integer.parseInt(txtValor.getText().toString());

                switch (spinner.getSelectedItem().toString()) {
                    case "Excelente":
                        gorjeta.qualidade = 10;
                        break;
                    case "Ótimo":
                        gorjeta.qualidade = 8;
                        break;
                    case "Bom":
                        gorjeta.qualidade = 5;
                        break;
                    case "Ruim":
                        gorjeta.qualidade = 2;
                        break;
                    default:
                        break;
                }

                gorjeta.calcularGorjeta();

                txtValorTotal.setText(gorjeta.getValorTotal() + "");
                txtValorGorjeta.setText(gorjeta.getGorjeta() + "");
            }
        });
    }



}