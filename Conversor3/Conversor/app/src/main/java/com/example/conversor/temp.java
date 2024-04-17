package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class temp extends AppCompatActivity {

    private String[] temperatura = {"Escolha a Temperatura", "Celsius ºC", "Fahrenheit ºF", "Kelvin K"};

    private EditText valort;
    Spinner sporigem;
    Spinner spdestino;
    private TextView result6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        valort = findViewById(R.id.valort);
        sporigem = findViewById(R.id.sporigem);
        spdestino = findViewById(R.id.spdestino);
        result6 = findViewById(R.id.result6);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, temperatura);
        sporigem.setAdapter(adapter);
        spdestino.setAdapter(adapter);

        valort.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                realizarConversao();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void afterTextChanged(Editable editable) {            }
        });

        sporigem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                realizarConversao();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spdestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                realizarConversao();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void realizarConversao() {
        try {
            if (valort != null) {
                double x = Double.parseDouble(valort.getText().toString());
                DecimalFormat df = new DecimalFormat("0.00");
                String unidadeOrigem = sporigem.getSelectedItem().toString();
                String unidadeDestino = spdestino.getSelectedItem().toString();

                if ("Celsius ºC".equals(unidadeOrigem)) {
                    if ("Fahrenheit ºF".equals(unidadeDestino)) {
                        double resultado = celsiusParaFahrenheit(x);
                        result6.setText(df.format(resultado) + " ºF");
                    } else if ("Kelvin K".equals(unidadeDestino)) {
                        double resultado = celsiusParaKelvin(x);
                        result6.setText(df.format(resultado) + " K");
                    } else {
                        result6.setText(df.format(x) + " ºC");
                    }
                } else if ("Fahrenheit ºF".equals(unidadeOrigem)) {
                    if ("Celsius ºC".equals(unidadeDestino)) {
                        double resultado = fahrenheitParaCelsius(x);
                        result6.setText(df.format(resultado) + " ºC");
                    } else if ("Kelvin K".equals(unidadeDestino)) {
                        double resultado = fahrenheitParaKelvin(x);
                        result6.setText(df.format(resultado) + " K");
                    } else {
                        result6.setText(df.format(x) + " ºF");
                    }
                } else if ("Kelvin K".equals(unidadeOrigem)) {
                    if ("Celsius ºC".equals(unidadeDestino)) {
                        double resultado = kelvinParaCelsius(x);
                        result6.setText(df.format(resultado) + " ºC");
                    } else if ("Fahrenheit ºF".equals(unidadeDestino)) {
                        double resultado = kelvinParaFahrenheit(x);
                        result6.setText(df.format(resultado) + " ºF");
                    } else {
                        result6.setText(df.format(x) + " K");
                    }
                } else {
                    result6.setText("Por favor, escolha uma unidade de temperatura válida.");
                }
            }
        } catch (NumberFormatException e) {
            result6.setText("Erro ao converter valor para double");
        }
    }

    private double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double celsiusParaKelvin(double celsius) {
        return celsius + 273.15;
    }

    private double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double fahrenheitParaKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    private double kelvinParaCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private double kelvinParaFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }

    public void voltar3(View v) {
        Intent it = new Intent(temp.this, MostraConversor.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed(){
        Intent it = new Intent(temp.this, MostraConversor.class);
        startActivity(it);
        finish();}
}
