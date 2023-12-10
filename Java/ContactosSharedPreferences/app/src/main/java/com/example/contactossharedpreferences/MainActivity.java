package com.example.contactossharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.editText1);
        edt2 = (EditText) findViewById(R.id.editText2);
    }

    // Método guardar
    public void Save(View view){
        String name = edt1.getText().toString();
        String details = edt2.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor objt_edit = preferencias.edit();
        objt_edit.putString(name, details);
        objt_edit.apply();  // objt_edit.commmit();

        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
    }

    // Método buscar
    public void Search(View view){
        String name = edt1.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String details = preferencias.getString(name, "");

        if(details.length() == 0){
            Toast.makeText(this, "The contact doesn't exist", Toast.LENGTH_SHORT).show();
        } else {
            edt2.setText(details);
        }
    }

}