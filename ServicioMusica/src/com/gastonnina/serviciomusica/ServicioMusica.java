package com.gastonnina.serviciomusica;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServicioMusica extends Service {

    MediaPlayer reproductor;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show();
        reproductor = MediaPlayer.create(this, R.raw.audio);        
    }

    @Override
    public int onStartCommand(Intent intenc, int flags, int idArranque) {
        Toast.makeText(this, "Servicio arrancado " + idArranque, Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show();
        reproductor.stop();
    }

    @Override
    public IBinder onBind(Intent intencion) {
        return null;
    }
}