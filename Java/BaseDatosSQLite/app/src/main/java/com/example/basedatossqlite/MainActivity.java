package com.example.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtCode, edtDescription, edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCode = (EditText) findViewById(R.id.editTextCode);
        edtDescription = (EditText) findViewById(R.id.editTextDescription);
        edtPrice = (EditText) findViewById(R.id.editTextPrice);
    }

    // Create method
    public void CreateProduct(View view){
        // Conexión con base de datos
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase basedatos = dbAdmin.getWritableDatabase();

        String code = edtCode.getText().toString();
        String description = edtDescription.getText().toString();
        String price = edtPrice.getText().toString();

        // Si todos los campos tienen información:
        if(!code.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues registro = new ContentValues();

            // Guardar valores
            registro.put("code", code);
            registro.put("description", description);
            registro.put("price", price);

            // Insertar en tabla
            basedatos.insert("articulos", null, registro);
            // Cerrar base de datos
            basedatos.close();
            // Vaciar campos de texto
            edtCode.setText("");
            edtDescription.setText("");
            edtPrice.setText("");

            Toast.makeText(this, "Product created successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "You need to fill the required information", Toast.LENGTH_SHORT).show();
        }

    }
    // Search method
    public void SearchProduct(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase baseDatos = dbAdmin.getWritableDatabase();

        String code = edtCode.getText().toString();

        if(!code.isEmpty()){
            // Selecciona la description y precio de la tabla articulos donde code == code
            Cursor fila = baseDatos.rawQuery
                    ("select description, price from articulos where code =" + code, null);
            // Revisar si la consulta tiene valores
            if(fila.moveToFirst()){
                edtDescription.setText(fila.getString(0));
                edtPrice.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "The product doesn't exist", Toast.LENGTH_SHORT).show();
            }
            baseDatos.close();

        } else {
            Toast.makeText(this, "Please, set the product code", Toast.LENGTH_SHORT).show();
        }
    }
    // Modify method
    public void ModifyProuct(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase dataBase = dbAdmin.getWritableDatabase();

        String code = edtCode.getText().toString();
        String description = edtDescription.getText().toString();
        String price = edtPrice.getText().toString();

        if(!code.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues registro = new ContentValues();

            // Guardar valores
            registro.put("code", code);
            registro.put("description", description);
            registro.put("price", price);

            // Realiza los cambios en el objeto registro y regresa int
            int cantidad = dataBase.update("articulos", registro, "code="+code, null);
            dataBase.close();

            // Ya que sólo se modificó un producto
            if(1 == cantidad){
                Toast.makeText(this, "Product modified successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error, the product doesn't exist", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "You need to set the product code", Toast.LENGTH_SHORT).show();
        }
    }
    // Delete method
    public void DeleteProduct(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase dataBase = dbAdmin.getWritableDatabase();

        String code = edtCode.getText().toString();

        if(!code.isEmpty()){
            // .delete() retorna valor entero, de la cantidad de elementos borrados
            int cantidad = dataBase.delete("articulos", "code="+code, null);
            edtCode.setText("");
            edtDescription.setText("");
            edtPrice.setText("");
            if(1 == cantidad){
                Toast.makeText(this, "Product deleted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "The product doesn't exist", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "You need to set the product code", Toast.LENGTH_SHORT).show();
        }
        dataBase.close();
    }
}