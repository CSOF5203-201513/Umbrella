package com.example.javier.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EpisodioPacienteXCedula extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodio_paciente_xcedula);
    }

    public void consultarEpisodiosCedula(View v){
        EditText text = (EditText)this.findViewById(R.id.editTextCedulaPaciente);
        String cedula = text.getText()!=null ? text.getText().toString() : null;
        Intent i = new Intent(EpisodioPacienteXCedula.this, EpisodiosPaciente.class);
        i.putExtra("cedula", cedula);
        i.putExtra("decision", "2");
        startActivity(i);
    }

}
