/**
 * 
 */
package co.edu.uniandes.umbrellarest.service;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import co.edu.uniandes.negocio.Catalizador;
import co.edu.uniandes.negocio.DesencadenanteEpisodio;

/**
 * @author Erica
 *
 */
public class CatalizadorConsultas extends AbstractFacade<Catalizador>{
	
	@PersistenceContext(unitName = "ControlMigrana")
    private EntityManager em;

	private static EntityManagerFactory factory;
	
	/**
	 * 
	 */
	public CatalizadorConsultas() {
		super(Catalizador.class);
		    	
		    	Properties pros = new Properties();
		        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
		                "META-INF/persistence.xml");
		
		        factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
		        em = factory.createEntityManager();
	}
	
	
	public List<Catalizador> getByNombreTipo(int tipo, String nombre)
    {
    	TypedQuery<Catalizador> query =
    	em.createNamedQuery("Catalizador.findByNombreTipo", Catalizador.class);
    	query.setParameter("nombre", nombre);
    	query.setParameter("tipo", tipo);
    	return query.getResultList();
    }
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
