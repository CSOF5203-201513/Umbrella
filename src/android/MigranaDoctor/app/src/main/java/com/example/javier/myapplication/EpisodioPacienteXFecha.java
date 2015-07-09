package com.example.javier.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class EpisodioPacienteXFecha extends ActionBarActivity implements View.OnClickListener {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private EditText fechaDesde;
    private EditText fechaHasta;
    private Calendar cal;
    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodio_paciente_xfecha);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        fechaDesde = (EditText) findViewById(R.id.editTextFechaDesde);
        fechaHasta = (EditText) findViewById(R.id.editTextFechaHasta);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    public void consultarEpisodiosFecha(View v){
        EditText text = (EditText)this.findViewById(R.id.editTextFechaDesde);
        EditText text1 = (EditText)this.findViewById(R.id.editTextFechaHasta);
        EditText text2 = (EditText)this.findViewById(R.id.editTextCedulaPaciente1);
        String fechaDesde = text.getText()!=null ? text.getText().toString() : null;
        String fechaHasta = text1.getText()!=null ? text1.getText().toString() : null;
        String cedula = text2.getText()!=null ? text2.getText().toString() : null;
        Intent i = new Intent(EpisodioPacienteXFecha.this, EpisodiosPaciente.class);
        i.putExtra("fechaDesde", fechaDesde);
        i.putExtra("fechaHasta", fechaHasta);
        i.putExtra("cedula", cedula);
        i.putExtra("decision", "3");
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageButton1)
            showDialog(0);
        else
            showDialog(1);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        if(id==0)
            return new DatePickerDialog(this, datePickerListener, year, month, day);
        else
            return new DatePickerDialog(this, datePickerListener2, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            fechaDesde.setText(selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay);
        }
    };

    private DatePickerDialog.OnDateSetListener datePickerListener2 = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            fechaHasta.setText(selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay);
        }
    };

}
