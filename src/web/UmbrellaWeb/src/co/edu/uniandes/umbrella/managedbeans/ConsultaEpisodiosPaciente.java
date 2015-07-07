package co.edu.uniandes.umbrella.managedbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.edu.uniandes.umbrella.dto.EpisodiosDTO;

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

	// @ManagedProperty(value="#{param.index}")
	private Integer index;

	/**
	 * Campos detalle
	 */

	// @EJB
	// private MedicoServiceRemote medicoService;

	public ConsultaEpisodiosPaciente() {

	}

	public String consultarEpisodiosPaciente() {

		configurarEpisodios();

		mostrarResultado = true;

		return "";
	}

	private void configurarEpisodios() {

		List<String> medicamentos1 = new ArrayList<String>();
		medicamentos1.add("medicamento 1");
		medicamentos1.add("medicamento 2");
		medicamentos1.add("medicamento 3");

		List<String> catalizadores1 = new ArrayList<String>();
		catalizadores1.add("catalizador 1");
		catalizadores1.add("catalizador 2");
		catalizadores1.add("catalizador 3");

		List<String> sintomas1 = new ArrayList<String>();
		sintomas1.add("sintoma 1");
		sintomas1.add("sintoma 2");
		sintomas1.add("sintoma 3");

		EpisodiosDTO episodiosDTO1 = new EpisodiosDTO();
		episodiosDTO1.setIdEpisodio(1);
		episodiosDTO1.setIdPaciente("1");
		episodiosDTO1.setIdEpisodio(1);
		episodiosDTO1.setFechaCreacion(Calendar.getInstance().getTime());
		episodiosDTO1.setLocalizacionDolor("frontal");
		episodiosDTO1.setEstado("inicial");
		episodiosDTO1.setMedico("med 1");
		episodiosDTO1.setMedicamentos(medicamentos1);
		episodiosDTO1.setCatalizadores(catalizadores1);
		episodiosDTO1.setSintomas(sintomas1);

		List<String> medicamentos2 = new ArrayList<String>();
		medicamentos2.add("medicamento 4");
		medicamentos2.add("medicamento 5");
		medicamentos2.add("medicamento 6");

		List<String> catalizadores2 = new ArrayList<String>();
		catalizadores2.add("catalizador 4");
		catalizadores2.add("catalizador 5");
		catalizadores2.add("catalizador 6");

		List<String> sintomas2 = new ArrayList<String>();
		sintomas2.add("sintoma 4");
		sintomas2.add("sintoma 5");
		sintomas2.add("sintoma 6");

		EpisodiosDTO episodiosDTO2 = new EpisodiosDTO();
		episodiosDTO2.setIdEpisodio(2);
		episodiosDTO2.setIdPaciente("2");
		episodiosDTO2.setIdEpisodio(2);
		episodiosDTO2.setFechaCreacion(Calendar.getInstance().getTime());
		episodiosDTO2.setLocalizacionDolor("frontal");
		episodiosDTO2.setEstado("inicial 2");
		episodiosDTO2.setMedico("med 2");
		episodiosDTO2.setMedicamentos(medicamentos2);
		episodiosDTO2.setCatalizadores(catalizadores2);
		episodiosDTO2.setSintomas(sintomas2);

		episodios = new ArrayList<EpisodiosDTO>();
		episodios.add(episodiosDTO1);
		episodios.add(episodiosDTO2);
	}

	public String verDetalle() {

		episodio = episodios.get(index);
		mostrarResultado = true;
		mostrarDetalle = true;
		
		return "";
	}
	
	public String limpiar() {

		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
//		remove("consultaEpisodiosPaciente");
		
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
