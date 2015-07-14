package co.edu.uniandes.umbrella.negocio.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;

import co.edu.uniandes.negocio.DesencadenanteEpisodio;
import co.edu.uniandes.umbrella.negocio.dto.DetalleEpisodioDTO;
import co.edu.uniandes.umbrella.negocio.dto.EpisodiosDTO;

/**
 * Session Bean implementation class MedicoService
 */
@Stateless
public class MedicoService implements MedicoServiceLocal {

	private static EntityManagerFactory factory;

	protected EntityManager em;

	protected Properties pros = new Properties();

	public MedicoService() {

		pros.setProperty(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
				"META-INF/persistence.xml");
		pros.put(PersistenceUnitProperties.CLASSLOADER, this.getClass()
				.getClassLoader());
	}

	@SuppressWarnings("unchecked")
	public List<EpisodiosDTO> consultarPacientePorId(String nroIdentificacion) {

		System.out.println("consultando paciente a" + nroIdentificacion);
		factory = Persistence
				.createEntityManagerFactory("ControlMigrana", pros);
		em = factory.createEntityManager();

		Query q = em.createNamedQuery(
				"EpisodioMigrana.findByNumeroIdentificacion").setParameter(1,
				nroIdentificacion);

		List<Object[]> results = q.getResultList();
		System.out.println(results.size() + "r");

		List<EpisodiosDTO> episodios = new ArrayList<EpisodiosDTO>();
		EpisodiosDTO episodio;

		for (Object[] object : results) {

			episodio = new EpisodiosDTO();

			episodio.setIdEpisodio((int) object[0]);

//			int estado = 0;
//			if (object[1] != null) {
//
//				estado = (int) object[1];
//			}
			episodio.setEstado(7);
			episodio.setFechaCreacion((Date) object[2]);
			episodio.setIntensidad((String) object[3]);
			episodio.setLocalizacionDolor((String) object[4]);
			episodio.setNombrePaciente((String) object[5]);
			episodio.setIdentificacionPaciente((String) object[6]);
			episodio.setIdPaciente((int) object[7]);
			episodio.setMedico((String) object[8]);
			episodio.setIdMedico((int) object[9]);

			episodios.add(episodio);
		}

		return episodios;
	}

	@SuppressWarnings("unchecked")
	public List<EpisodiosDTO> consultarPacientePeriodoTiempo(
			String nroIdentificacion, Date fechaInicio, Date fechaFin) {

		System.out.println("consultando paciente b" + nroIdentificacion);
		factory = Persistence
				.createEntityManagerFactory("ControlMigrana", pros);
		em = factory.createEntityManager();

		Query q = em
				.createNamedQuery(
						"EpisodioMigrana.findByNumeroIdentificacionFechas")
				.setParameter(1, nroIdentificacion)
				.setParameter(2, fechaInicio).setParameter(3, fechaFin);

		List<Object[]> results = q.getResultList();
		System.out.println(results.size() + "r");

		List<EpisodiosDTO> episodios = new ArrayList<EpisodiosDTO>();
		EpisodiosDTO episodio;

		for (Object[] object : results) {

			episodio = new EpisodiosDTO();

			episodio.setIdEpisodio((int) object[0]);

//			int estado = 0;
//			if (object[1] != null) {
//
//				estado = (int) object[1];
//			}
			episodio.setEstado(7);
			episodio.setFechaCreacion((Date) object[2]);
			episodio.setIntensidad((String) object[3]);
			episodio.setLocalizacionDolor((String) object[4]);
			episodio.setNombrePaciente((String) object[5]);
			episodio.setIdentificacionPaciente((String) object[6]);
			episodio.setIdPaciente((int) object[7]);
			episodio.setMedico((String) object[8]);
			episodio.setIdMedico((int) object[9]);

			episodios.add(episodio);
		}

		System.out.println("paciente consultado " + nroIdentificacion
				+ fechaInicio + fechaFin);

		return episodios;
	}

	public DetalleEpisodioDTO consultarEpisodioPorId(long idEpisodio) {

		System.out.println("consultando episodio id");
		factory = Persistence
				.createEntityManagerFactory("ControlMigrana", pros);
		em = factory.createEntityManager();

		Query q = em.createNamedQuery(
				"DesencadenanteEpisodio.findByIdepisodiomigrana",
				DesencadenanteEpisodio.class).setParameter("idepisodiomigrana",
				idEpisodio);

		List<DesencadenanteEpisodio> results = q.getResultList();
		System.out.println(results.size() + " desencadenantes");

		DetalleEpisodioDTO detalleEpisodioDTO = new DetalleEpisodioDTO();
		List<String> catalizadores = new ArrayList<String>();
		List<String> sintomas = new ArrayList<String>();
		List<String> medicamentos = new ArrayList<String>();

		for (DesencadenanteEpisodio desencadenanteEpisodio : results) {

			if (desencadenanteEpisodio.getTipodesencadenante() == 7
					|| desencadenanteEpisodio.getTipodesencadenante() == 8
					|| desencadenanteEpisodio.getTipodesencadenante() == 9) {

				catalizadores.add(desencadenanteEpisodio.getDesencadenante());
				System.out.println(desencadenanteEpisodio.getDesencadenante());

			} else if (desencadenanteEpisodio.getTipodesencadenante() == 11) {

				medicamentos.add(desencadenanteEpisodio.getDesencadenante());
				System.out.println(desencadenanteEpisodio.getDesencadenante());

			} else if (desencadenanteEpisodio.getTipodesencadenante() == 10) {

				sintomas.add(desencadenanteEpisodio.getDesencadenante());
				System.out.println(desencadenanteEpisodio.getDesencadenante());
			}

		}

		detalleEpisodioDTO.setCatalizadores(catalizadores);
		detalleEpisodioDTO.setMedicamentos(medicamentos);
		detalleEpisodioDTO.setSintomas(sintomas);

		System.out.println("episodio consultado " + idEpisodio);

		return detalleEpisodioDTO;
	}

}
