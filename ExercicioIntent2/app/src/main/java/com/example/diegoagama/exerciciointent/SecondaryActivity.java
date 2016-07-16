package com.example.diegoagama.exerciciointent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
    }

    public void googleMaps(View view){
        Intent i = new Intent(SecondaryActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void enviarSMS(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("número", "0987654321");
        i.putExtra("mensagem", "Olá Palavra");
        startActivity(i);
    }

    public void definirAlarme(View view){
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme Daora");
        i.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt("14"));
        i.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt("30"));
        startActivity(i);
    }

    public void abrirMusica(View view){
        Intent i = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        i.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        i.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, "Legião Urbana");
        i.putExtra(SearchManager.QUERY, "Legião Urbana");
        startActivity(i);
    }

    public void fazerBusca(View view){
        Uri uri = Uri.parse("https://www.google.com.br/?espv=2#q=busca+direta+qualquer");
        Intent i = new Intent (Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    public void abrirConfig(View view){
        Intent i = new Intent (Settings.ACTION_SETTINGS);
        startActivity(i);
    }
}
