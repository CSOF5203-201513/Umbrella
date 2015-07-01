/**
 * 
 */
package co.edu.uniandes.umbrella.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.NotNull;

/**
 * @author erica.prado
 *
 */
@Entity
@XmlRootElement
public class EpisodioMigrana implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@NotNull
	@Column(name = "fechaCreacion", updatable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@NotNull
    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.DATE)
	private Calendar fechaModificacion;

	
	private int estado;
	
	private int idlocalizacionDolor;
	
	private int idIntensidad;
	
	private int idPaciente;
	
	private int idMedico;
	
	private String rutaAudio;
	
	
	
	@PreUpdate
    private void updateTimestamp() {
        this.fechaModificacion = Calendar.getInstance();
    }

    @PrePersist
    private void creationTimestamp() {
        this.fechaCreacion = this.fechaModificacion = Calendar.getInstance();
    }
	
	

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
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}







	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}







	/**
	 * @return the fechaCreacion
	 */
	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}







	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Calendar fechaCreacion) {
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
	 * @return the rutaAudio
	 */
	public String getRutaAudio() {
		return rutaAudio;
	}







	/**
	 * @param rutaAudio the rutaAudio to set
	 */
	public void setRutaAudio(String rutaAudio) {
		this.rutaAudio = rutaAudio;
	}







	/**
	 * 
	 */
	public EpisodioMigrana() {
		// TODO Auto-generated constructor stub
	}

}
