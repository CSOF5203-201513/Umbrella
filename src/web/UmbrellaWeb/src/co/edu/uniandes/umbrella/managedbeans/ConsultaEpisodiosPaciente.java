package co.edu.uniandes.umbrella.managedbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Alejandra Chica
 *
 */
@ManagedBean
@RequestScoped
public class ConsultaEpisodiosPaciente {

	

	private String nroIdentificacion;
	
	private Date fechaInicio;

	private Date fechaFin;
	
	private boolean mostrarResultado;


	public String consultarEpisodiosPaciente() {

		

//		FacesContext context = FacesContext.getCurrentInstance();
//		context.addMessage(
//				null,
//				new FacesMessage(codigoRespuesta.getTipoMensaje(),
//						codigoRespuesta.getMensaje(), ""));
		
		mostrarResultado = true;

		return "";
	}

	public String getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the mostrarResultado
	 */
	public boolean isMostrarResultado() {
		return mostrarResultado;
	}

	/**
	 * @param mostrarResultado the mostrarResultado to set
	 */
	public void setMostrarResultado(boolean mostrarResultado) {
		this.mostrarResultado = mostrarResultado;
	}

}
