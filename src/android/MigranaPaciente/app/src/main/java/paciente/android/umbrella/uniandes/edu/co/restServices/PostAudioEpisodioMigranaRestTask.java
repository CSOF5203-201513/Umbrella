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

import java.util.Arrays;

import paciente.android.ubrella.uniandes.edu.co.migranapaciente.R;
import paciente.android.umbrella.uniandes.edu.co.entities.EpisodioMigrana;
import paciente.android.umbrella.uniandes.edu.co.entities.PostAudio;

/**
 * Created by Gabriel on 02/07/2015.
 */
public class PostAudioEpisodioMigranaRestTask extends AsyncTask<Void,Void, String> {

    private Context ctx;
    public PostAudioEpisodioMigranaRestTask(Context ctx)
    {
        this.ctx = ctx;
    }

    private String audioStringEpisodio;
    private int idEpisodio;

    public PostAudioEpisodioMigranaRestTask(Context ctx, int idEpisodio, String audioStringEpisodio)
    {
        this.ctx = ctx;
        this.audioStringEpisodio = audioStringEpisodio;
        this.idEpisodio = idEpisodio;
    }


    @Override
    protected String doInBackground(Void... params) {
        try {

            final String url = ctx.getString(R.string.server_api_url) + "api/episodios/"+ idEpisodio +"/audio";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            //Agrega los headers para hacer un llamado por JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            PostAudio audio = new PostAudio();
            audio.setAudioGrabado(audioStringEpisodio);
            HttpEntity<PostAudio> entity = new HttpEntity<PostAudio>(audio, headers);

            String respuesta = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
            return respuesta;

        } catch (Exception e) {
            Log.e("PostEpisodiosRestTask", e.getMessage(), e);
            System.out.println(e.getMessage());
            return  "";
        }
    }
}
