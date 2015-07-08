/**
 * 
 */
package co.edu.uniandes.umbrellarest.service;

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
import co.edu.uniandes.negocio.Lista;
import co.edu.uniandes.negocio.ListaValor;

/**
 * @author Erica
 *
 */

@Stateless
@Path("listas")
public class ListaFacadeREST extends AbstractFacade<Lista>{
	
	
	 @PersistenceContext(unitName = "ControlMigrana")
	    private EntityManager em;

	    public ListaFacadeREST() {
	        super(Lista.class);
	    }
	    
	    @POST
	    @Override
	    @Consumes({"application/xml", "application/json"})
	    public void create(Lista entity) {
	        super.create(entity);
	    }

	    @PUT
	    @Path("{id}")
	    @Consumes({"application/xml", "application/json"})
	    public void edit(@PathParam("id") Integer id, Lista entity) {
	        super.edit(entity);
	    }

	    @DELETE
	    @Path("{id}")
	    public void remove(@PathParam("id") Integer id) {
	        super.remove(super.find(id));
	    }

	    
	    public Lista find(@PathParam("id") Integer id) {
	        return super.find(id);
	    }
	    
	    @GET
	    @Path("{id}")
	    @Produces({"application/xml", "application/json"})
	    public List<ListaValor> findByLista(@PathParam("id") Integer id)
	    {
	    	TypedQuery<ListaValor> query = getEntityManager().createNamedQuery("ListaValor.findByIdlista", ListaValor.class);
	    	query.setParameter("idlista", id);
	    	return query.getResultList();
	    }

	    @GET
	    @Override
	    @Produces({"application/xml", "application/json"})
	    public List<Lista> findAll() {
	        return super.findAll();
	    }

	    @GET
	    @Path("{from}/{to}")
	    @Produces({"application/xml", "application/json"})
	    public List<Lista> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
