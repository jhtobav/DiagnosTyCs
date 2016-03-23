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
@Table(name = "Alerta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findByAlertaID", query = "SELECT a FROM Alerta a WHERE a.alertaID = :alertaID"),
    @NamedQuery(name = "Alerta.findByFecha", query = "SELECT a FROM Alerta a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Alerta.findByDescripcion", query = "SELECT a FROM Alerta a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Alerta.findByNombreReactivo", query = "SELECT a FROM Alerta a WHERE a.nombreReactivo = :nombreReactivo"),
    @NamedQuery(name = "Alerta.findByCantidadFaltante", query = "SELECT a FROM Alerta a WHERE a.cantidadFaltante = :cantidadFaltante")})
public class Alerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alertaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long alertaID;
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
    @Column(name = "nombreReactivo")
    private String nombreReactivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadFaltante")
    private int cantidadFaltante;

    public Alerta() {
    }

    public Alerta(Long alertaID) {
        this.alertaID = alertaID;
    }

    public Alerta(Long alertaID, Date fecha, String descripcion, String nombreReactivo, int cantidadFaltante) {
        this.alertaID = alertaID;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombreReactivo = nombreReactivo;
        this.cantidadFaltante = cantidadFaltante;
    }

    public Long getAlertaID() {
        return alertaID;
    }

    public void setAlertaID(Long alertaID) {
        this.alertaID = alertaID;
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

    public String getNombreReactivo() {
        return nombreReactivo;
    }

    public void setNombreReactivo(String nombreReactivo) {
        this.nombreReactivo = nombreReactivo;
    }

    public int getCantidadFaltante() {
        return cantidadFaltante;
    }

    public void setCantidadFaltante(int cantidadFaltante) {
        this.cantidadFaltante = cantidadFaltante;
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
