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

import co.edu.uniandes.negocio.DesencadenanteEpisodio;

/**
 * @author Erica
 *
 */
public class DesencadenanteEpisodioEjb {

	private static EntityManagerFactory factory;
	
	protected EntityManager em;

	protected Properties pros = new Properties();

	public DesencadenanteEpisodioEjb(){

		pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence.xml");

	}

	public int Crear (List<DesencadenanteEpisodio> listaDesencadenantes){

		System.out.println("Creando desencadenates episodio migraña");


		try {				     

			factory = Persistence.createEntityManagerFactory("ControlMigrana", pros);
			em = factory.createEntityManager();		    

			em.getTransaction().begin();

			for (DesencadenanteEpisodio desencadenanteepisodio : listaDesencadenantes) {
				 em.persist(desencadenanteepisodio);
		         em.flush();
		         em.clear();
			}
								
			em.getTransaction().commit();
			
		} catch (Exception e) {
			throw e;
		}

		return 0;
	}

}
