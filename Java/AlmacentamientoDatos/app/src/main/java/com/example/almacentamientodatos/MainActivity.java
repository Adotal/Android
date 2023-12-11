package com.example.almacentamientodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.editText1);

        String ficheros[] = fileList();     // Recuper ficheros a través de un array
        if(ArchivoExiste(ficheros, "bitacora.txt")){

            try {
                // Abrir el archivo para leerlo
                InputStreamReader file = new InputStreamReader(openFileInput("bitacora.txt"));
                // Leer el archivo
                BufferedReader bfr = new BufferedReader(file);
                // Guardar el archivo
                String linea = bfr.readLine();
                String bitacora_completa = "";

                // Leer línea por línea el archivo
                while(linea != null){
                    bitacora_completa = bitacora_completa + linea + "\n";
                    linea = bfr.readLine();
                }

                bfr.close();    // Dejar de leer
                file.close();   // Cerrar archivo
                edt1.setText(bitacora_completa);    // Colocar el texto en el editText
            } catch(IOException e){

            }
        }
    }

    private boolean ArchivoExiste(String archivos[], String fileName){
        // Sólo en métodos booleanos podemos omitir llaves de apertura y cierre
        for (int i = 0; i < archivos.length; ++i)
            if (fileName.equals(archivos[i]))
                return true;
        return false;
    }
    public void SaveFile(View view){
        try {
            // Crear objeto "archivo"
            OutputStreamWriter archivo =
               new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            // Escribe en el archivo
            archivo.write(edt1.getText().toString());
            archivo.flush();    // Limpia el búfer
            archivo.close();    // Cierra el archivo
        } catch (Exception e){

        }
        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}