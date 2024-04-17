package com.example.translateclf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class menuprinc extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        menu.removeItem(R.id.opanimais);
        menu.removeItem(R.id.opfrutas);
        menu.removeItem(R.id.opmarcas);
        return super.onCreateOptionsMenu(menu);
    }
    public void btnmarcas (View v){
        Intent app = new Intent(this, marcas.class);
        startActivity(app);
        finish();    }
    public void btnanimais (View v){
        Intent app = new Intent(this, animais.class);
        startActivity(app);
        finish();    }
    public void btnfrutas (View v){
        Intent app = new Intent(this, frutas.class);
        startActivity(app);
        finish();    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprinc);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opsair){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}
