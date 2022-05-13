package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText t_login,t_password;
   Button btn_connexion;
    String c_pass = "123456";
    String login_s = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_login = findViewById(R.id.t_login);
        t_password = findViewById(R.id.t_password);
        btn_connexion = findViewById(R.id.btn_connexion);

        btn_connexion.setOnClickListener(view -> {
            login_s = t_login.getText().toString();

            if (t_password.getText().toString().equals(c_pass)) {
                if (TextUtils.isEmpty(t_login.getText())){
                    Toast.makeText(MainActivity.this, "Saisir un Login !", Toast.LENGTH_LONG).show();
            } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra(String.valueOf(MainActivity2.login_a), login_s);
                    startActivity(i);
            }}
            else {
                Toast.makeText(MainActivity.this, "Identifiants incorrectes !", Toast.LENGTH_LONG).show();
            }
        });
    }}