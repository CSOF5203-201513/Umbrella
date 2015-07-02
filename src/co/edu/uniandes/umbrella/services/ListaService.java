/**
 * 
 */
package co.edu.uniandes.umbrella.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;


/**
 * @author erica.prado
 *
 */

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class ListaService {
	
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
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response add() {

		JSONObject rta = new JSONObject();
		rta.put("success", "true");

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(rta.toJSONString()).build();
	}


}
