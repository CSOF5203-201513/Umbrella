/**
 * 
 */
package co.edu.uniandes.umbrellarest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import co.edu.uniandes.negocio.DesencadenanteEpisodio;
import co.edu.uniandes.negocio.EpisodioMigrana;
import co.edu.uniandes.negocio.Usuario;
import co.edu.uniandes.umbrellarest.model.EpisodioMigranaModel;

/**
 * @author Erica
 *
 */

@Stateless
@Path("usuarios")
public class UsuarioFacadeREST extends AbstractFacade<Usuario>{
	
	 @PersistenceContext(unitName = "ControlMigrana")
	    private EntityManager em;

	    public UsuarioFacadeREST() {
	        super(Usuario.class);
	    }
	    
	    @POST
	    @Override
	    @Consumes({"application/xml", "application/json"})
	    public void create(Usuario entity) {
	        super.create(entity);
	    }

	    @PUT
	    @Path("{id}")
	    @Consumes({"application/xml", "application/json"})
	    public void edit(@PathParam("id") Integer id, Usuario entity) {
	        super.edit(entity);
	    }

	    @DELETE
	    @Path("{id}")
	    public void remove(@PathParam("id") Integer id) {
	        super.remove(super.find(id));
	    }
	    
	    @GET
	    @Path("{cedula}/episodios")
	    @Produces({"application/xml", "application/json"})
	    public List<EpisodioMigranaModel> getEpisodios(@PathParam("cedula") String cedula)
	    {
	    	UsuarioConsultas usuariosConsultas = new UsuarioConsultas();
	    	List<EpisodioMigrana> entities = usuariosConsultas.getEpisodiosByCedula(cedula);
	    	
	    	List<EpisodioMigranaModel> models = new  ArrayList<EpisodioMigranaModel>(); 
	        for(EpisodioMigrana episodio : entities)
	        {
	        	UsuarioConsultas consultasUsuarios = new UsuarioConsultas();
	        	DesencadenanteEpisodioConsultas consultasDesencadenantes = new DesencadenanteEpisodioConsultas();
	        	EpisodioMigranaModel episodioModel = EpisodioMigranaModel.GetModel(episodio, consultasUsuarios.find(episodio.getIdmedico()), consultasUsuarios.find(episodio.getIdpaciente()), consultasDesencadenantes.getByEpisodioId(episodio.getId()));
	        	System.out.println("---------------------------------------->Mostrar mensaje");
	        	models.add(episodioModel);
	        }
	        return models;
	    }

	    @GET
	    @Path("{id}")
	    @Produces({"application/xml", "application/json"})
	    public Usuario find(@PathParam("id") Integer id) {
	        return super.find(id);
	    }

	    @GET
	    @Override
	    @Produces({"application/xml", "application/json"})
	    public List<Usuario> findAll() {
	        return super.findAll();
	    }

	    @GET
	    @Path("{from}/{to}")
	    @Produces({"application/xml", "application/json"})
	    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
	        return super.findRange(new int[]{from, to});
	    }

	    @GET
	    @Path("count")
	    @Produces("text/plain")
	    public String countREST() {
	        return String.valueOf(super.count());
	    }

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	

}
