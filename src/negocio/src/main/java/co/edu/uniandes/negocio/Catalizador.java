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
@Table(name = "catalizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalizador.findAll", query = "SELECT c FROM Catalizador c"),
    @NamedQuery(name = "Catalizador.findById", query = "SELECT c FROM Catalizador c WHERE c.id = :id"),
    @NamedQuery(name = "Catalizador.findByNombre", query = "SELECT c FROM Catalizador c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Catalizador.findByTipo", query = "SELECT c FROM Catalizador c WHERE c.tipo = :tipo")})
public class Catalizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @Column(name = "id")
    private Integer id;
    @javax.validation.constraints.Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private Integer tipo;

    public Catalizador() {
    }

    public Catalizador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Catalizador)) {
            return false;
        }
        Catalizador other = (Catalizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.negocio.Catalizador[ id=" + id + " ]";
    }
    
}
