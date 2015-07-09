package co.edu.uniandes.umbrella.negocio.dto;

import java.io.Serializable;
import java.util.List;

public class DetalleEpisodioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> catalizadores;

	public List<String> getCatalizadores() {
		return catalizadores;
	}

	public void setCatalizadores(List<String> catalizadores) {
		this.catalizadores = catalizadores;
	}

}
