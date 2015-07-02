/**
 * 
 */
package co.edu.uniandes.umbrella.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import co.edu.uniandes.umbrella.entity.EpisodioMigrana;

/**
 * @author erica.prado
 *
 */

@Path("/episodios")
@Produces(MediaType.APPLICATION_JSON)
public class EpisodioMigranaService {

	
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
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add() {

		JSONObject rta = new JSONObject();
		rta.put("success", "true");
                EpisodioMigrana em = new EpisodioMigrana();
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(rta.toJSONString()).build();
	}

}
