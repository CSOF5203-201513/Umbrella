/**
 * 
 */
package co.edu.uniandes.umbrella.models;

/**
 * @author erica.prado
 *
 */
public class DesencadenanteEpisodioDTO {
	
	private int id;
	
	private int idEpisodioMigrana;
	
	private int idTipoDesencadenante;
	
	private String nombreTipoDesencadenante;
	
	private String descripcionTipoDesencadenante;

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
	 * @return the idEpisodioMigrana
	 */
	public int getIdEpisodioMigrana() {
		return idEpisodioMigrana;
	}

	/**
	 * @param idEpisodioMigrana the idEpisodioMigrana to set
	 */
	public void setIdEpisodioMigrana(int idEpisodioMigrana) {
		this.idEpisodioMigrana = idEpisodioMigrana;
	}

	/**
	 * @return the idTipoDesencadenante
	 */
	public int getIdTipoDesencadenante() {
		return idTipoDesencadenante;
	}

	/**
	 * @param idTipoDesencadenante the idTipoDesencadenante to set
	 */
	public void setIdTipoDesencadenante(int idTipoDesencadenante) {
		this.idTipoDesencadenante = idTipoDesencadenante;
	}

	/**
	 * @return the nombreTipoDesencadenante
	 */
	public String getNombreTipoDesencadenante() {
		return nombreTipoDesencadenante;
	}

	/**
	 * @param nombreTipoDesencadenante the nombreTipoDesencadenante to set
	 */
	public void setNombreTipoDesencadenante(String nombreTipoDesencadenante) {
		this.nombreTipoDesencadenante = nombreTipoDesencadenante;
	}

	/**
	 * @return the descripcionTipoDesencadenante
	 */
	public String getDescripcionTipoDesencadenante() {
		return descripcionTipoDesencadenante;
	}

	/**
	 * @param descripcionTipoDesencadenante the descripcionTipoDesencadenante to set
	 */
	public void setDescripcionTipoDesencadenante(
			String descripcionTipoDesencadenante) {
		this.descripcionTipoDesencadenante = descripcionTipoDesencadenante;
	}
	
	
	

}
