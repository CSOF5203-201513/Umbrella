package co.edu.uniandes.umbrellarest.model;

public class DesencadenanteEpisodioModel {
	
	int	id;
	int	idEpisodioMigrana;
	int	idTipoDesencadenante;
	String	nombreTipoDesencadenante;
	String	descripcionDesencadenante;
	
	
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
	 * @return the descripcionDesencadenante
	 */
	public String getDescripcionDesencadenante() {
		return descripcionDesencadenante;
	}
	/**
	 * @param descripcionDesencadenante the descripcionDesencadenante to set
	 */
	public void setDescripcionDesencadenante(String descripcionDesencadenante) {
		this.descripcionDesencadenante = descripcionDesencadenante;
	}
	
	

}
