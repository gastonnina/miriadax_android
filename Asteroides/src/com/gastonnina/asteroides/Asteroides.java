package com.gastonnina.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {

    private Button bAcercaDe, bSalir, bPreferencias, bPuntuaciones;
    public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	   


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
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
}
