/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gremly
 */
public class EpisodioMigranaIT {

    private static EntityManagerFactory factory;

    protected EntityManager em;

    public EpisodioMigranaIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Insertando datos iniciales para la prueba
     */
    @Before
    public void setUp() {
        System.out.println("Creando episodio migraña");

        // Usando presistence alternatico tipo RESOURCE_LOCAL para pruebas.
        Properties pros = new Properties();
        pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
                "META-INF/test-persistence.xml");

        factory = Persistence.createEntityManagerFactory("PruebasMigrana", pros);
        em = factory.createEntityManager();

        EpisodioMigrana epmi = new EpisodioMigrana();
        epmi.setEstado(3);

        em.getTransaction().begin();
        em.persist(epmi);
        em.getTransaction().commit();
 
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class EpisodioMigrana.
     */
    @Test
    public void testGetId() {
        EpisodioMigrana epmi;
        
        em = factory.createEntityManager();
        em.getTransaction().begin();
        epmi = em.find(EpisodioMigrana.class, 1);
        em.getTransaction().commit();
         
        Integer result = 1;
        Integer id = epmi.getId();
        assertEquals(result, id);
    }
    
        /**
     * Test of getId method, of class EpisodioMigrana.
     */
    @Test
    public void testGetFechaModificacion() {
        EpisodioMigrana epmi;
        
        em = factory.createEntityManager();
        em.getTransaction().begin();
        epmi = em.find(EpisodioMigrana.class, 1);
        epmi.setRutaaudio("Ruta de prueba");
        Calendar calendar = Calendar.getInstance();
        Date fEsperada = calendar.getTime();
        em.getTransaction().commit();
 
        Date fModificaion = epmi.getFechamodificacion();
        assertEquals(fModificaion.getDate(), fEsperada.getDate());
    }
}