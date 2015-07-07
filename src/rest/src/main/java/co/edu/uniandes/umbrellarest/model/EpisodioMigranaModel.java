package co.edu.uniandes.umbrellarest.model;

import java.sql.Date;

public class EpisodioMigranaModel {
	
	int	id;
	Date fechaCreacion;
	int	idlocalizacionDolor;
	String	localizacionDolor;
	int	idIntensidad;
	String	intensidad;
	int	idPaciente;
	String	pacientenumeroIdentificacion;
	String	pacienteNombre;
	int	idMedico;
	String	medicoNumeroIdentificacion;
	String	medicoNombre;
	String	urlAudio;
	DesencadenanteEpisodioModel[] desencadenantes;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the idlocalizacionDolor
	 */
	public int getIdlocalizacionDolor() {
		return idlocalizacionDolor;
	}
	/**
	 * @param idlocalizacionDolor the idlocalizacionDolor to set
	 */
	public void setIdlocalizacionDolor(int idlocalizacionDolor) {
		this.idlocalizacionDolor = idlocalizacionDolor;
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
	 * @return the idIntensidad
	 */
	public int getIdIntensidad() {
		return idIntensidad;
	}
	/**
	 * @param idIntensidad the idIntensidad to set
	 */
	public void setIdIntensidad(int idIntensidad) {
		this.idIntensidad = idIntensidad;
	}
	/**
	 * @return the intensidad
	 */
	public String getIntensidad() {
		return intensidad;
	}
	/**
	 * @param intensidad the intensidad to set
	 */
	public void setIntensidad(String intensidad) {
		this.intensidad = intensidad;
	}
	/**
	 * @return the idPaciente
	 */
	public int getIdPaciente() {
		return idPaciente;
	}
	/**
	 * @param idPaciente the idPaciente to set
	 */
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	/**
	 * @return the pacientenumeroIdentificacion
	 */
	public String getPacientenumeroIdentificacion() {
		return pacientenumeroIdentificacion;
	}
	/**
	 * @param pacientenumeroIdentificacion the pacientenumeroIdentificacion to set
	 */
	public void setPacientenumeroIdentificacion(String pacientenumeroIdentificacion) {
		this.pacientenumeroIdentificacion = pacientenumeroIdentificacion;
	}
	/**
	 * @return the pacienteNombre
	 */
	public String getPacienteNombre() {
		return pacienteNombre;
	}
	/**
	 * @param pacienteNombre the pacienteNombre to set
	 */
	public void setPacienteNombre(String pacienteNombre) {
		this.pacienteNombre = pacienteNombre;
	}
	/**
	 * @return the idMedico
	 */
	public int getIdMedico() {
		return idMedico;
	}
	/**
	 * @param idMedico the idMedico to set
	 */
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	/**
	 * @return the medicoNumeroIdentificacion
	 */
	public String getMedicoNumeroIdentificacion() {
		return medicoNumeroIdentificacion;
	}
	/**
	 * @param medicoNumeroIdentificacion the medicoNumeroIdentificacion to set
	 */
	public void setMedicoNumeroIdentificacion(String medicoNumeroIdentificacion) {
		this.medicoNumeroIdentificacion = medicoNumeroIdentificacion;
	}
	/**
	 * @return the medicoNombre
	 */
	public String getMedicoNombre() {
		return medicoNombre;
	}
	/**
	 * @param medicoNombre the medicoNombre to set
	 */
	public void setMedicoNombre(String medicoNombre) {
		this.medicoNombre = medicoNombre;
	}
	/**
	 * @return the urlAudio
	 */
	public String getUrlAudio() {
		return urlAudio;
	}
	/**
	 * @param urlAudio the urlAudio to set
	 */
	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}
	/**
	 * @return the desencadenantes
	 */
	public DesencadenanteEpisodioModel[] getDesencadenantes() {
		return desencadenantes;
	}
	/**
	 * @param desencadenantes the desencadenantes to set
	 */
	public void setDesencadenantes(DesencadenanteEpisodioModel[] desencadenantes) {
		this.desencadenantes = desencadenantes;
	}

	
	
}
