package com.example.almacenamientosd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText edtFileName, edtFileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFileName = (EditText) findViewById(R.id.editTextFName);
        edtFileContent = (EditText) findViewById(R.id.editTextFContent);
    }

    // Save method for Button
    public void SaveFile(View view){
        String fileName = edtFileName.getText().toString();
        String fileContent = edtFileContent.getText().toString();

        try {
            // Guardar la ruta de la tarjeta SD
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(), fileName);

            // Llenar archivo
            OutputStreamWriter fileX = new OutputStreamWriter(openFileOutput(fileName, MainActivity.MODE_PRIVATE));
            fileX.write(fileContent);
            fileX.flush();
            fileX.close();
            Toast.makeText(this, "File saved successfully", Toast.LENGTH_SHORT).show();
            edtFileName.setText("");
            edtFileContent.setText("");
        } catch(IOException e){
            Toast.makeText(this, "Error saving file", Toast.LENGTH_SHORT).show();
        }
    }

    // Read method for Button
    public void ReadFile(View view){
        try{
            String fileName = edtFileName.getText().toString();

            // Guardar la ruta de la tarjeta SD
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), fileName);
            InputStreamReader openFile = new InputStreamReader(openFileInput(fileName));

            BufferedReader leerFile = new BufferedReader(openFile);
            String line = leerFile.readLine();
            String fullContent = "";

            while(line != null){
                fullContent += line + "\n";
                line = leerFile.readLine();
            }
            leerFile.close();
            openFile.close();
            edtFileContent.setText(fullContent);

        }catch(IOException e){
            Toast.makeText(this, "Error reading file", Toast.LENGTH_SHORT);
        }

    }
}