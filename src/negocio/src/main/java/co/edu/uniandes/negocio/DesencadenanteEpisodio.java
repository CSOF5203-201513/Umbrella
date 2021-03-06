/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.negocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erica
 */
@Entity
@Table(name = "desencadenante_episodio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesencadenanteEpisodio.findAll", query = "SELECT d FROM DesencadenanteEpisodio d"),
    @NamedQuery(name = "DesencadenanteEpisodio.findById", query = "SELECT d FROM DesencadenanteEpisodio d WHERE d.id = :id"),
    @NamedQuery(name = "DesencadenanteEpisodio.findByDesencadenante", query = "SELECT d FROM DesencadenanteEpisodio d WHERE d.desencadenante = :desencadenante"),
    @NamedQuery(name = "DesencadenanteEpisodio.findByIdepisodiomigrana", query = "SELECT d FROM DesencadenanteEpisodio d WHERE d.idepisodiomigrana = :idepisodiomigrana"),
    @NamedQuery(name = "DesencadenanteEpisodio.findByTipodesencadenante", query = "SELECT d FROM DesencadenanteEpisodio d WHERE d.tipodesencadenante = :tipodesencadenante")})
public class DesencadenanteEpisodio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.validation.constraints.NotNull
    @Column(name = "id")
    private Integer id;
    @javax.validation.constraints.Size(max = 255)
    @Column(name = "desencadenante")
    private String desencadenante;
    @Column(name = "idepisodiomigrana")
    private Integer idepisodiomigrana;
    @Column(name = "tipodesencadenante")
    private Integer tipodesencadenante;

    public DesencadenanteEpisodio() {
    }

    public DesencadenanteEpisodio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesencadenante() {
    	return desencadenante;
    }

    public void setDesencadenante(String desencadenante) {
        this.desencadenante = desencadenante;
    }

    public Integer getIdepisodiomigrana() {
        return idepisodiomigrana;
    }

    public void setIdepisodiomigrana(Integer idepisodiomigrana) {
    	System.out.println("--------------------------------------> ;Entro y actualizó");
        this.idepisodiomigrana = idepisodiomigrana;
    }

    public Integer getTipodesencadenante() {
        return tipodesencadenante;
    }

    public void setTipodesencadenante(Integer tipodesencadenante) {
        this.tipodesencadenante = tipodesencadenante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesencadenanteEpisodio)) {
            return false;
        }
        DesencadenanteEpisodio other = (DesencadenanteEpisodio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.negocio.DesencadenanteEpisodio[ id=" + id + " ]";
    }
    
}