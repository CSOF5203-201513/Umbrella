package com.example.javier.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.Vector;

/**
 * Created by JAVIER on 04/07/2015.
 */
public class EpisodioAdaptador extends BaseAdapter{

    private final Activity activity;
    private final Vector<String> listaEpisodios;

    public EpisodioAdaptador(Activity activity, Vector<String> listaEpisodios){
        super();
        this.activity = activity;
        this.listaEpisodios = listaEpisodios;
    }

    @Override
    public int getCount() {
        return listaEpisodios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEpisodios.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.itemepisodio, null, true);
        if(position%2==0)
            view.setBackgroundColor(Color.parseColor("#FFFF99"));
        else
            view.setBackgroundColor(Color.parseColor("#D3D3D3"));
        try{
            TextView textEpisodioId = (TextView)view.findViewById(R.id.textViewEpisodioId);
            TextView itemEpisodio = (TextView)view.findViewById(R.id.tituloItemEpisodio);
            TextView descripcion = (TextView)view.findViewById(R.id.descripcionItemEpisodio);
            JSONObject jsonObject = new JSONObject(listaEpisodios.get(position));
            textEpisodioId.setText(jsonObject.getString("id"));
            itemEpisodio.setText("Episodio"+position);
            descripcion.setText("Paciente: " + jsonObject.getString("pacienteNombre"));
        }catch (Exception e){
        }
        return view;
    }

}
