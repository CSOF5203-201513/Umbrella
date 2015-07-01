/**
 * 
 */
package co.edu.uniandes.umbrella.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author erica.prado
 *
 */
@Entity
@XmlRootElement
public class DesencadenanteEpisodio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int idEpisodioMigrana;
	
	private int tipoDesencadenante;
	
	private String desencadenante;

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
	 * @return the tipoDesencadenante
	 */
	public int getTipoDesencadenante() {
		return tipoDesencadenante;
	}

	/**
	 * @param tipoDesencadenante the tipoDesencadenante to set
	 */
	public void setTipoDesencadenante(int tipoDesencadenante) {
		this.tipoDesencadenante = tipoDesencadenante;
	}

	/**
	 * @return the desencadenante
	 */
	public String getDesencadenante() {
		return desencadenante;
	}

	/**
	 * @param desencadenante the desencadenante to set
	 */
	public void setDesencadenante(String desencadenante) {
		this.desencadenante = desencadenante;
	}
	
	
	
	

}
