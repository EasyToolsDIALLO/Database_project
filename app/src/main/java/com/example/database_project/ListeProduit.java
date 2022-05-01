package com.example.database_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.database_project.database.DataBaseOpenHelper;

public class ListeProduit extends AppCompatActivity {
    ListView list;
    DataBaseOpenHelper database = new DataBaseOpenHelper(ListeProduit.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produit);
        list = findViewById(R.id.list_item);
        Cursor c = database.getAllProduct();
        SimpleCursorAdapter sca = new SimpleCursorAdapter(ListeProduit.this,R.layout.item_produit,c,
                new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2),
                },new int[]{R.id.id,R.id.nom, R.id.prix},1);

        list.setAdapter(sca);
    }
}