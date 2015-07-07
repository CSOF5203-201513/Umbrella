/**
 * 
 */
package co.edu.uniandes.ejb;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import co.edu.uniandes.negocio.Desencadenanteepisodio;
import co.edu.uniandes.negocio.EpisodioMigrana;

/**
 * @author Erica
 *
 */
public class EpisodioMigranaEjb {
	
private static EntityManagerFactory factory;
    
    protected EntityManager em;
    
    protected Properties pros = new Properties();
    
    public EpisodioMigranaEjb(){
    	
    	pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence.xml");
    	
    }
	
	public int Crear (EpisodioMigrana episodioMigrana){
		
		System.out.println("Creando episodio migraña");
		

		try {				     
		     
		     factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
		     em = factory.createEntityManager();		    
		     
		     em.getTransaction().begin();
		     em.persist(episodioMigrana);
		     //em.flush();
		     em.getTransaction().commit();
		     em.refresh(episodioMigrana);
		     
		     episodioMigrana.getId();
			
		} catch (Exception e) {
			throw e;
		}
		
		return 0;
	}
	




}
