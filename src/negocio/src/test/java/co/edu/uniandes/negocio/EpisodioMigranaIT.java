/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.negocio;

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
    
    @Before
    public void setUp() {
        System.out.println("Creando episodio migraña");
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
        em.refresh(epmi);
           

    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setId method, of class EpisodioMigrana.
     */
    @Test
    public void testSetId() {

    }


    /**
     * Test of getId method, of class EpisodioMigrana.
     */
    @Test
    public void testGetId() {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        EpisodioMigrana epmi;
        epmi = em.find(EpisodioMigrana.class, 1);
        em.getTransaction().commit();
        em.refresh(epmi);
        Integer result = 1;
        Integer id = epmi.getId();
        assertEquals(result, id);
    
    }
}
