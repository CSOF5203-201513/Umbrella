package com.example.javier.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
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
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.Vector;

public class EpisodiosPaciente extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
            Bundle parametros = getIntent().getExtras();
            String decision = parametros.getString("decision");
            if(decision.equals("1"))
                new RetriveFeedTask().execute("https://migrana.umbrellatm.tk/rest/webresources/episodios");
            else if(decision.equals("2")) {
                String cedula = parametros.getString("cedula");
                new RetriveFeedTask().execute("https://migrana.umbrellatm.tk/rest/webresources/usuarios/"+cedula+"/episodios");
            }
            else if(decision.equals("3")) {
                String fechaDesde = parametros.getString("fechaDesde");
                String fechaHasta = parametros.getString("fechaHasta");
                String cedula = parametros.getString("cedula");
                new RetriveFeedTask().execute("https://migrana.umbrellatm.tk/rest/webresources/usuarios/"+cedula+"/episodios?fi="+fechaDesde+"&ff="+fechaHasta+"");
            }
        }
        catch (Exception e){

        }
        setContentView(R.layout.activity_episodios_paciente);
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id){
        super.onListItemClick(listView, view, position, id);
        Intent i = new Intent(EpisodiosPaciente.this, DescripcionEpisodio.class);
        String idConsultaEpisodio = (String)((TextView)view.findViewById(R.id.textViewEpisodioId)).getText();
        i.putExtra("idConsultaEpisodio", idConsultaEpisodio);
        startActivity(i);
    }

    public void listarEpisodios(Vector<String> listaEpisodios){
        setListAdapter(new EpisodioAdaptador(this, listaEpisodios));
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
                JSONArray finalResult = new JSONArray(tokener);

                return finalResult.toString();
            } catch (Exception exception) {
                return null;
            }
        }

        protected void onPostExecute(String response) {
            try {
                Vector<String> listaEpisodios = new Vector();
                if (response != null){
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        listaEpisodios.add(jsonArray.getJSONObject(i).toString());
                    }
                    listarEpisodios(listaEpisodios);
                }
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
