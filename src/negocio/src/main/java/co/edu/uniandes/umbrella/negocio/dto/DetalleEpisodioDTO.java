package co.edu.uniandes.umbrella.negocio.dto;

import java.io.Serializable;
import java.util.List;

public class DetalleEpisodioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> catalizadores;
	
	private List<String> medicamentos;

	private List<String> sintomas;

	public List<String> getCatalizadores() {
		return catalizadores;
	}

	public void setCatalizadores(List<String> catalizadores) {
		this.catalizadores = catalizadores;
	}

	public List<String> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<String> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public List<String> getSintomas() {
		return sintomas;
	}

	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}

}
