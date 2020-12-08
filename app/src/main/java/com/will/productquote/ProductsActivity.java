package com.will.productquote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.will.productquote.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView code;
    private TextView desc;
    private TextView brand;
    private TextView stock;
    private TextView unitPrice;
    private TextView dozenPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        this.code = findViewById(R.id.tv_prod_code);
        this.desc = findViewById(R.id.tv_prod_desc);
        this.brand = findViewById(R.id.tv_prod_brand);
        this.stock = findViewById(R.id.tv_prod_stock);
        this.unitPrice = findViewById(R.id.tv_prod_unit_price);
        this.dozenPrice = findViewById(R.id.tv_prod_dozen_price);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner products = findViewById(R.id.prod_selector);

        ArrayList<Product> myProds = Product.getData();
        List<String> prodnames = new ArrayList<String>();

        for (Product p :
                myProds) {
            prodnames.add(p.getDescription());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prodnames);;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        products.setAdapter(adapter);

        products.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
        ArrayList<Product> data = Product.getData();

        for (Product p :
                data) {
            if (selected.equals(p.getDescription())) {
                this.desc.setText("DESCRIPCION: " +p.getDescription());
                this.code.setText("CODIGO: " +String.valueOf(p.getCode()));
                this.brand.setText("MARCA: " +p.getBrand());
                this.stock.setText("STOCK: " +String.valueOf(p.getStock()));
                this.unitPrice.setText("PRECIO UNITARIO: " +String.valueOf(p.getUnitPrice()));
                this.dozenPrice.setText("PRECIO DOCENA: " +String.valueOf(p.getDozenPrice()));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}