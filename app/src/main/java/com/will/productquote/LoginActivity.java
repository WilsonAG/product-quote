package com.will.productquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private final String authEmail = "vendedor@emproy.com";
    private final String authPassword = "Vendedor20203mproy";

    private EditText name;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.name = findViewById(R.id.et_name);
        this.email = findViewById(R.id.et_email);
        this.password = findViewById(R.id.et_password);

        Button submit = findViewById(R.id.btn_login);
        submit.setOnClickListener(this::login);

        this.name.setText("Will");
        this.email.setText(this.authEmail);
        this.password.setText(this.authPassword);
    }

    private void login(View v) {
        if (!this.validate()){
            return;
        }
        if (this.email.getText().toString().equals(this.authEmail) && this.password.getText().toString().equals(this.authPassword)){
            // TODO Redirect to main
            Intent menu = new Intent(this, MenuActivity.class);
            menu.putExtra("name", this.name.getText().toString());
            startActivity(menu);
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        String nameTxt = this.name.getText().toString();
        String emailTxt = this.email.getText().toString();
        String passwordTxr = this.password.getText().toString();

        if (nameTxt.isEmpty() || emailTxt.isEmpty() | passwordTxr.isEmpty()){
            Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!emailTxt.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            this.email.setError("Email no valido");
            return false;
        }

        return true;
    }
}