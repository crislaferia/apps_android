package com.example.garrafeiraclf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showMessage();


            }
        },5000);
    }

    private void showMessage() {
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Verificação de Idade");
        msgbox.setIcon(android.R.drawable.ic_menu_info_details);
        msgbox.setMessage("Tem idade Legal para consumir bebidas alcoólicas?");
        msgbox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent it = new Intent(MainActivity.this, Tintos.class);
                startActivity(it);
                finish();
            }
        });
        msgbox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        msgbox.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vinhos,menu);
        menu.removeItem(R.id.brancos);
        menu.removeItem(R.id.espirituosos);
        menu.removeItem(R.id.tintos);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.sair){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}