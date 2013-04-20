package com.gastonnina.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Asteroides extends Activity {
	private VistaJuego vistaJuego;
	public MediaPlayer mp;
	
    private Button bAcercaDe, bSalir, bPreferencias, bPuntuaciones, bJugar;
    public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mp = MediaPlayer.create(this, R.raw.audio);
        mp.start();
        
        bJugar = (Button) findViewById(R.id.Button01);
        bJugar.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	lanzarJuego(null);
            }
        });
        
        bPreferencias = (Button) findViewById(R.id.Button02);
        bPreferencias.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                lanzarPreferencias(null);
            }
        });
        
        bAcercaDe = (Button) findViewById(R.id.Button03);
        bAcercaDe.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe(null);
            }
        });
        /**
        bSalir = (Button) findViewById(R.id.Button04);
        bSalir.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        /**/
        bPuntuaciones = (Button) findViewById(R.id.Button04);
        bPuntuaciones.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	lanzarPuntuaciones(null);
            }
        });
        vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
    }
   
    @Override
    protected void onSaveInstanceState(Bundle estadoGuardado) {
        super.onSaveInstanceState(estadoGuardado);
        if (mp != null) {
            int pos = mp.getCurrentPosition();
            estadoGuardado.putInt("posicion", pos);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle estadoGuardado) {
        super.onRestoreInstanceState(estadoGuardado);
        if (estadoGuardado != null && mp != null) {
            int pos = estadoGuardado.getInt("posicion");
            mp.seekTo(pos);
        }
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        mp.start();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

        super.onPause();
        mp.pause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        	case R.id.config:
        		lanzarPreferencias(null);
            break;
            case R.id.acercaDe:
                lanzarAcercaDe(null);
                break;
        }

        return true;
        /**
         * true -> consumimos el item, no se propaga
         */
    }

    public void lanzarAcercaDe(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
    public void lanzarPreferencias(View view) {
        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);
    }
    public void lanzarPuntuaciones(View view) {
    	Intent i = new Intent(this, Puntuaciones.class);
    	startActivity(i);
	}
    public void lanzarJuego(View view) {
    	Intent i = new Intent(this, Juego.class);
    	startActivity(i);
	}
}
