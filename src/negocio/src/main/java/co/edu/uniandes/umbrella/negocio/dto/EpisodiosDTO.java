package co.edu.uniandes.umbrella.negocio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EpisodiosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPaciente;

	private long idEpisodio;

	private long idMedico;

	private Date fechaCreacion;

	private String localizacionDolor;

	private int estado;

	private String medico;
	
	private String intensidad;

	private String nombrePaciente;

	private String identificacionPaciente;

	private List<String> medicamentos;

	private List<String> catalizadores;

	private List<String> sintomas;



	/**
	 * @return the idEpisodio
	 */
	public long getIdEpisodio() {
		return idEpisodio;
	}

	/**
	 * @param idEpisodio
	 *            the idEpisodio to set
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
	 * @param fechaCreacion
	 *            the fechaCreacion to set
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
	 * @param localizacionDolor
	 *            the localizacionDolor to set
	 */
	public void setLocalizacionDolor(String localizacionDolor) {
		this.localizacionDolor = localizacionDolor;
	}

	/**
	 * @return the medico
	 */
	public String getMedico() {
		return medico;
	}

	/**
	 * @param medico
	 *            the medico to set
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
	 * @param medicamentos
	 *            the medicamentos to set
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
	 * @param catalizadores
	 *            the catalizadores to set
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
	 * @param sintomas
	 *            the sintomas to set
	 */
	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public String getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(String intensidad) {
		this.intensidad = intensidad;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getIdentificacionPaciente() {
		return identificacionPaciente;
	}

	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}


}
