package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;
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

    private EditText valor1_string;
    private EditText valor2_string;
    private TextView labelStatus;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1_string = (EditText) findViewById(R.id.txtIn1);
        valor2_string = (EditText) findViewById(R.id.txtIn2);
        labelStatus = (TextView) findViewById(R.id.label_status);
        spinner = (Spinner) findViewById(R.id.spinner1);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        // Llenar el espiner de sus opciones
        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_calc, opciones);
        spinner.setAdapter(adaptador);

    }
    public void Calcular(View view){
        String val1 = valor1_string.getText().toString();
        String val2 = valor2_string.getText().toString();
        String option = spinner.getSelectedItem().toString();
        String result_str = "";
        int n1_int = Integer.parseInt(val1);
        int n2_int = Integer.parseInt(val2);
        int result_int = 0;
        if(option.equals("Sumar")){
            result_int = n1_int + n2_int;
        } else if (option.equals("Restar")){
            result_int = n1_int - n2_int;
        } else if (option.equals("Multiplicar")){
            result_int = n1_int * n2_int;
        } else if (option.equals("Dividir")){
            if(n2_int != 0) {
                result_int = n1_int / n2_int;
            } else {
                Toast.makeText(this, "No es posible dividir sobre cero", Toast.LENGTH_SHORT).show();
            }
        }
        result_str = String.valueOf(result_int);
        labelStatus.setText(result_str);
    }
}