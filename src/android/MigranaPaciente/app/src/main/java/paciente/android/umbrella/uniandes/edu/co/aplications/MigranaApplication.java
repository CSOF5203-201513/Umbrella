package paciente.android.umbrella.uniandes.edu.co.aplications;

import android.app.Application;
import android.content.Context;

import java.util.List;
import java.util.concurrent.ExecutionException;

import paciente.android.umbrella.uniandes.edu.co.entities.ListaValor;
import paciente.android.umbrella.uniandes.edu.co.entities.User;
import paciente.android.umbrella.uniandes.edu.co.restServices.GetListasRestTask;

/**
 * Created by Gabriel on 29/06/2015.
 */
public class MigranaApplication extends Application {

    private User authenticatedUser;

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;

    }



    private List<ListaValor> localizacionesDolor;
    /***
     * Retorna todas las localizaciones del dolor existentes
     * @param ctx Contexto de la aplicacion
     * @return
     */
    public List<ListaValor> getLocalizacionesDolor(Context ctx){
        //Si ya fueron consultadas previamente no las consulta de nuevo
        if(localizacionesDolor == null)
        {
            GetListasRestTask listasRest = new GetListasRestTask(ctx, 1);
            try {
                localizacionesDolor = listasRest.execute().get();
            } catch (InterruptedException e) {
                //TODO:codigo de exepcion
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return localizacionesDolor;
    }


    private List<ListaValor> desencadenantes;
    /***
     * Retorna todos los desencadenantes activos en el sistema
     * @param ctx Contexto de la aplicacion
     * @return
     */
    public List<ListaValor> getDesencadenantes(Context ctx){
        //Si ya fueron consultadas previamente no las consulta de nuevo
        if(desencadenantes == null)
        {
            GetListasRestTask listasRest = new GetListasRestTask(ctx, 3);
            try {
                desencadenantes = listasRest.execute().get();
            } catch (InterruptedException e) {
                //TODO:codigo de exepcion
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return desencadenantes;
    }

    private List<ListaValor> intensidades;
    /***
     * Retorna todas las intensidades del dolor existentes
     * @param ctx Contexto de la aplicacion
     * @return
     */
    public List<ListaValor> getIntensidades(Context ctx){
        //Si ya fueron consultadas previamente no las consulta de nuevo
        if(intensidades == null)
        {
            GetListasRestTask listasRest = new GetListasRestTask(ctx, 2);
            try {
                intensidades = listasRest.execute().get();
            } catch (InterruptedException e) {
                //TODO:codigo de exepcion
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return intensidades;
    }
}
