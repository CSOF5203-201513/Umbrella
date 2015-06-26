/**
 * 
 */
package co.edu.uniandes.umbrella.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

/**
 * Clase para probar WS Restful
 * @author Alejandra Chica
 *
 */
@Path("/servicios")
@Produces(MediaType.APPLICATION_JSON)
public class Servicio {

	/**
	 * Permite obtener la lista completa de personas
	 * @return respuesta de la peticion
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {

		List<String> personas = new ArrayList<String>();
		personas.add("Persona 1, id 1");
		personas.add("Persona 2, id 2");
		personas.add("Persona 3, id 3");
		personas.add("Persona 4, id 4");
		personas.add("Persona 5, id 5");

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(personas).build();
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
