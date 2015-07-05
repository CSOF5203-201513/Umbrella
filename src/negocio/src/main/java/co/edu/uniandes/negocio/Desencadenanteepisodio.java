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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gremly
 */
@Entity
@Table(name = "desencadenanteepisodio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desencadenanteepisodio.findAll", query = "SELECT d FROM Desencadenanteepisodio d"),
    @NamedQuery(name = "Desencadenanteepisodio.findById", query = "SELECT d FROM Desencadenanteepisodio d WHERE d.id = :id"),
    @NamedQuery(name = "Desencadenanteepisodio.findByDesencadenante", query = "SELECT d FROM Desencadenanteepisodio d WHERE d.desencadenante = :desencadenante"),
    @NamedQuery(name = "Desencadenanteepisodio.findByIdepisodiomigrana", query = "SELECT d FROM Desencadenanteepisodio d WHERE d.idepisodiomigrana = :idepisodiomigrana"),
    @NamedQuery(name = "Desencadenanteepisodio.findByTipodesencadenante", query = "SELECT d FROM Desencadenanteepisodio d WHERE d.tipodesencadenante = :tipodesencadenante")})
public class Desencadenanteepisodio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
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

    public Desencadenanteepisodio() {
    }

    public Desencadenanteepisodio(Integer id) {
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
        if (!(object instanceof Desencadenanteepisodio)) {
            return false;
        }
        Desencadenanteepisodio other = (Desencadenanteepisodio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.negocio.Desencadenanteepisodio[ id=" + id + " ]";
    }
    
}
