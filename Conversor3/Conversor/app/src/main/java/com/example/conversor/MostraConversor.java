package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MostraConversor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_conversor);

    }

    public void distancias(View v){
        Intent it = new Intent(MostraConversor.this, condist.class);
        startActivity(it);
        finish();
    }
    public void moedas(View v){
        Intent it2 = new Intent(MostraConversor.this, moedas2.class);
        startActivity(it2);
        finish();
    }
    public void pesos(View v){
        Intent it = new Intent(MostraConversor.this, conpesos.class);
        startActivity(it);
        finish();
    }
    public void mdinfo(View v){
        Intent it = new Intent(MostraConversor.this, conmdinfo.class);
        startActivity(it);
        finish();
    }
    public void temp(View v){
        Intent it = new Intent(MostraConversor.this, temp.class);
        startActivity(it);
        finish();
    }
    public void sair(View v){
        finish();}

    public void onBackPressed(){
        finish();
    }
}