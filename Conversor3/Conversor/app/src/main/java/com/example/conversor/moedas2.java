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

public class moedas2 extends AppCompatActivity {

    private String[] moedas = {"Escolha a Moeda", "$ USD", "£ Libras", "Real BRL", "Iene JPY"};
    private EditText invalor2;
    private Spinner spmoedas;
    private TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moedas2);

        invalor2 = findViewById(R.id.ctxmoeda);
        spmoedas = findViewById(R.id.spmoedas);
        result2 =  findViewById(R.id.result2);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,moedas);
        spmoedas.setAdapter(adapter);
        
        spmoedas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (invalor2 != null) {
                        double x = Double.parseDouble(invalor2.getText().toString());
                        DecimalFormat df = new DecimalFormat("0.00");
                        String selectedUnit = spmoedas.getSelectedItem().toString();

                        if ("$ USD".equals(selectedUnit))
                            result2.setText(df.format(x * 1.07) + " $");
                        else if ("£ Libras".equals(selectedUnit))
                            result2.setText(df.format(x * 0.87) + " £");
                        else if ("Real BRL".equals(selectedUnit))
                            result2.setText(df.format(x * 5.24) + " BRL");
                        else if ("Iene JPY".equals(selectedUnit))
                            result2.setText(df.format(x * 161.71) + " JPY");
                        else if ("Escolha a Medida".equals(selectedUnit))
                            result2.setText("Resultado");
                    }
                } catch (NumberFormatException e) {
                    Log.e("condist", "Erro ao converter valor para double: " + e.getMessage());                }
            }

                @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void voltar2(View v) {
        Intent it = new Intent(moedas2.this, MostraConversor.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed(){
        Intent it = new Intent(moedas2.this, MostraConversor.class);
        startActivity(it);
        finish();}
}