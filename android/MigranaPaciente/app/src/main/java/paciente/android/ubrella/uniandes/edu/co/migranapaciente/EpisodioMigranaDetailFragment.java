package paciente.android.ubrella.uniandes.edu.co.migranapaciente;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.*;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


import paciente.android.umbrella.uniandes.edu.co.aplications.MigranaApplication;
import paciente.android.umbrella.uniandes.edu.co.entities.*;
import paciente.android.umbrella.uniandes.edu.co.restServices.GetEpisodiosMigranaRestTask;
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

            GetEpisodiosMigranaRestTask restEpisodios = new GetEpisodiosMigranaRestTask(getActivity(),Integer.parseInt(getArguments().getString(ARG_ITEM_ID))  );
            try {
                List<EpisodioMigrana> episodios = restEpisodios.execute().get();
                if(episodios != null && episodios.size() > 0)
                    mItem = episodios.get(0);
                else
                    mItem = new EpisodioMigrana();

            } catch (InterruptedException e) {
                //TODO: Mostrar execopcion
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_episodiomigrana_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.episodiomigrana_paciente_nombre)).setText(mItem.getPacienteNombre());
            ((TextView) rootView.findViewById(R.id.episodiomigrana_fecha)).setText(mItem.getFechaCreacion());
            ((TextView) rootView.findViewById(R.id.episodiomigrana_medico_nombre)).setText(mItem.getMedicoNombre());


            MigranaApplication application = (MigranaApplication)getActivity().getApplication();

            //Carga el drop down de localizaciones del dolor
            Spinner ddlLocalizaciones = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlLocalizacionDolor));
            ArrayAdapter<ListaValor> dataAdapterLocalizaciones = new ArrayAdapter<ListaValor>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item,  application.getLocalizacionesDolor(getActivity()));
            dataAdapterLocalizaciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ddlLocalizaciones.setAdapter(dataAdapterLocalizaciones);
            ddlLocalizaciones.setSelection(getIndexListaValor(application.getLocalizacionesDolor(getActivity()), mItem.getIdLocalizacionDolor()));


            //Carga el drop down de intensidades
            Spinner ddlIntensidad = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlIntensidad));
            ArrayAdapter<ListaValor> dataAdapterIntesidades = new ArrayAdapter<ListaValor>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item,  application.getIntensidades(getActivity()));
            dataAdapterIntesidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ddlIntensidad.setAdapter(dataAdapterIntesidades);
            ddlIntensidad.setSelection(getIndexListaValor(application.getIntensidades(getActivity()), mItem.getIdIntensidad()));


            List<ListaValor> desencadentantesParametrizados = application.getDesencadenantes(getActivity());
            if(desencadentantesParametrizados != null && desencadentantesParametrizados.size() > 0)
            {
                LinearLayout table = (LinearLayout)rootView.findViewById(R.id.episodiomigrana_trDesencadenantes);
                for (int i = 0; i < desencadentantesParametrizados.size(); i++)
                {
                    //DescripcionEpisodio descripcion = mItem.getDescripcionesEpisodio().get(i);
                    //Busca el objeto correspondiente al desencadentante enviado
                    DescripcionEpisodio descripcion = getDescripcionDesencadenantePorIdTipoDesencadenante(mItem.getDescripcionesEpisodio(), desencadentantesParametrizados.get(i).getId());

                    final TextView label = new TextView(getActivity());
                    label.setText(desencadentantesParametrizados.get(i).getValor());

                    final EditText txt = new EditText(getActivity());
                    if(descripcion != null)
                        txt.setText(descripcion.getDescripcionDesencadenante());

                    table.addView(label);
                    table.addView(txt);
                }
            }


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

                    episodio.setIdLocalizacionDolor(((ListaValor) ((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlLocalizacionDolor)).getSelectedItem()).getId());
                    episodio.setIdIntensidad(((ListaValor) ((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlIntensidad)).getSelectedItem()).getId());
                    episodio.setDescripcionesEpisodio(getDescripcionesEpisodio());
                    //episodio.setIdPaciente(application.getAuthenticatedUser().getId());

                    PostEpisodiosMigranaRestTask postTask = new PostEpisodiosMigranaRestTask(getActivity(), episodio);
                    try {
                        if(postTask.execute().get())
                        {
                            new AlertDialog.Builder(getActivity())
                            .setTitle("Operación exitosa")
                            .setMessage("El registro ha sido guardado correctamente")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int wich)
                                {
                                    getActivity().finish();
                                }
                            }).show();
                        }
                        else
                        {
                            //TODO: Mostrar error
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            });

            //Al cancelar cierra la acción
            final Button btnCancelar = ((Button) rootView.findViewById(R.id.episodiomigrana_btnCancelar));
            btnCancelar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
        }

        return rootView;
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
