package com.example.sharepreferences1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.editTextEmail);

        SharedPreferences preference = getSharedPreferences("saved", Context.MODE_PRIVATE);
        edt1.setText(preference.getString("email", ""));
    }
    public void Save(View view){
        SharedPreferences preference1 = getSharedPreferences("saved", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preference1.edit();
        Obj_editor.putString("email", edt1.getText().toString());
        Obj_editor.commit();        // Comprometer el cambio
        finish();                   // Mata activity
    }
}