/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.umbrella.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gremly
 */
@Entity
@Table(name = "listavalor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listavalor.findAll", query = "SELECT l FROM Listavalor l"),
    @NamedQuery(name = "Listavalor.findById", query = "SELECT l FROM Listavalor l WHERE l.id = :id"),
    @NamedQuery(name = "Listavalor.findByDescripcion", query = "SELECT l FROM Listavalor l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Listavalor.findByIdlista", query = "SELECT l FROM Listavalor l WHERE l.idlista = :idlista"),
    @NamedQuery(name = "Listavalor.findByValor", query = "SELECT l FROM Listavalor l WHERE l.valor = :valor")})
public class Listavalor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "idlista")
    private Integer idlista;
    @Size(max = 255)
    @Column(name = "valor")
    private String valor;

    public Listavalor() {
    }

    public Listavalor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdlista() {
        return idlista;
    }

    public void setIdlista(Integer idlista) {
        this.idlista = idlista;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        if (!(object instanceof Listavalor)) {
            return false;
        }
        Listavalor other = (Listavalor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.umbrella.Listavalor[ id=" + id + " ]";
    }
    
}
