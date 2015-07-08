package co.edu.uniandes.umbrella.negocio.ejb;

import java.util.Date;

import javax.ejb.Local;

@Local
public interface MedicoServiceLocal {
	
	void consultarPacientePorId(String nroIdentificacion);
	
	void consultarPacientePeriodoTiempo(String nroIdentificacion, Date fechaInicio, Date fechaFin);
	
	void consultarEpisodioPorId(long idEpisodio);

}
