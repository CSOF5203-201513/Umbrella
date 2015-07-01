package paciente.android.ubrella.uniandes.edu.co.migranapaciente;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.List;
import java.util.concurrent.ExecutionException;


import paciente.android.umbrella.uniandes.edu.co.aplications.MigranaApplication;
import paciente.android.umbrella.uniandes.edu.co.entities.*;
import paciente.android.umbrella.uniandes.edu.co.restServices.GetEpisodiosMigranaRestTask;

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
            //mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

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



            MigranaApplication application = (MigranaApplication)getActivity().getApplication();

            //Carga el drop down de localizaciones del dolor
            Spinner ddlLocalizaciones = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlLocalizacionDolor));
            ArrayAdapter<ListaValor> dataAdapterLocalizaciones = new ArrayAdapter<ListaValor>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item,  application.getLocalizacionesDolor(getActivity()));
            dataAdapterLocalizaciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ddlLocalizaciones.setAdapter(dataAdapterLocalizaciones);

            //Carga el drop down de intensidades
            Spinner ddlIntensidad = ((Spinner) rootView.findViewById(R.id.episodiomigrana_ddlIntensidad));
            ArrayAdapter<ListaValor> dataAdapterIntesidades = new ArrayAdapter<ListaValor>(getActivity(),
                    android.R.layout.simple_spinner_dropdown_item,  application.getIntensidades(getActivity()));
            dataAdapterIntesidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ddlIntensidad.setAdapter(dataAdapterIntesidades);


            //Se atacha al evento del bot�n
            final Button button = ((Button) rootView.findViewById(R.id.episodiomigrana_btnGuardar));
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    EpisodioMigrana episodio = new EpisodioMigrana();

                    int idEpisodio = Integer.parseInt(getArguments().getString(ARG_ITEM_ID));
                    //Actualizacion
                    if(idEpisodio > 0)
                        episodio.setId(idEpisodio);


                    //episodio.setIdPaciente(((MigranaApplication)getActivity().getApplication()).getAuthenticatedUser().getIdentification());

                    episodio.setIdLocalizacionDolor(((ListaValor)((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlLocalizacionDolor)).getSelectedItem()).getId()); ;
                    episodio.setIdIntensidad(((ListaValor)((Spinner) getActivity().findViewById(R.id.episodiomigrana_ddlIntensidad)).getSelectedItem()).getId());

                }
            });
        }

        return rootView;
    }
}
