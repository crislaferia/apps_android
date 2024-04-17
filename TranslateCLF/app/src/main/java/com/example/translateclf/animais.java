package com.example.translateclf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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

public class animais extends AppCompatActivity {


    private String [] pt_animais = new String[]{"Raposa","Urso","Elefante","Veado"};
    private String [] en_animais = new String[]{"Fox","Bear","Elephant","Deer"};
    private int[] img_animais = {R.drawable.animal1,R.drawable.animal2,R.drawable.animal3,R.drawable.animal4};
    private MediaPlayer mp;
    private String[] sons_animais = new String[]{"fox","bear","elephant","deer"};

    private Spinner sp;
    private TextView trad;
    private ImageView img;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        menu.removeItem(R.id.opanimais);

        return super.onCreateOptionsMenu(menu);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);

        sp = findViewById(R.id.sp_animais);
        trad = findViewById(R.id.trad_animal);
        img = findViewById(R.id.img_animal);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pt_animais);
        sp.setAdapter(adapter);
        
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img.setImageResource(img_animais[i]);
                trad.setText(en_animais[i]);
                String nome = (String)sp.getSelectedItem();
                String pkg = getPackageName();
                l = getResources().getIdentifier(sons_animais[i],"raw",pkg);
                mp= MediaPlayer.create(animais.this,(int)l);
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
        int id = item.getItemId();
        try {
            if (id==R.id.opsair)
                finish();
            else if (id== R.id.opmarcas) {
                Intent ap = new Intent( animais.this, marcas.class);
                startActivity(ap);
                finish();
            } else if (id==R.id.opfrutas) {
                Intent ap = new Intent(animais.this, frutas.class);
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
        Intent ap = new Intent(animais.this, menuprinc.class);
        startActivity(ap);
        finish();
        super.onBackPressed();
    }
}