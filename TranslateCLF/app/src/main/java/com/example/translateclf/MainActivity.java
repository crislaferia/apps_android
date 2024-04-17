package com.example.translateclf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },5000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        menu.removeItem(R.id.opanimais);
        menu.removeItem(R.id.opfrutas);
        menu.removeItem(R.id.opmarcas);
        return super.onCreateOptionsMenu(menu);
    }

    public void entrar (View v){
        Intent app = new Intent(this, menuprinc.class);
        startActivity(app);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opsair){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}