/**
 * 
 */
package co.edu.uniandes.umbrella.services;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import co.edu.uniandes.umbrella.entity.EpisodioMigrana;
import co.edu.uniandes.umbrella.entity.PersistenceManager;
import co.edu.uniandes.umbrella.models.EpisodioMigranaDTO;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import org.eclipse.persistence.exceptions.TransactionException;

/**
 * @author erica.prado
 *
 */

@Path("/episodios")
@Produces(MediaType.APPLICATION_JSON)
public class EpisodioMigranaService {

	
    @PersistenceContext(unitName = "ControlMigrana")
    EntityManager entityManager;
	
	
	/**
	 * Permite obtener la lista completa de personas
	 * @return respuesta de la peticion
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
            EpisodioMigrana em = new EpisodioMigrana();
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(em).build();
	}

	/**
	 * Permite agregar una nueva persona
	 * @return respuesta de la peticion
	 * @throws SystemException 
	 * @throws NotSupportedException 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(EpisodioMigranaDTO episodio) {

            int code;
            
            try {
                entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }

            JSONObject rta = new JSONObject();
            EpisodioMigrana e = new EpisodioMigrana();

            e.setEstado(episodio.getEstado());
            e.setIdIntensidad(episodio.getIdIntensidad());
            e.setIdlocalizacionDolor(episodio.getIdlocalizacionDolor());
            e.setIdMedico(episodio.getIdMedico());
            e.setIdPaciente(1);
            e.setRutaAudio("");

            try {
                UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
                transaction.begin();
                entityManager.persist(e);
                transaction.commit();
                rta.put("Episodio", e.getId());
                rta.put("success", "true");
                code = 200;
            } catch (Throwable t) {
                t.printStackTrace();
                rta.put("Error", "500 Internal server error.");
                code = 500;
                
            }
            
            
            return Response.status(code).header("Access-Control-Allow-Origin", "*")
                    .entity(rta.toJSONString()).build();
        }

}
