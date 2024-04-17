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

public class conpesos extends AppCompatActivity {

    private String[] pesos ={"Escolha a Medida", "Quilogramas", "Toneladas", "Libras", "Quilates", "Arrobas"};

    private EditText invalor3;
    Spinner sppesos;
    private TextView result4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conpesos);

        invalor3 = findViewById(R.id.invalor3);
        sppesos = findViewById(R.id.sppesos);
        result4 = findViewById(R.id.result4);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pesos);
        sppesos.setAdapter(adapter);

        sppesos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (invalor3 != null) {
                        double x = Double.parseDouble(invalor3.getText().toString());
                        DecimalFormat df = new DecimalFormat("0.00");
                        String selectedUnit = sppesos.getSelectedItem().toString();

                        if ("Quilogramas".equals(selectedUnit))
                            result4.setText(df.format(x * 0.0010) + " Kg");
                        else if ("Toneladas".equals(selectedUnit))
                            result4.setText(df.format(x * 0.0000010) + " Ton");
                        else if ("Libras".equals(selectedUnit))
                            result4.setText(df.format(x * 0.0022) + " Libras");
                        else if ("Quilates".equals(selectedUnit))
                            result4.setText(df.format(x * 5) + " Quilates");
                        else if ("Arrobas".equals(selectedUnit))
                            result4.setText(df.format(x / 14688) + " Arrobas");
                        else if ("Escolha a Medida".equals(selectedUnit))
                            result4.setText("Resultado");
                    }
                } catch (NumberFormatException e) {
                    Log.e("conpesos", "Erro ao converter valor para double: " + e.getMessage());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void voltar2(View v) {
        Intent it = new Intent(conpesos.this, MostraConversor.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed(){
        Intent it = new Intent(conpesos.this, MostraConversor.class);
        startActivity(it);
        finish();}
}