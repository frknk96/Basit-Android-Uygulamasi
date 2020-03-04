package com.example.lenovo.odev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final int database_Version = 1;
    private static final String database_Name = "YazilarDB";
    private static final String table_Name = "yazi";
    private static final String yazi_Id = "id";
    private static final String yazi_Basligi = "baslik";
    private static final String yazi_Icerigi = "icerik";
    private static final String db_Sorgu = "CREATE TABLE "
            + table_Name + " ("
            + yazi_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + yazi_Basligi + " TEXT, "
            + yazi_Icerigi + " TEXT ) ";

    public Database(Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE yazi (id INTEGER PRIMARY KEY AUTOINCREMENT,baslik TEXT,icerik TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_Name);
        this.onCreate(db);
    }

    public void yaziEkle(Yazar yazi)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues veriler = new ContentValues();
        veriler.put(yazi_Basligi,yazi.getBaslik());
        veriler.put(yazi_Icerigi,yazi.getIcerik());
        db.insert(table_Name,null,veriler);
        db.close();
    }

    public ArrayList<Yazar> yaziGetir()
    {
        ArrayList<Yazar> yazilar = new ArrayList<>();
        String query = "SELECT * FROM yazi";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Yazar yazar = null;

        if(cursor.moveToFirst())
        {
            do {
                yazar = new Yazar();
                yazar.setId(Integer.parseInt(cursor.getString(0)));
                yazar.setBaslik(cursor.getString(1));
                yazar.setBaslik(cursor.getString(2));
                yazilar.add(yazar);
            }while(cursor.moveToNext());
        }
        return yazilar;
    }
   /* public void yaziGoster()
    {
        Yazar yazar = new Yazar();
        ArrayList<String> basliklar = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM yazi ORDER BY id DESC", null);
        int i=1;
        while(cursor.moveToNext())
        {
            basliklar.add(i + "-) " + yazar.getBaslik());
        }
    }*/
}
