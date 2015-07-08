package co.edu.uniandes.umbrellarest.service;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import co.edu.uniandes.negocio.DesencadenanteEpisodio;
import co.edu.uniandes.negocio.Usuario;

public class DesencadenanteEpisodioConsultas extends AbstractFacade<DesencadenanteEpisodio> {
	@PersistenceContext(unitName = "ControlMigrana")
    private EntityManager em;

	private static EntityManagerFactory factory;
	
    public DesencadenanteEpisodioConsultas() {

        
    	super(DesencadenanteEpisodio.class);
    	
    	Properties pros = new Properties();
        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
                "META-INF/persistence.xml");

        factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
        em = factory.createEntityManager();
        
    }
    
    
    public void create(DesencadenanteEpisodio entity) {
        super.create(entity);
    }

    
    public void edit(Integer id, DesencadenanteEpisodio entity) {
        super.edit(entity);
    }
    
    public List<DesencadenanteEpisodio> getByEpisodioId(int idEpisodio)
    {
    	TypedQuery<DesencadenanteEpisodio> query =
    	em.createNamedQuery("DesencadenanteEpisodio.findByIdepisodiomigrana", DesencadenanteEpisodio.class);
    	query.setParameter("idepisodiomigrana", idEpisodio);
    	return query.getResultList();
    }

    
    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    
    public DesencadenanteEpisodio find(Integer id) {
        return super.find(id);
    }

    
    public List<DesencadenanteEpisodio> findAll() {
        return super.findAll();
    }

    
    public List<DesencadenanteEpisodio> findRange(Integer from, Integer to) {
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
