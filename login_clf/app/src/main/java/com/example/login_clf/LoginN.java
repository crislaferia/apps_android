package com.example.login_clf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginN extends AppCompatActivity {

    private EditText login, pass;

    private Button btnlogin;
    String user="",passwd="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_n);
        login = findViewById(R.id.ctx_login);
        pass = findViewById(R.id.ctx_pass);
        btnlogin = findViewById(R.id.btnlogin);

        user= login.getText().toString();
        passwd= pass.getText().toString();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaLogin();
            }
        });

    }
    public void validaLogin(){
        user= login.getText().toString();
        passwd= pass.getText().toString();
        new Thread(() -> {
            try {
                URL url = new URL("http://192.168.43.142/login_clf/validaUser.php?lo="+user+"&pass="+passwd+"");
                Log.d("xpto",url.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                JSONObject jsonObject = new JSONObject(Util.readString(bufferedReader));
                String user2 = jsonObject.getString("nome");
                Log.d("xpto",url.toString());
                this.runOnUiThread(() -> {
                    Toast.makeText(this, "Bem Vindo, " + user2 + "!", Toast.LENGTH_SHORT).show();

                });
                httpURLConnection.disconnect();
                Log.d("xpto",url.toString());
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
                this.runOnUiThread(() -> {
                    Log.d("xpto","antesdo eraddo");
                    Toast.makeText(this, "Login ou password errados!", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();

    }


    /*public void validaUser(View v){
        user= login.getText().toString();
        passwd= pass.getText().toString();
        new Thread(new Runnable() {
            public void run() {
                try {
                    URL url = new URL("127.0.0.1/login_clf/validaUser.php?login="+user+"&password="+passwd+"");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    String jsonString = stringBuilder.toString();
                    JSONObject jsonObject = new JSONObject(jsonString);
                    String user = jsonObject.getString("nome");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginN.this,"BEM VINDO "+user, Toast.LENGTH_LONG).show();
                        }
                    });
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/


    public void goToRegisto(View v){
        Intent it = new Intent(LoginN.this,registo.class);
        startActivity(it);
        this.finish();
    }
}


