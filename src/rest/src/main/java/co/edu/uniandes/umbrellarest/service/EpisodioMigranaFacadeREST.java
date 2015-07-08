package co.edu.uniandes.umbrellarest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import co.edu.uniandes.negocio.DesencadenanteEpisodio;
import co.edu.uniandes.negocio.EpisodioMigrana;
import co.edu.uniandes.umbrellarest.model.DesencadenanteEpisodioModel;
import co.edu.uniandes.umbrellarest.model.EpisodioMigranaModel;

/**
 *
 * @author gremly
 */
@Stateless
@Path("episodios")
public class EpisodioMigranaFacadeREST  {
    @PersistenceContext(unitName = "ControlMigrana")
    private EntityManager em;
  

    public EpisodioMigranaFacadeREST() {
        //super(EpisodioMigrana.class);
    }
    
    
  @POST
  @Consumes({"application/xml", "application/json"})
  public Response create(EpisodioMigranaModel model) {
	  
	  JSONObject rta = new JSONObject();
  
	  EpisodioMigrana entity = EpisodioMigranaModel.GetEntity(model);
	  getEntityManager().persist(entity);
	  
	  if(entity.getId() > 0)
	  {		  
		  
		  if(model.getDesencadenantes() != null && model.getDesencadenantes().length > 0)
		  {
			  for (DesencadenanteEpisodioModel desencadenante : model.getDesencadenantes()) {
					DesencadenanteEpisodio entityDes = DesencadenanteEpisodioModel.GetEntity(desencadenante);
					entityDes.setIdepisodiomigrana(entity.getId());
				    getEntityManager().persist(entityDes);				  
			  }  
			  
		  }
		  
		  model.setId(entity.getId());
		  
		  rta.put("a", model);
		  
		  return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();
	  }
	  else
	  {
		  rta.put("success", "false");
		  return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();		  
	  }
	  
	  
	  
  }
  
  
	protected EntityManager getEntityManager() {
	    return em;
	}


//    @POST
//    @Override
//    @Consumes({"application/xml", "application/json"})
//    public void create(EpisodioMigrana entity) {
//        super.create(entity);
//    }
//
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Response edit(@PathParam("id") Integer id, EpisodioMigranaModel model) {
    	JSONObject rta = new JSONObject();
    	model.setId(id);
    	  
  	  EpisodioMigrana entity = EpisodioMigranaModel.GetEntity(model);
  	  getEntityManager().merge(entity);
  	  
  	  if(entity.getId() > 0)
  	  {		  
  		  
  		  if(model.getDesencadenantes() != null && model.getDesencadenantes().length > 0)
  		  {
  			  for (DesencadenanteEpisodioModel desencadenante : model.getDesencadenantes()) {
  					DesencadenanteEpisodio entityDes = DesencadenanteEpisodioModel.GetEntity(desencadenante);
  				    getEntityManager().merge(entityDes);				  
  			  }  
  			  
  		  }
  		  
  		  model.setId(entity.getId());
  		  
  		  rta.put("a", model);
  		  
  		  return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();
  	  }
  	  else
  	  {
  		  rta.put("success", "false");
  		  return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta.toJSONString()).build();		  
  	  } 
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public EpisodioMigranaModel find(@PathParam("id") Integer id) {
        
    	//EpisodioMigrana entity = new En
    	UsuarioConsultas consultasUsuarios = new UsuarioConsultas();
    	DesencadenanteEpisodioConsultas consultasDesencadenantes = new DesencadenanteEpisodioConsultas();
    	EpisodioMigrana episodio = getEntityManager().find(EpisodioMigrana.class, id);
    	return EpisodioMigranaModel.GetModel(episodio, consultasUsuarios.find(episodio.getIdmedico()), consultasUsuarios.find(episodio.getIdpaciente()), consultasDesencadenantes.getByEpisodioId(episodio.getId()));
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<EpisodioMigranaModel> findAll() {
    	javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(EpisodioMigrana.class));
        List<EpisodioMigrana> entities = getEntityManager().createQuery(cq).getResultList();
        List<EpisodioMigranaModel> models = new  ArrayList<EpisodioMigranaModel>(); 
        for(EpisodioMigrana episodio : entities)
        {
        	UsuarioConsultas consultasUsuarios = new UsuarioConsultas();
        	DesencadenanteEpisodioConsultas consultasDesencadenantes = new DesencadenanteEpisodioConsultas();
        	EpisodioMigranaModel episodioModel = EpisodioMigranaModel.GetModel(episodio, consultasUsuarios.find(episodio.getIdmedico()), consultasUsuarios.find(episodio.getIdpaciente()), consultasDesencadenantes.getByEpisodioId(episodio.getId()));
        	System.out.println("---------------------------------------->Mostrar mensaje");
        	models.add(episodioModel);
        }
        return models;
    }
    
//    @GET
//    @Path("count")
//    @Produces("text/plain")
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
    
}