package co.edu.uniandes.umbrella.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.edu.uniandes.umbrella.negocio.dto.DetalleEpisodioDTO;
import co.edu.uniandes.umbrella.negocio.dto.EpisodiosDTO;
import co.edu.uniandes.umbrella.negocio.ejb.MedicoServiceLocal;

/**
 * @author Alejandra Chica
 *
 */
@ManagedBean
@ViewScoped
public class ConsultaEpisodiosPaciente {

	/**
	 * Campos busqueda
	 */

	private String nroIdentificacion;

	private Date fechaInicio;

	private Date fechaFin;

	private boolean mostrarResultado;

	private boolean mostrarDetalle;

	/**
	 * Campos tabla resultados
	 */
	private List<EpisodiosDTO> episodios;

	private EpisodiosDTO episodio;

	private Integer index;

	/**
	 * Campos detalle
	 */

	@EJB
	private MedicoServiceLocal medicoService;

	public ConsultaEpisodiosPaciente() {

	}

	public String consultarEpisodiosPaciente() {
		
		mostrarResultado = false;
		mostrarDetalle = false;

		episodios = new ArrayList<EpisodiosDTO>();

		if (fechaInicio != null && fechaFin != null) {

			episodios = medicoService.consultarPacientePeriodoTiempo(nroIdentificacion, fechaInicio, fechaFin);

		} else {

			episodios = medicoService.consultarPacientePorId(nroIdentificacion);
		}

		mostrarResultado = true;

		return "";
	}

	public String verDetalle() {

		episodio = episodios.get(index);
		DetalleEpisodioDTO detalle = medicoService
				.consultarEpisodioPorId(episodio.getIdEpisodio());

		episodio.setCatalizadores(detalle.getCatalizadores());
		mostrarDetalle = true;

		return "";
	}

	public String limpiar() {

		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();

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
	 * @param fechaInicio
	 *            the fechaInicio to set
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
	 * @param fechaFin
	 *            the fechaFin to set
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
	 * @param mostrarResultado
	 *            the mostrarResultado to set
	 */
	public void setMostrarResultado(boolean mostrarResultado) {
		this.mostrarResultado = mostrarResultado;
	}

	/**
	 * @return the episodios
	 */
	public List<EpisodiosDTO> getEpisodios() {
		return episodios;
	}

	/**
	 * @param episodios
	 *            the episodios to set
	 */
	public void setEpisodios(List<EpisodiosDTO> episodios) {
		this.episodios = episodios;
	}

	/**
	 * @return the episodio
	 */
	public EpisodiosDTO getEpisodio() {
		return episodio;
	}

	/**
	 * @param episodio
	 *            the episodio to set
	 */
	public void setEpisodio(EpisodiosDTO episodio) {
		this.episodio = episodio;
	}

	/**
	 * @return the mostrarDetalle
	 */
	public boolean isMostrarDetalle() {
		return mostrarDetalle;
	}

	/**
	 * @param mostrarDetalle
	 *            the mostrarDetalle to set
	 */
	public void setMostrarDetalle(boolean mostrarDetalle) {
		this.mostrarDetalle = mostrarDetalle;
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

}
