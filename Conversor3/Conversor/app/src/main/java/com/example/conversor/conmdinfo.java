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

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class conmdinfo extends AppCompatActivity {

    private String[] mdinfor ={"Escolha a Medida", "Bits", "Bytes", "Kilobytes", "Gigabytes", "Terabytes"};

    private EditText invalor2;
    Spinner spinfor;
    private TextView result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conmdinfo);

        invalor2 = findViewById(R.id.invalor2);
        spinfor = findViewById(R.id.spinfor);
        result3 = findViewById(R.id.result3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,mdinfor);
        spinfor.setAdapter(adapter);

        spinfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    if (invalor2 != null) {
                        double x = Double.parseDouble(invalor2.getText().toString());
                        DecimalFormat df = new DecimalFormat("0");
                        String selectedUnit = spinfor.getSelectedItem().toString();

                        if ("Bits".equals(selectedUnit))
                            result3.setText(df.format(x * (1024*1024*8)) + " Bits");
                        else if ("Bytes".equals(selectedUnit))
                            result3.setText(df.format(x * (1024*1024)) + " Bytes");
                        else if ("Kilobytes".equals(selectedUnit))
                            result3.setText(df.format(x * 1024) + " Kb");
                        else if ("Gigabytes".equals(selectedUnit))
                            result3.setText(df.format(x / 1024) + " Gb");
                        else if ("Terabytes".equals(selectedUnit))
                            result3.setText(df.format(x / (1024*1024)) + " Tb");
                        else if ("Escolha a Medida".equals(selectedUnit))
                            result3.setText("Resultado");
                    }
                } catch (NumberFormatException e) {
                    Log.e("conmdinfo", "Erro ao converter valor para double: " + e.getMessage());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void voltar2(View v) {
        Intent it = new Intent(conmdinfo.this, MostraConversor.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed(){
        Intent it = new Intent(conmdinfo.this, MostraConversor.class);
        startActivity(it);
        finish();}
}