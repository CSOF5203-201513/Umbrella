package co.edu.uniandes.umbrella.dto;

import java.util.Date;
import java.util.List;

public class EpisodiosDTO {
	
	private String idPaciente;
	
	private long idEpisodio;
	
	private Date fechaCreacion;
		
	private String localizacionDolor;
	
	private String estado;
	
	private String medico;
	
	private List<String> medicamentos;
	
	private List<String> catalizadores;
	
	private List<String> sintomas;

	/**
	 * @return the idPaciente
	 */
	public String getIdPaciente() {
		return idPaciente;
	}

	/**
	 * @param idPaciente the idPaciente to set
	 */
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	/**
	 * @return the idEpisodio
	 */
	public long getIdEpisodio() {
		return idEpisodio;
	}

	/**
	 * @param idEpisodio the idEpisodio to set
	 */
	public void setIdEpisodio(long idEpisodio) {
		this.idEpisodio = idEpisodio;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the localizacionDolor
	 */
	public String getLocalizacionDolor() {
		return localizacionDolor;
	}

	/**
	 * @param localizacionDolor the localizacionDolor to set
	 */
	public void setLocalizacionDolor(String localizacionDolor) {
		this.localizacionDolor = localizacionDolor;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the medico
	 */
	public String getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}

	/**
	 * @return the medicamentos
	 */
	public List<String> getMedicamentos() {
		return medicamentos;
	}

	/**
	 * @param medicamentos the medicamentos to set
	 */
	public void setMedicamentos(List<String> medicamentos) {
		this.medicamentos = medicamentos;
	}

	/**
	 * @return the catalizadores
	 */
	public List<String> getCatalizadores() {
		return catalizadores;
	}

	/**
	 * @param catalizadores the catalizadores to set
	 */
	public void setCatalizadores(List<String> catalizadores) {
		this.catalizadores = catalizadores;
	}

	/**
	 * @return the sintomas
	 */
	public List<String> getSintomas() {
		return sintomas;
	}

	/**
	 * @param sintomas the sintomas to set
	 */
	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

}
