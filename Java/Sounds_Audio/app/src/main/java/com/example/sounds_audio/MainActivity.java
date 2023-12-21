package com.example.sounds_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool soundPool;
    int sonido_reprod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.button_short);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonido_reprod = soundPool.load(this, R.raw.zombie_sound_effect, 1);
    }

    public void AudioSoundPool(View view){
        soundPool.play(sonido_reprod, 1, 1, 1, 0, 0);
    }
    public void AudioMediaPlayer(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.far_the_days_come);
        mediaPlayer.start();
    }
}