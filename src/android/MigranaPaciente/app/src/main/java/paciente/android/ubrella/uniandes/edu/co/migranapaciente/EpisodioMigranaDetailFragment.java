package paciente.android.ubrella.uniandes.edu.co.migranapaciente;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.*;
import android.widget.TextView;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import paciente.android.umbrella.uniandes.edu.co.aplications.MigranaApplication;
import paciente.android.umbrella.uniandes.edu.co.entities.*;
import paciente.android.umbrella.uniandes.edu.co.restServices.GetCatalizadoresRestTask;
import paciente.android.umbrella.uniandes.edu.co.restServices.GetEpisodiosMigranaRestTask;
import paciente.android.umbrella.uniandes.edu.co.restServices.PostAudioEpisodioMigranaRestTask;
import paciente.android.umbrella.uniandes.edu.co.restServices.PostEpisodiosMigranaRestTask;

/**
 * A fragment representing a single EpisodioMigrana detail screen.
 * This fragment is either contained in a {@link EpisodioMigranaListActivity}
 * in two-pane mode (on tablets) or a {@link EpisodioMigranaDetailActivity}
 * on handsets.
 */
public class EpisodioMigranaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private ImageButton btnRecordButton = null;
    private MediaRecorder mRecorder = null;
    private static String mFileName = null;

    private ImageButton   btnPlayButton = null;
    private MediaPlayer mPlayer = null;




    /**
     * The dummy content this fragment is presenting.
     */
    private EpisodioMigrana mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EpisodioMigranaDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            int idEpisodioSeleccionado = Integer.parseInt(getArguments().getString(ARG_ITEM_ID));

            if(idEpisodioSeleccionado > 0)
            {
                GetEpisodiosMigranaRestTask restEpisodios = new GetEpisodiosMigranaRestTask(getActivity(), idEpisodioSeleccionado );
                try {
                    //List<EpisodioMigrana> episodios = restEpisodios.execute().get();
//                    if(episodios != null && episodios.size() > 0)
//                        mItem = episodios.get(0);
//                    else
//                        mItem = new EpisodioMigrana();
                    restEpisodios.execute().get();
                    mItem = restEpisodios.getEpisodioMigrana();
                } catch (InterruptedException e) {
                    //TODO: Mostrar execopcion
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                mItem = null;
            }


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_episodiomigrana_detail, container, false);

        MigranaApplication application = (MigranaApplication)getActivity().getApplication();
        //Carga el drop down de localizaciones del dolor
        Spinner ddlLocalizaciones =cargarDdlLocalizaciones(rootView, application);
        //Carga el drop down de intensidades
        Spinner ddlIntensidad = cargarDdlIntensidades(rootView, application);
        //Carga los desencadenantes
        cargarDescripciones(rootView, application);


        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.episodiomigrana_paciente_nombre)).setText(mItem.getPacienteNombre());
            ((TextView) rootView.findViewById(R.id.episodiomigrana_fecha)).setText(mItem.getFechaCreacion());
            ((TextView) rootView.findViewById(R.id.episodiomigrana_medico_nombre)).setText(mItem.getMedicoNombre());

            ddlLocalizaciones.setSelection(getIndexListaValor(application.getLocalizacionesDolor(getActivity()), mItem.getIdlocalizacionDolor()));
            ddlIntensidad.setSelection(getIndexListaValor(application.getIntensidades(getActivity()), mItem.getIdIntensidad()));
        }

        cargarBotonGuardar(rootView);
        cargarBotonCancelar(rootView);
        cargarBotonGrabar(rootView);
        cargarBotonReproducir(rootView);

        return rootView;
    }
    private void cargarBotonCancelar(View rootView)
    {
        //Al cancelar cierra la acción
        final Button btnCancelar = ((Button) rootView.findViewById(R.id.episodiomigrana_btnCancelar));
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }


    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
            mRecorder.start();
        } catch (Exception e) {
            Log.e("GuardarAudio", "prepare() failed");
        }


    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;

    }

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    boolean mStartRecording = true;
    private void cargarBotonGrabar(View rootView)
    {
        btnRecordButton = (ImageButton)rootView.findViewById(R.id.episodiomigrana_btnGrabarAudio);

        View.OnClickListener clicker = new View.OnClickListener() {
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    btnRecordButton.setBackgroundColor(Color.parseColor("#ffcc000e"));
                    btnRecordButton.setImageResource(R.drawable.ic_media_pause);
                } else {
                    btnRecordButton.setBackgroundColor(Color.parseColor("#ff1a98f2"));
                    btnRecordButton.setImageResource(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
                    btnPlayButton.setVisibility(View.VISIBLE);
                }
                mStartRecording = !mStartRecording;
            }
        };

        btnRecordButton.setOnClickListener(clicker);

    }

    boolean mStartPlaying = true;
    private void cargarBotonReproducir(View rootView)
    {
        btnPlayButton = (ImageButton)rootView.findViewById(R.id.episodiomigrana_btnReproducirAudio);

        //Si no tiene audio previo oculta el boton de reproducir
        if(mItem == null || mItem.getUrlAudio() == null || mItem.getUrlAudio() == "")
            btnPlayButton.setVisibility(View.GONE);

        View.OnClickListener clicker = new View.OnClickListener() {

                public void onClick(View v) {
                    onPlay(mStartPlaying);
                    if (mStartPlaying) {
                        btnPlayButton.setBackgroundColor(Color.parseColor("#ffcc000e"));
                        btnPlayButton.setImageResource(R.drawable.ic_media_pause);
                    } else {
                        btnPlayButton.setBackgroundColor(Color.parseColor("#ff1a98f2"));
                        btnPlayButton.setImageResource(R.drawable.ic_media_play);
                    }
                    mStartPlaying = !mStartPlaying;
                }

        };

        btnPlayButton.setOnClickListener(clicker);
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            String fileName = null;
            //Si no se ha grabado nada y el episodio ya existe valida si en la URL ya venía algo
            if(mItem != null && mFileName == null)
            {
                fileName = mItem.getUrlAudio();

                if(fileName != null)
                {
                    fileName = getActivity().getString(R.string.server_api_url) + fileName;
                    mFileName = fileName;
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                }

            }
            else
            {
                fileName = mFileName;
            }

            if(fileName != null)
            {
                mPlayer.setDataSource(mFileName);
                mPlayer.prepare();
                mPlayer.start();
            }
            else
            {
                new AlertDialog.Builder(getActivity())
                        .setTitle("No hay audio")
                        .setMessage("En el momento no hay audio para reproducir")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int wich) {
                                btnPlayButton.setBackgroundColor(Color.parseColor("#ff1a98f2"));
                                btnPlayButton.setImageResource(R.drawable.ic_media_play);
                            }
                        }).show();
            }

        } catch (IOException e) {
            Log.e("IntentandoReproducir", "prepare() failed");
        }
        catch(Exception e)
        {
            Log.e("IntentandoReproducir", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }


     private void cargarBotonGuardar(View rootView)
     {
         //Se atacha al evento del bot�n
         final Button button = ((Button) rootView.findViewById(R.id.episodiomigrana_btnGuardar));
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
                 EpisodioMigrana episodio = new EpisodioMigrana();
                 MigranaApplication application = (MigranaApplication)getActivity().getApplication();

                 int idEpisodio = Integer.parseInt(getArguments().getString(ARG_ITEM_ID));
                 //Actualizacion
                 if (idEpisodio > 0)
                     episodio.setId(idEpisodio);

                 episodio.setIdlocalizacionDolor(((ListaValor) ((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlLocalizacionDolor)).getSelectedItem()).getId());
                 episodio.setIdIntensidad(((ListaValor) ((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlIntensidad)).getSelectedItem()).getId());
                 episodio.setDesencadenantes(getDescripcionesEpisodio());
                 episodio.setIdPaciente(application.getAuthenticatedUser().getId());

                 episodio.setIdMedico(1);
                 //episodio.setIdPaciente(application.getAuthenticatedUser().getId());

                 PostEpisodiosMigranaRestTask postTask = new PostEpisodiosMigranaRestTask(getActivity(), episodio);
                 try {
                     EpisodioMigrana episodioGuardado = postTask.execute().get();
                     if(episodioGuardado != null)
                     {
                        idEpisodio = episodioGuardado.getId();
                        //Si hay archivo para enviar lo envia
                         if(mFileName != null)
                         {
                             File file = new File(mFileName);
                             byte[] bytes = FileUtils.readFileToByteArray(file);
                             String encodedAudio = Base64.encodeToString(bytes, 0);
                             PostAudioEpisodioMigranaRestTask postAudio = new PostAudioEpisodioMigranaRestTask(getActivity(),idEpisodio, encodedAudio );
                             mItem.setUrlAudio(postAudio.execute().get());
                         }


                         List<Catalizador> catalizadores = new GetCatalizadoresRestTask(getActivity(), idEpisodio).execute().get();
                         String strCatalizadores = "";
                         if(catalizadores != null && catalizadores.size() > 0)
                         {
                             strCatalizadores = "Los Catalizadores encontrados para su caso son:";
                             for (Catalizador catalizador : catalizadores)
                             {
                                 strCatalizadores += catalizador.getNombre() + ", ";
                             }
                         }


                         new AlertDialog.Builder(getActivity())
                                 .setTitle("Operación exitosa")
                                 .setMessage("El registro ha sido guardado correctamente. " + strCatalizadores)
                                 .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                     public void onClick(DialogInterface dialog, int wich) {
                                         getActivity().finish();
                                     }
                                 }).show();
                     }
                     else
                     {
                         //TODO: Mostrar error
                     }
                 } catch (InterruptedException e) {
                     //TODO:Mostrar error
                     e.printStackTrace();
                 } catch (ExecutionException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
         });

     }



    private List<DescripcionEpisodio> getDescripcionesEpisodio() {
        LinearLayout tableDescripciones = (LinearLayout)getActivity().findViewById(R.id.episodiomigrana_trDesencadenantes);
        MigranaApplication application = (MigranaApplication)getActivity().getApplication();
        //jElemento lelva la cuenta de cual es el actual "Descripcion" que se va evaluar para sacar el Id del objeto mItem
        int jElemento = 0;
        ArrayList<DescripcionEpisodio> descripciones = new ArrayList<DescripcionEpisodio>();
        List<ListaValor> desencadentantesParametrizados = application.getDesencadenantes(getActivity());
        for(int i = 0; i < tableDescripciones.getChildCount(); i++)
        {
            View v = tableDescripciones.getChildAt(i);
            if(v instanceof EditText)
            {
                DescripcionEpisodio descripcion = new DescripcionEpisodio();
                descripcion.setDescripcionDesencadenante(((EditText) v).getText().toString());
                descripcion.setIdTipoDesencadenante(desencadentantesParametrizados.get(jElemento).getId());
                descripciones.add(descripcion);
                jElemento++;
            }
        }
        return descripciones;
    }


    public Spinner cargarDdlLocalizaciones(View rootView, MigranaApplication application)
    {
        Spinner ddlLocalizaciones = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlLocalizacionDolor));
        ArrayAdapter<ListaValor> dataAdapterLocalizaciones = new ArrayAdapter<ListaValor>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, application.getLocalizacionesDolor(getActivity()));
        dataAdapterLocalizaciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ddlLocalizaciones.setAdapter(dataAdapterLocalizaciones);
        return ddlLocalizaciones;
    }

    public Spinner cargarDdlIntensidades(View rootView, MigranaApplication application)
    {
        Spinner ddlIntensidad = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlIntensidad));
        ArrayAdapter<ListaValor> dataAdapterIntesidades = new ArrayAdapter<ListaValor>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,  application.getIntensidades(getActivity()));
        dataAdapterIntesidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ddlIntensidad.setAdapter(dataAdapterIntesidades);
        return ddlIntensidad;
    }

    public void cargarDescripciones(View rootView, MigranaApplication application)
    {
        List<ListaValor> desencadentantesParametrizados = application.getDesencadenantes(getActivity());
        if(desencadentantesParametrizados != null && desencadentantesParametrizados.size() > 0)
        {
            LinearLayout table = (LinearLayout)rootView.findViewById(R.id.episodiomigrana_trDesencadenantes);
            for (int i = 0; i < desencadentantesParametrizados.size(); i++)
            {
                //DescripcionEpisodio descripcion = mItem.getDescripcionesEpisodio().get(i);
                //Busca el objeto correspondiente al desencadentante enviado
                DescripcionEpisodio descripcion = new DescripcionEpisodio();
                //Si esta editando carga el vvalor del objeto, si esta creando carga el valor de la LISTAVALOR
                if(mItem != null)
                    descripcion = getDescripcionDesencadenantePorIdTipoDesencadenante(mItem.getDesencadenantes(), desencadentantesParametrizados.get(i).getId());
                else
                    descripcion.setNombreTipoDesencadenante(desencadentantesParametrizados.get(i).getValor());

                final TextView label = new TextView(getActivity());
                label.setText(desencadentantesParametrizados.get(i).getValor());

                final EditText txt = new EditText(getActivity());
                if(descripcion != null)
                    txt.setText(descripcion.getDescripcionDesencadenante());

                table.addView(label);
                table.addView(txt);
            }
        }

    }

    /***
     * Valida el index de un objeto en la lista buscando por id
     * @param lista
     * @return
     */
    private int getIndexListaValor(List<ListaValor> lista, int id)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    /**
     * Retorna el valor de BD que tiene un desencadenante en el rpisodio, buscando por id tipo desencadenante
     * @param lista
     * @return
     */
    private DescripcionEpisodio getDescripcionDesencadenantePorIdTipoDesencadenante(List<DescripcionEpisodio> lista, int idTipoDesencadenante)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).getIdTipoDesencadenante() == idTipoDesencadenante)
                return lista.get(i);
        }
        return null;
    }
}
