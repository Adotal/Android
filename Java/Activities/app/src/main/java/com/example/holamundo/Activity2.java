package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtUser = (TextView) findViewById(R.id.tvUser);

        String dato = "User: " + getIntent().getStringExtra("dato");
        txtUser.setText(dato);
    }
    public void Back(View view){
        Intent act1 = new Intent(this, MainActivity.class);
        startActivity(act1);
    }
}