package co.edu.uniandes.umbrellarest.service;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

import org.eclipse.persistence.config.PersistenceUnitProperties;

import co.edu.uniandes.negocio.EpisodioMigrana;
import co.edu.uniandes.negocio.Usuario;

public class UsuarioConsultas extends AbstractFacade<Usuario> {

	 @PersistenceContext(unitName = "ControlMigrana")
	    private EntityManager em;
	 	private static EntityManagerFactory factory;

	    public UsuarioConsultas() {
	        super(Usuario.class);
	        
	    	Properties pros = new Properties();
	        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
	                "META-INF/persistence.xml");

	        factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
	        em = factory.createEntityManager();
	    }
	    
	    
	    public void create(Usuario entity) {
	        super.create(entity);
	    }

	    
	    public void edit(Integer id, Usuario entity) {
	        super.edit(entity);
	    }

	    
	    public void remove(Integer id) {
	        super.remove(super.find(id));
	    }

	    
	    public Usuario find(Integer id) {
	        return super.find(id);
	    }

	    
	    public List<Usuario> findAll() {
	        return super.findAll();
	    }

	    
	    public Usuario getByCedula(String cedula)
	    {
	    	TypedQuery<Usuario> query =
	    	em.createNamedQuery("Usuario.findByNumeroidentificacion", Usuario.class);
	    	query.setParameter("numeroidentificacion", cedula);
	    	return query.getSingleResult();
	    }
	    
	    public List<EpisodioMigrana> getEpisodiosByCedula(String cedula)
	    {
	    	Usuario usuario = getByCedula(cedula);
	    	TypedQuery<EpisodioMigrana> query =
	    	em.createNamedQuery("EpisodioMigrana.findByIdpaciente", EpisodioMigrana.class);
	    	query.setParameter("idpaciente", usuario.getId()); 	
	    	return query.getResultList();
	    }
	    
	    public List<Usuario> findRange(Integer from, Integer to) {
	        return super.findRange(new int[]{from, to});
	    }

	    
	    public String countREST() {
	        return String.valueOf(super.count());
	    }

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }

	
}
