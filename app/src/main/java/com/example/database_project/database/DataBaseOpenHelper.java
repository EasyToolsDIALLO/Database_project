package com.example.database_project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.database_project.Produit;

public class DataBaseOpenHelper extends SQLiteOpenHelper {


    public DataBaseOpenHelper(@Nullable Context context) {
        super(context, "factureDATABASE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String create_save = "";
        database.execSQL("CREATE TABLE enregistree(_id INTEGER PRIMARY KEY ," +
                "nom TEXT,prix TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS enregistree");
        onCreate(database);

    }

    public void insertProduct(Produit p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("prix",p.getPrix());

        db.insert("enregistree",null,cv);
        db.close();

    }

    public  void updateFacture(Produit p){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("prix",p.getPrix());
        db.update("enregistree",cv,"_id=?",new String[]{String.valueOf(p.getId())});
        db.close();
    }

    public  void supprimerFacture(int id){
        SQLiteDatabase db= this.getWritableDatabase();

        db.delete("enregistree","_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getAllProduct(){
        SQLiteDatabase bd= this.getReadableDatabase();

        Cursor c = bd.rawQuery("SELECT * FROM enregistree", null);
        return c;
    }

    public Produit getOneProduct(int id){
        SQLiteDatabase bd= this.getReadableDatabase();

        Cursor c = bd.query("enregistree",new String[]{"_id","nom","prix"},"_id=?",
                new String[]{String.valueOf(id)},null,null,null);

        c.moveToFirst();
        Produit p = new Produit(c.getInt(0),c.getString(1),c.getString(2)) ;
        return p;
    }

}
