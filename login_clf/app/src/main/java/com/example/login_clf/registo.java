package com.example.login_clf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class registo extends AppCompatActivity {

    private EditText nome, email, nif, telef, loginr, passr;
    private Button btnregistar;

    String nome2="",email2="",nif2="",telef2="",loginr2="",passr2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);
        nome= findViewById(R.id.ctxnome);
        email= findViewById(R.id.ctxemail);
        nif= findViewById(R.id.ctxnif);
        telef= findViewById(R.id.ctxtelef);
        loginr= findViewById(R.id.ctxloginR);
        passr= findViewById(R.id.ctxpassR);
        btnregistar =findViewById(R.id.btnregistar);

        nome2= nome.getText().toString();
        email2= email.getText().toString();
        nif2= nif.getText().toString();
        telef2= telef.getText().toString();
        loginr2= loginr.getText().toString();
        passr2= passr.getText().toString();

        btnregistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {validaRegisto();}
        });
    }

    public void validaRegisto(){

        new Thread(() -> {
            nome2= nome.getText().toString();
            email2= email.getText().toString();
            nif2= nif.getText().toString();
            telef2= telef.getText().toString();
            loginr2= loginr.getText().toString();
            passr2= passr.getText().toString();
            try {
                URL url = new URL("http://192.168.43.142/login_clf/registaUser.php?nome="+nome2+"&email="+email2+"&nif="+nif2+"&telef="+telef2+"&login="+loginr2+"&pass="+passr2+"");
             Log.d("xpto",url.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
               // InputStream inputStream = httpURLConnection.getInputStream();
               // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
               // JSONObject jsonObject = new JSONObject(Util.readString(bufferedReader));
               // String user = jsonObject.getString("nome");
                this.runOnUiThread(() -> {
                    Toast.makeText(this, "Registo com Sucesso, !", Toast.LENGTH_SHORT).show();
                });
                httpURLConnection.disconnect();
               // bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
                this.runOnUiThread(() -> {
                    Toast.makeText(this, "Algo deu errado!", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();

    }
}