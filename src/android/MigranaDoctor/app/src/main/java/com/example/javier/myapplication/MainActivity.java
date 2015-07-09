package com.example.javier.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void contEpisodios(View v){
        Intent i = new Intent(MainActivity.this, EpisodiosPaciente.class);
        i.putExtra("decision", "1");
        startActivity(i);
    }

    public void contEpisodiosCedula(View v){
        Intent i = new Intent(MainActivity.this, EpisodioPacienteXCedula.class);
        startActivity(i);
    }

    public void contEpisodiosFecha(View v){
        Intent i = new Intent(MainActivity.this, EpisodioPacienteXFecha.class);
        startActivity(i);
    }

}
