package com.example.aplicacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    private TextView txt1;
    private String nombres[] = {"Pedro", "Juan", "Rodrigo", "Samuel", "Adrian", "José", "Luis",
                                "Gabriel", "Sofía"};
    private String edades[] = {"15", "27", "28", "16", "34", "19", "45", "43", "24"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.textview1);
        lv1 = (ListView) findViewById(R.id.listview1);

        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, R.layout.listview_item_names, nombres);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edades[i] + " años");
            }
        });
    }
}