package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1_string;
    private EditText valor2_string;
    private TextView labelStatus;
    private RadioButton rb1, rb2, rb3, rb4; // suma, resta, multiplicación, división

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1_string = (EditText) findViewById(R.id.txtIn1);
        valor2_string = (EditText) findViewById(R.id.txtIn2);
        labelStatus = (TextView) findViewById(R.id.label_status);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
    }
    // Realizar promedio
    public void Evaluar(View view){
        String val1 = valor1_string.getText().toString();
        String val2 = valor2_string.getText().toString();

        int n1_int, n2_int;
        if(val1.length() == 0)
            n1_int = 0;
        else
            n1_int = Integer.parseInt(val1);
        if(val2.length() == 0)
            n2_int = 0;
        else
            n2_int = Integer.parseInt(val2);

        int result_int = 0;
        if(rb1.isChecked()) {
            result_int = n1_int + n2_int;
        } else if(rb2.isChecked()) {
            result_int = n1_int - n2_int;
        } else if(rb3.isChecked()){
            result_int = n1_int * n2_int;
        } else if(rb4.isChecked()){
            if(0 == n2_int){
                Toast.makeText(this, "No es posible dividir sobre cero", Toast.LENGTH_LONG).show();
            } else {
                result_int = n1_int / n2_int;
            }
        }
        String result_str = String.valueOf(result_int);

        labelStatus.setText(result_str);
    }
}