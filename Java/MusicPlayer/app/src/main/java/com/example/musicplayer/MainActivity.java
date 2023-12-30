package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play, repeat;
    MediaPlayer mp;

    ImageView imv;
    int ind=0;

    boolean repetir = false;

    MediaPlayer vectormp[] = new MediaPlayer[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.button_play);
        repeat = findViewById(R.id.button_repeat);
        imv = findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.adventures_a_himitsu);
        vectormp[1] = MediaPlayer.create(this, R.raw.hey_sailor_letterbox);
        vectormp[2] = MediaPlayer.create(this, R.raw.where_shall_we_dine_letterbox);
    }
    public void Play(View view){
        if(vectormp[ind].isPlaying()){
            vectormp[ind].pause();
            play.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[ind].start();
            play.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Reproduciendo", Toast.LENGTH_SHORT).show();
        }
    }
    public void Stop(View view){
        if(vectormp[ind] != null) {
            vectormp[ind].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.adventures_a_himitsu);
            vectormp[1] = MediaPlayer.create(this, R.raw.hey_sailor_letterbox);
            vectormp[2] = MediaPlayer.create(this, R.raw.where_shall_we_dine_letterbox);
            ind = 0;

            play.setBackgroundResource(R.drawable.reproducir);
            imv.setBackgroundResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
    public void Repetir(View view){
        if(repetir) {

            repeat.setBackgroundResource(R.drawable.no_repetir);
            vectormp[ind].setLooping(false);
            repetir = false;
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
        } else {

            repeat.setBackgroundResource(R.drawable.repetir);
            vectormp[ind].setLooping(true);
            repetir = true;
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
        }
    }

    public void Siguiente(View view){
        if(ind < vectormp.length - 1) {
            if(vectormp[ind].isPlaying()){
                vectormp[ind].stop();
                vectormp[++ind].start();

            } else {
                ++ind;
            }
            if(0 == ind){
                imv.setBackgroundResource(R.drawable.portada1);
            } else if(1 == ind){
                imv.setBackgroundResource(R.drawable.portada2);
            } else if(2 == ind){
                imv.setBackgroundResource(R.drawable.portada3);
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(View view){
        if(ind >= 1) {
            if(vectormp[ind].isPlaying()){
                vectormp[ind].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.adventures_a_himitsu);
                vectormp[1] = MediaPlayer.create(this, R.raw.hey_sailor_letterbox);
                vectormp[2] = MediaPlayer.create(this, R.raw.where_shall_we_dine_letterbox);
                vectormp[--ind].start();
            } else {
                --ind;
            }
            if(0 == ind){
                imv.setBackgroundResource(R.drawable.portada1);
            } else if(1 == ind){
                imv.setBackgroundResource(R.drawable.portada2);
            } else if(2 == ind){
                imv.setBackgroundResource(R.drawable.portada3);
            }
        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}