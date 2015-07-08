package co.edu.uniandes.umbrella.negocio.ejb;

import java.util.Date;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MedicoService
 */
@Stateless
public class MedicoService implements MedicoServiceLocal {

	public void consultarPacientePorId(String nroIdentificacion) {

		System.out.println("paciente consultado" + nroIdentificacion);
	}

	public void consultarPacientePeriodoTiempo(String nroIdentificacion,
			Date fechaInicio, Date fechaFin) {

		System.out.println("paciente consultado " + nroIdentificacion
				+ fechaInicio + fechaFin);
	}

	public void consultarEpisodioPorId(long idEpisodio) {

		System.out.println("episodio consultado " + idEpisodio);
	}

}
