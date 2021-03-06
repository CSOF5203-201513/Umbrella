package paciente.android.umbrella.uniandes.edu.co.restServices;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpEntity;
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
import paciente.android.umbrella.uniandes.edu.co.entities.*;

/**
 * Created by Gabriel on 30/06/2015.
 */
public class GetEpisodiosMigranaRestTask extends AsyncTask<Void,Void, List<EpisodioMigrana>> {


    private Context ctx;
    private int filtroIdEpisodio;

    public GetEpisodiosMigranaRestTask(Context ctx)
    {
        this.ctx = ctx;
    }

    public GetEpisodiosMigranaRestTask(Context ctx, int filtroIdEpisodio)
    {
        this.ctx = ctx;
        this.filtroIdEpisodio = filtroIdEpisodio;
    }

    private EpisodioMigrana episodioMigrana;
    public  EpisodioMigrana getEpisodioMigrana()
    {
        return episodioMigrana;
    }

    @Override
    protected List<EpisodioMigrana> doInBackground(Void... params) {
        try {

            String url = "";
            MigranaApplication app = (MigranaApplication) ctx.getApplicationContext();

            if(filtroIdEpisodio > 0)
                url = ctx.getString(R.string.server_api_url) + "episodios/" + filtroIdEpisodio;
            else
                url = ctx.getString(R.string.server_api_url) + "usuarios/" + app.getAuthenticatedUser().getIdentification() + "/episodios";

//            url = ctx.getString(R.string.server_api_url) + "episodios";

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            //Agrega los headers para hacer un llamado por JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            if(filtroIdEpisodio > 0)
            {
                EpisodioMigrana episodio = restTemplate.exchange(url, HttpMethod.GET, null, EpisodioMigrana.class).getBody();
                episodioMigrana = episodio;
                return null;
//                ArrayList<EpisodioMigrana> episodios = new ArrayList<EpisodioMigrana>();
//                episodios.add(episodio);
//                return episodios;
            }
            else
            {
                //realiza el llamado
              // HttpEntity<EpisodioMigrana> entity = new HttpEntity<EpisodioMigrana>(headers);
                EpisodioMigrana[] episodios = restTemplate.exchange(url, HttpMethod.GET, null, EpisodioMigrana[].class).getBody();
                return new ArrayList<EpisodioMigrana>(Arrays.asList(episodios)) ;
            }


        } catch (Exception e) {
            Log.e("EspisodioMigranaRest", e.getMessage(), e);
            System.out.println(e.getMessage());
            return  new ArrayList<EpisodioMigrana>();
        }
    }
}
