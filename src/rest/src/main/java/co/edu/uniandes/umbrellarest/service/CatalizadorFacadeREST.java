/**
 * 
 */
package co.edu.uniandes.umbrellarest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import co.edu.uniandes.negocio.Catalizador;
import co.edu.uniandes.negocio.DesencadenanteEpisodio;

/**
 * @author Erica
 *
 */

@Stateless
@Path("catalizadores")
public class CatalizadorFacadeREST extends AbstractFacade<Catalizador>{
	
	@PersistenceContext(unitName = "ControlMigrana")
    private EntityManager em;
	
	
	public CatalizadorFacadeREST() {
        super(Catalizador.class);
    }


	
	
	@GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Catalizador> findAll() {
        return super.findAll();
    }
	
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public List<Catalizador> find(@PathParam("id") Integer id) {
		
		DesencadenanteEpisodioConsultas consultasDesencadenantes = new DesencadenanteEpisodioConsultas();	
		List<DesencadenanteEpisodio> listaDesencadenantes = consultasDesencadenantes.getByEpisodioId(id);
		
		CatalizadorConsultas catalizador = new CatalizadorConsultas();
		
		List<Catalizador> catalizadores = new ArrayList<Catalizador>();
		
		
		for (DesencadenanteEpisodio desencadenanteEpisodio : listaDesencadenantes) {
			
			String[] des = desencadenanteEpisodio.getDesencadenante().split(",");
			
			for (String nombreDes : des) {
								
				List<Catalizador> lista = catalizador.getByNombreTipo(desencadenanteEpisodio.getTipodesencadenante(), nombreDes.toUpperCase().trim());				
				catalizadores.addAll(lista);
								
			}			
		}
		
		
		return catalizadores;
	}
	
	
	
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
}
