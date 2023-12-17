package com.example.scrollview;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Selection(View view){

        if(view.getId() == R.id.ButtonBananas){
                Toast.makeText(this, "These are bananas", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonCherries){
            Toast.makeText(this, "These are cherries", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonRaspberries){
            Toast.makeText(this, "These are raspberries", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonStrawberries){
            Toast.makeText(this, "These are strawberries", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonKiwis){
            Toast.makeText(this, "These are kiwis", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonMangos){
            Toast.makeText(this, "These are mangos", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonAples){
            Toast.makeText(this, "These are apples", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonMelon){
            Toast.makeText(this, "This is a melon", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonOranges){
            Toast.makeText(this, "These are oranges", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonPears){
            Toast.makeText(this, "These are pears", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonPineapple){
            Toast.makeText(this, "This is a pineapple", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonWatermelon){
            Toast.makeText(this, "This is a watermelon", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonGrapes){
            Toast.makeText(this, "These are grapes", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.ButtonBlackberries){
            Toast.makeText(this, "These are balckberries", Toast.LENGTH_SHORT).show();
        }

    }
}