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
 * @author jhtob
 */
@Entity
@Table(name = "Gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g"),
    @NamedQuery(name = "Gasto.findByGastoID", query = "SELECT g FROM Gasto g WHERE g.gastoID = :gastoID"),
    @NamedQuery(name = "Gasto.findByFecha", query = "SELECT g FROM Gasto g WHERE g.fecha >= :fecha"),
    @NamedQuery(name = "Gasto.findByDescripcion", query = "SELECT g FROM Gasto g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Gasto.findByTipo", query = "SELECT g FROM Gasto g WHERE g.tipo = :tipo"),
    @NamedQuery(name = "Gasto.findByTipoAndFecha", query = "SELECT g FROM Gasto g WHERE g.tipo = :tipo AND g.fecha >= :fecha"),
    @NamedQuery(name = "Gasto.findByCantidad", query = "SELECT g FROM Gasto g WHERE g.cantidad = :cantidad"),
    @NamedQuery(name = "Gasto.findByCosto", query = "SELECT g FROM Gasto g WHERE g.costo = :costo"),
    @NamedQuery(name = "Gasto.findByValorUnidad", query = "SELECT g FROM Gasto g WHERE g.valorUnidad = :valorUnidad")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gastoID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long gastoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private long costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorUnidad")
    private long valorUnidad;

    public Gasto() {
    }

    public Gasto(Long gastoID) {
        this.gastoID = gastoID;
    }

    public Gasto(Long gastoID, Date fecha, String descripcion, String tipo, int cantidad, long costo, long valorUnidad) {
        this.gastoID = gastoID;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.costo = costo;
        this.valorUnidad = valorUnidad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public long getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(long valorUnidad) {
        this.valorUnidad = valorUnidad;
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
