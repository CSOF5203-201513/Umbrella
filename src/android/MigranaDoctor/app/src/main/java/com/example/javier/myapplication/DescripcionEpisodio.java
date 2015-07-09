package com.example.javier.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore;

public class DescripcionEpisodio extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_episodio);
        try {
            Bundle parametros = getIntent().getExtras();
            String idConsultaEpisodio = parametros.getString("idConsultaEpisodio");
            new RetriveFeedTask().execute("https://migrana.umbrellatm.tk/rest/webresources/episodios/" + idConsultaEpisodio);
        }
        catch (Exception e){

        }
    }

    public void modificarVistaEpisodios(JSONObject object){
        try{
            TextView nombrePaciente = (TextView)this.findViewById(R.id.textViewNombrePacienteId);
            TextView textDesencadenante = (TextView)this.findViewById(R.id.textViewListaDesencadenanteId);
            TextView textIntensidad = (TextView)this.findViewById(R.id.textViewDescripcionIntensidadId);
            TextView textLocalizacion = (TextView)this.findViewById(R.id.textViewDescripcionLocalizacionId);
            nombrePaciente.setText((String) object.get("pacienteNombre"));
            textIntensidad.setText((String) object.get("intensidad"));
            textLocalizacion.setText((String) object.get("localizacionDolor"));
            JSONArray listaDesencadenante = object.getJSONArray("desencadenantes");
            String desEpisodio = "";
            for(int i = 0; i<listaDesencadenante.length(); i++){
                JSONObject desencadenante = listaDesencadenante.getJSONObject(i);
                desEpisodio = desEpisodio + desencadenante.get("descripcionDesencadenante") +"\n";
            }
            textDesencadenante.setText(desEpisodio);
        }
        catch (Exception e){

        }
    }

    private class RetriveFeedTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            try {
                HttpClient httpClient = getNewHttpClient();//new DefaultHttpClient();
                HttpGet get = new HttpGet(urls[0]);
                get.setHeader("content-type", "application/json");
                HttpResponse resp = httpClient.execute(get);

                BufferedReader reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent(), "UTF-8"));
                StringBuilder builder = new StringBuilder();
                for (String line; (line = reader.readLine()) != null;) {
                    builder.append(line).append("\n");
                }
                JSONTokener tokener = new JSONTokener(builder.toString());
                JSONObject object = new JSONObject(tokener);
                return object.toString();
            } catch (Exception exception) {
                return null;
            }
        }

        protected void onPostExecute(String response) {
            try {
                JSONObject object = new JSONObject(response);
                modificarVistaEpisodios(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public HttpClient getNewHttpClient() {
            try {
                KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
                trustStore.load(null, null);

                MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
                sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

                HttpParams params = new BasicHttpParams();
                HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
                HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

                SchemeRegistry registry = new SchemeRegistry();
                registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                registry.register(new Scheme("https", sf, 443));

                ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

                return new DefaultHttpClient(ccm, params);
            } catch (Exception e) {
                return new DefaultHttpClient();
            }
        }

    }

}
