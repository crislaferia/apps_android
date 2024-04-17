package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class condist extends AppCompatActivity {

    private String[] distancias = {"Escolha a Medida", "km", "Milhas", "Pés", "Polegadas", "Jardas"};
    private EditText invalor1;
    Spinner spdist;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condist);

        // criacao de instancias
        Log.d("key", "ola1");
        invalor1 = findViewById(R.id.ctxvalor);
        spdist = findViewById(R.id.spdist);
        result = findViewById((R.id.result));

        // criar arrays para o spinner
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, distancias);
        spdist.setAdapter(adapter);

        spdist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (invalor1 != null) {
                        double x = Double.parseDouble(invalor1.getText().toString());
                        DecimalFormat df = new DecimalFormat("0.000");
                        String selectedUnit = spdist.getSelectedItem().toString();

                        if ("km".equals(selectedUnit))
                            result.setText(df.format(x / 1000) + " km");
                        else if ("Milhas".equals(selectedUnit))
                            result.setText(df.format(x / 1609.344) + " Milhas");
                        else if ("Pés".equals(selectedUnit))
                            result.setText(df.format(x / 0.3048) + " Pés");
                        else if ("Polegadas".equals(selectedUnit))
                            result.setText(df.format(x / 0.0254) + " Polegadas");
                        else if ("Jardas".equals(selectedUnit))
                            result.setText(df.format(x / 0.9144) + " Jardas");
                        else if ("Escolha a Medida".equals(selectedUnit))
                            result.setText("Resultado");
                    }
                } catch (NumberFormatException e) {
                    Log.e("condist", "Erro ao converter valor para double: " + e.getMessage());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("key", "ola");
            }
        });
    }

    public void voltar(View v) {
        Intent it = new Intent(condist.this, MostraConversor.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed(){
        Intent it = new Intent(condist.this, MostraConversor.class);
        startActivity(it);
        finish();}
}
