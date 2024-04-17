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

public class marcas extends AppCompatActivity {

    private String [] pt_marcas = new String[]{"Mitsubishi","Carrefour","Leroy Merlin","Herbal"};
    private String [] en_marcas = new String[]{"Mitsubishi","Carrefour","Leroy Merlin","Herbal"};
    private int[] img_marcas = {R.drawable.marca1,R.drawable.marca2,R.drawable.marca3,R.drawable.marca4};

    private MediaPlayer mp;

    private String[] sons_marcas = new String[]{"mitsubishi","carrefour","leroymerlin","herbalessences"};

    private Spinner sp;
    private TextView trad;
    private ImageView img;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        menu.removeItem(R.id.opmarcas);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);
        sp = findViewById(R.id.sp_marcas);
        trad = findViewById(R.id.trad_marca);
        img = findViewById(R.id.img_marcas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pt_marcas);
        sp.setAdapter(adapter);



        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img.setImageResource(img_marcas[i]);
                trad.setText(en_marcas[i]);
                String nome = (String)sp.getSelectedItem();
                String pkg = getPackageName();
                l = getResources().getIdentifier(sons_marcas[i],"raw",pkg);
                mp= MediaPlayer.create(marcas.this,(int)l);
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


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        try {
            if (id == R.id.opsair)
                finish();
            else if (id == R.id.opanimais) {
                Intent ap = new Intent(marcas.this, animais.class);
                startActivity(ap);
                finish();
            } else if (id == R.id.opfrutas) {
                Intent ap = new Intent(marcas.this, frutas.class);
                startActivity(ap);
                finish();

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        Intent ap= new Intent(marcas.this, menuprinc.class);
        startActivity(ap);
        finish();
        super.onBackPressed();
    }


}