package paciente.android.umbrella.uniandes.edu.co.restServices;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import paciente.android.ubrella.uniandes.edu.co.migranapaciente.R;
import paciente.android.umbrella.uniandes.edu.co.entities.EpisodioMigrana;
import paciente.android.umbrella.uniandes.edu.co.entities.ListaValor;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class GetListasRestTask extends AsyncTask<Void,Void, List<ListaValor>> {

    private Context ctx;
    private int filtroIdLista;

    public GetListasRestTask(Context ctx)
    {
        this.ctx = ctx;
    }

    public GetListasRestTask(Context ctx, int filtroIdLista)
    {
        this.ctx = ctx;
        this.filtroIdLista = filtroIdLista;
    }

    @Override
    protected List<ListaValor> doInBackground(Void... params) {
        try {

            final String url = ctx.getString(R.string.server_api_url) + "api/listas/" + filtroIdLista;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            //Agrega los headers para hacer un llamado por JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            ListaValor[] valores = restTemplate.exchange(url, HttpMethod.GET, null, ListaValor[].class).getBody();
            return new ArrayList<ListaValor>(Arrays.asList(valores)) ;

        } catch (Exception e) {
            Log.e("GetListasRestTask", e.getMessage(), e);
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
