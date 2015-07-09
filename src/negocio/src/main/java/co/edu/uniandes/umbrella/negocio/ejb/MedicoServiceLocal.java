package co.edu.uniandes.umbrella.negocio.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.negocio.dto.DetalleEpisodioDTO;
import co.edu.uniandes.umbrella.negocio.dto.EpisodiosDTO;

@Local
public interface MedicoServiceLocal {
	
	List<EpisodiosDTO> consultarPacientePorId(String nroIdentificacion);
	
	List<EpisodiosDTO> consultarPacientePeriodoTiempo(String nroIdentificacion, Date fechaInicio, Date fechaFin);
	
	DetalleEpisodioDTO consultarEpisodioPorId(long idEpisodio);

}
