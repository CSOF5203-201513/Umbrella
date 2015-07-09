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
import co.edu.uniandes.negocio.ListaValor;

/**
 * @author Erica
 *
 */
public class ListaValorConsultas extends AbstractFacade<ListaValor>{

	@PersistenceContext(unitName = "ControlMigrana")
    private EntityManager em;

	private static EntityManagerFactory factory;
	
	/**
	 * 
	 */
	public ListaValorConsultas() {
		super(ListaValor.class);
    	
    	Properties pros = new Properties();
        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
                "META-INF/persistence.xml");

        factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
        em = factory.createEntityManager();
	}
	
	
	public ListaValor getById(int id)
    {
    	TypedQuery<ListaValor> query =
    	em.createNamedQuery("ListaValor.findById", ListaValor.class);
    	query.setParameter("id", id);    	
    	return query.getSingleResult();
    }
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
