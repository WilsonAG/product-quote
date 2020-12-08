package com.will.productquote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.will.productquote.model.Product;

import java.util.ArrayList;
import java.util.List;

public class QuoterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView total;
    private EditText quantity;
    private Product productSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quoter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.quantity = findViewById(R.id.et_cant);
        this.total = findViewById(R.id.tv_total);

        Spinner prodList = findViewById(R.id.sp_prods);

        ArrayList<Product> myProds = Product.getData();
        List<String> prodnames = new ArrayList<String>();

        for (Product p :
                myProds) {
            prodnames.add(p.getDescription());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prodnames);;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prodList.setAdapter(adapter);

        prodList.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selected = parent.getItemAtPosition(position).toString();
        ArrayList<Product> data = Product.getData();

        for (Product p :
                data) {
            if (selected.equals(p.getDescription())) {
                this.productSelected = p;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}