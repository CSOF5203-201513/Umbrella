/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.umbrellarest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author gremly
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(co.edu.uniandes.umbrellarest.service.CatalizadorFacadeREST.class);
//        resources.add(co.edu.uniandes.umbrellarest.service.DesencadenanteEpisodioFacadeREST.class);
       
        resources.add(co.edu.uniandes.umbrellarest.service.EpisodioMigranaFacadeREST.class);
        resources.add(co.edu.uniandes.umbrellarest.service.ListaFacadeREST.class);
//        resources.add(co.edu.uniandes.umbrellarest.service.ListaValorFacadeREST.class);
//        resources.add(co.edu.uniandes.umbrellarest.service.UsuarioFacadeREST.class);
    }
    
}
