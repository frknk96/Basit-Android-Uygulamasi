package com.example.lenovo.odev;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listemiz;
    Context context = this;
    ArrayList<Yazar> list;
    Database db=new Database(context);
    ArrayAdapter<String> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listemiz=findViewById(R.id.liste);
        db.onUpgrade(db.getWritableDatabase(),1,2);
        db.yaziEkle(new Yazar("DenemeBaslik","Deneme içerik"));
        db.yaziEkle(new Yazar("DenemeBaslik2","Deneme içerik2"));
        list = db.yaziGetir();
        ArrayList<String> basliklar = new ArrayList<>();
        for(int i=0; i<basliklar.size();i++)
        {
            basliklar.add(i,list.get(i).getBaslik());
        }


        myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,basliklar);
        listemiz.setAdapter(myAdapter);

    }
}
