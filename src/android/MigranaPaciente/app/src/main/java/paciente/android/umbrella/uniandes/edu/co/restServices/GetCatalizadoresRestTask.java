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
import paciente.android.umbrella.uniandes.edu.co.aplications.MigranaApplication;
import paciente.android.umbrella.uniandes.edu.co.entities.Catalizador;
import paciente.android.umbrella.uniandes.edu.co.entities.EpisodioMigrana;

/**
 * Created by Gabriel on 08/07/2015.
 */
public class GetCatalizadoresRestTask extends AsyncTask<Void,Void, List<Catalizador>> {


    private Context ctx;
    private int filtroIdEpisodio;

    public GetCatalizadoresRestTask(Context ctx)
    {
        this.ctx = ctx;
    }

    public GetCatalizadoresRestTask(Context ctx, int filtroIdEpisodio)
    {
        this.ctx = ctx;
        this.filtroIdEpisodio = filtroIdEpisodio;
    }


    @Override
    protected List<Catalizador> doInBackground(Void... params) {
        try {

            String url = ctx.getString(R.string.server_api_url) + "catalizadores/" + filtroIdEpisodio;;
            MigranaApplication app = (MigranaApplication) ctx.getApplicationContext();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            //Agrega los headers para hacer un llamado por JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            Catalizador[] catalizadores = restTemplate.exchange(url, HttpMethod.GET, null, Catalizador[].class).getBody();
            return new ArrayList<Catalizador>(Arrays.asList(catalizadores)) ;

        } catch (Exception e) {
            Log.e("EspisodioMigranaRest", e.getMessage(), e);
            System.out.println(e.getMessage());
            return  new ArrayList<Catalizador>();
        }
    }
}
