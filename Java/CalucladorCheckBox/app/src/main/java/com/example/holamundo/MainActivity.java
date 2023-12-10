package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1_string;
    private EditText valor2_string;
    private TextView labelStatus;
    private CheckBox check1, check2; // suma, resta, multiplicación, división

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1_string = (EditText) findViewById(R.id.txtIn1);
        valor2_string = (EditText) findViewById(R.id.txtIn2);
        labelStatus = (TextView) findViewById(R.id.label_status);
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
    }
    // Realizar promedio
    public void Calcular(View view){
        String val1 = valor1_string.getText().toString();
        String val2 = valor2_string.getText().toString();
        String result_str = "";
        int n1_int = Integer.parseInt(val1);
        int n2_int = Integer.parseInt(val2);

        if(check1.isChecked()) {
            int suma = n1_int + n2_int;
            result_str += "Suma: " + suma;
            if(check2.isChecked()){
                result_str += " / ";
            }
        }
        if(check2.isChecked()){
            int resta = n1_int - n2_int;
            result_str += "Resta: " + resta;
        }

        //result_str = String.valueOf(result_int);
        labelStatus.setText(result_str);
    }
}