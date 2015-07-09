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

import paciente.android.ubrella.uniandes.edu.co.migranapaciente.R;
import paciente.android.umbrella.uniandes.edu.co.entities.EpisodioMigrana;
import paciente.android.umbrella.uniandes.edu.co.entities.User;


/**
 * Created by Gabriel on 01/07/2015.
 */
public class PostEpisodiosMigranaRestTask extends AsyncTask<Void,Void, EpisodioMigrana> {

    private Context ctx;
    public PostEpisodiosMigranaRestTask(Context ctx)
    {
        this.ctx = ctx;
    }

    private EpisodioMigrana episodio;

    public PostEpisodiosMigranaRestTask(Context ctx, EpisodioMigrana episodio)
    {
        this.ctx = ctx;
        this.episodio = episodio;
    }

    @Override
    protected EpisodioMigrana doInBackground(Void... params) {

        try {

            final String url = ctx.getString(R.string.server_api_url) + "episodios" + (episodio.getId() > 0 ? "/"+episodio.getId() : "") ;

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


            //Agrega los headers para hacer un llamado por JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity<EpisodioMigrana> entity = new HttpEntity<EpisodioMigrana>(episodio, headers);

            //Cuando es para edici�n env�a un put
            if(episodio.getId() > 0)
                return restTemplate.exchange(url, HttpMethod.PUT, entity, EpisodioMigrana.class).getBody();
            else
                return restTemplate.exchange(url, HttpMethod.POST, entity, EpisodioMigrana.class).getBody();


        } catch (Exception e) {
            Log.e("PostEpisodiosRestTask", e.getMessage(), e);
            System.out.println(e.getMessage());
            return  null;
        }


    }
}

