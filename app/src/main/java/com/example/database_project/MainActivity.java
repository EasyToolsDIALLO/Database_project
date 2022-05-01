package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.database_project.database.DataBaseOpenHelper;

public class MainActivity extends AppCompatActivity {
    EditText nom,prix;
    Button btn;
    DataBaseOpenHelper database = new DataBaseOpenHelper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.edtNom);
        prix = findViewById(R.id.edtPrix);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            Produit p = new Produit(nom.getText().toString(),prix.getText().toString());
            database.insertProduct(p);
            Intent intent = new Intent(MainActivity.this,ListeProduit.class);
            startActivity(intent);
        });
    }
}