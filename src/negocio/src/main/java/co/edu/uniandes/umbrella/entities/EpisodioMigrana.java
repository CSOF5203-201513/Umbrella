/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.umbrella.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gremly
 */
@Entity
@Table(name = "episodio_migrana")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EpisodioMigrana.findAll", query = "SELECT e FROM EpisodioMigrana e"),
    @NamedQuery(name = "EpisodioMigrana.findById", query = "SELECT e FROM EpisodioMigrana e WHERE e.id = :id"),
    @NamedQuery(name = "EpisodioMigrana.findByEstado", query = "SELECT e FROM EpisodioMigrana e WHERE e.estado = :estado"),
    @NamedQuery(name = "EpisodioMigrana.findByFechacreacion", query = "SELECT e FROM EpisodioMigrana e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "EpisodioMigrana.findByFechamodificacion", query = "SELECT e FROM EpisodioMigrana e WHERE e.fechamodificacion = :fechamodificacion"),
    @NamedQuery(name = "EpisodioMigrana.findByIdintensidad", query = "SELECT e FROM EpisodioMigrana e WHERE e.idintensidad = :idintensidad"),
    @NamedQuery(name = "EpisodioMigrana.findByIdlocalizaciondolor", query = "SELECT e FROM EpisodioMigrana e WHERE e.idlocalizaciondolor = :idlocalizaciondolor"),
    @NamedQuery(name = "EpisodioMigrana.findByIdmedico", query = "SELECT e FROM EpisodioMigrana e WHERE e.idmedico = :idmedico"),
    @NamedQuery(name = "EpisodioMigrana.findByIdpaciente", query = "SELECT e FROM EpisodioMigrana e WHERE e.idpaciente = :idpaciente"),
    @NamedQuery(name = "EpisodioMigrana.findByRutaaudio", query = "SELECT e FROM EpisodioMigrana e WHERE e.rutaaudio = :rutaaudio")})
public class EpisodioMigrana implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.DATE)
    private Date fechamodificacion;
    @Column(name = "idintensidad")
    private Integer idintensidad;
    @Column(name = "idlocalizaciondolor")
    private Integer idlocalizaciondolor;
    @Column(name = "idmedico")
    private Integer idmedico;
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Size(max = 255)
    @Column(name = "rutaaudio")
    private String rutaaudio;

    public EpisodioMigrana() {
    }

    public EpisodioMigrana(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getIdintensidad() {
        return idintensidad;
    }

    public void setIdintensidad(Integer idintensidad) {
        this.idintensidad = idintensidad;
    }

    public Integer getIdlocalizaciondolor() {
        return idlocalizaciondolor;
    }

    public void setIdlocalizaciondolor(Integer idlocalizaciondolor) {
        this.idlocalizaciondolor = idlocalizaciondolor;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getRutaaudio() {
        return rutaaudio;
    }

    public void setRutaaudio(String rutaaudio) {
        this.rutaaudio = rutaaudio;
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
        if (!(object instanceof EpisodioMigrana)) {
            return false;
        }
        EpisodioMigrana other = (EpisodioMigrana) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.umbrella.EpisodioMigrana[ id=" + id + " ]";
    }
    
}
