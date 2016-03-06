/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author jhtob
 */
@Entity
@Table(name = "Alerta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findByAlertaID", query = "SELECT a FROM Alerta a WHERE a.alertaID = :alertaID"),
    @NamedQuery(name = "Alerta.findByDescripcion", query = "SELECT a FROM Alerta a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Alerta.findByFecha", query = "SELECT a FROM Alerta a WHERE a.fecha = :fecha")})
public class Alerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "alertaID")
    private Long alertaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "Reactivo_reactivoID", referencedColumnName = "reactivoID")
    @ManyToOne(optional = false)
    private Reactivo reactivoreactivoID;

    public Alerta() {
    }

    public Alerta(Long alertaID) {
        this.alertaID = alertaID;
    }

    public Alerta(Long alertaID, String descripcion, Date fecha) {
        this.alertaID = alertaID;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getAlertaID() {
        return alertaID;
    }

    public void setAlertaID(Long alertaID) {
        this.alertaID = alertaID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Reactivo getReactivoreactivoID() {
        return reactivoreactivoID;
    }

    public void setReactivoreactivoID(Reactivo reactivoreactivoID) {
        this.reactivoreactivoID = reactivoreactivoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertaID != null ? alertaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.alertaID == null && other.alertaID != null) || (this.alertaID != null && !this.alertaID.equals(other.alertaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Alerta[ alertaID=" + alertaID + " ]";
    }
    
}
