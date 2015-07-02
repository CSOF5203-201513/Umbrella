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
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity("hola").build();
	}

	/**
	 * Permite agregar una nueva persona
	 * @return respuesta de la peticion
	 * @throws SystemException 
	 * @throws NotSupportedException 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add() throws NotSupportedException, SystemException {
		
		try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
			
		EpisodioMigrana e = new EpisodioMigrana();
              
        
        e.setEstado(1);
        e.setIdIntensidad(1);
        e.setIdlocalizacionDolor(1);
        e.setIdMedico(1);
        e.setIdPaciente(1);
        e.setRutaAudio("");  
		
        
        try {
        	
        	UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
        	transaction.begin();
            
        	//Prueba Insert
            //entityManager.persist(e);

            //Prueba Consult
        	//EpisodioMigrana prueba = entityManager.find(EpisodioMigrana.class, 1);
        	
            transaction.commit();
           
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e = null;
        } finally {
        	entityManager.clear();
        	entityManager.close();
        }
        
        
		

		JSONObject rta = new JSONObject();
		rta.put("success", "true");

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(rta.toJSONString()).build();
	}

}
