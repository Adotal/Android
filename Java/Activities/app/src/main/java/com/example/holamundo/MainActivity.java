package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText_name);
        passwd = (EditText) findViewById(R.id.editText_passwd);
    }
    public void NextAct(View view){
        Intent act2 = new Intent(this, Activity2.class);
        act2.putExtra("dato", name.getText().toString());
        startActivity(act2);
    }
    public void Login(View view){
        String name_string = name.getText().toString();
        String passwd_string = passwd.getText().toString();

        if(name_string.length() == 0) {
            Toast.makeText(this, "You need to type your user", Toast.LENGTH_SHORT).show();
        } else if(passwd_string.length() != 0){
            Toast.makeText(this, "Starting register...", Toast.LENGTH_SHORT).show();
        }
        if (passwd_string.length() == 0) {
            Toast.makeText(this, "You need to type your password", Toast.LENGTH_SHORT).show();
        }

    }
}