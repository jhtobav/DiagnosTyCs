/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g"),
    @NamedQuery(name = "Gasto.findByGastoID", query = "SELECT g FROM Gasto g WHERE g.gastoID = :gastoID"),
    @NamedQuery(name = "Gasto.findByFecha", query = "SELECT g FROM Gasto g WHERE g.fecha = :fecha")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GastoID")
    private Long gastoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastoActivoActivoGastoID")
    private Collection<Activo> activoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastoReactivoReactivoGastoID")
    private Collection<Reactivo> reactivoCollection;

    public Gasto() {
    }

    public Gasto(Long gastoID) {
        this.gastoID = gastoID;
    }

    public Gasto(Long gastoID, Date fecha) {
        this.gastoID = gastoID;
        this.fecha = fecha;
    }

    public Long getGastoID() {
        return gastoID;
    }

    public void setGastoID(Long gastoID) {
        this.gastoID = gastoID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Activo> getActivoCollection() {
        return activoCollection;
    }

    public void setActivoCollection(Collection<Activo> activoCollection) {
        this.activoCollection = activoCollection;
    }

    @XmlTransient
    public Collection<Reactivo> getReactivoCollection() {
        return reactivoCollection;
    }

    public void setReactivoCollection(Collection<Reactivo> reactivoCollection) {
        this.reactivoCollection = reactivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoID != null ? gastoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.gastoID == null && other.gastoID != null) || (this.gastoID != null && !this.gastoID.equals(other.gastoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Gasto[ gastoID=" + gastoID + " ]";
    }
    
}
