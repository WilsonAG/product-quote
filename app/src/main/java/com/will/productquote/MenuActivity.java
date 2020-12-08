package com.will.productquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.showWelcome();

        Button quoter = findViewById(R.id.btn_quoter);
        Button products = findViewById(R.id.btn_products);
        Button stop = findViewById(R.id.btn_stop_app);

        quoter.setOnClickListener(this::goToQuoter);
        products.setOnClickListener(this::goToProducts);
        stop.setOnClickListener(this::finishApp);
    }

    private void showWelcome() {
        TextView message = findViewById(R.id.tv_welcome);
        String user = getIntent().getStringExtra("name");
        message.setText(new StringBuilder().append("Bienvenido ").append(user));
    }

    private void goToQuoter(View v) {
        Intent quoter = new Intent(this, QuoterActivity.class);
        startActivity(quoter);
    }

    private void goToProducts(View v){
        Intent procuts = new Intent(this, ProductsActivity.class);
        startActivity(procuts);
    }

    private void finishApp(View v) {
        this.finishAffinity();
    }
}