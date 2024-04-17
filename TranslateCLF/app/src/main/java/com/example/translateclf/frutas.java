package com.example.translateclf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class frutas extends AppCompatActivity {


    private String [] pt_frutas  = new String[]{"Papaia","Morangos","Abacaxi","Mirtilos"};
    private String [] en_frutas = new String[]{"Papaya","Strawberries","Pineapple","Blueberries"};
    private int[] img_frutas = {R.drawable.fruta1,R.drawable.fruta2,R.drawable.fruta3,R.drawable.fruta4};
    private MediaPlayer mp;
    private String[] sons_frutas = new String[]{"papaya","strawberries","pineapple","blueberries"};

    private Spinner sp;
    private TextView trad;
    private ImageView img;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        menu.removeItem(R.id.opfrutas);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);
        sp = findViewById(R.id.sp_frutas);
        trad = findViewById(R.id.trad_frutas);
        img = findViewById(R.id.img_frutas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pt_frutas);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img.setImageResource(img_frutas[i]);
                trad.setText(en_frutas[i]);
                String nome = (String)sp.getSelectedItem();
                String pkg = getPackageName();
                l = getResources().getIdentifier(sons_frutas[i],"raw",pkg);
                mp= MediaPlayer.create(frutas.this,(int)l);
                showInfo(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void showInfo(View view) {
    }
    public void play(View V){
        mp.start();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        try{
            if (id== R.id.opsair)
                finish();
            else if (id == R.id.opanimais) {
                Intent ap = new Intent(frutas.this, animais.class);
                startActivity(ap);
                finish();
            } else if (id==R.id.opmarcas) {
                Intent ap = new Intent(frutas.this, marcas.class);
                startActivity(ap);
                finish();
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent ap = new Intent(frutas.this, menuprinc.class);
        startActivity(ap);
        finish();
        super.onBackPressed();
    }
}