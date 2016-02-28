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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByTarjetaID", query = "SELECT t FROM Tarjeta t WHERE t.tarjetaID = :tarjetaID"),
    @NamedQuery(name = "Tarjeta.findByNombreEnTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nombreEnTarjeta = :nombreEnTarjeta"),
    @NamedQuery(name = "Tarjeta.findByFechaVencimiento", query = "SELECT t FROM Tarjeta t WHERE t.fechaVencimiento = :fechaVencimiento")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TarjetaID")
    private Long tarjetaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "NombreEnTarjeta")
    private String nombreEnTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaTarjetaID")
    private Collection<Paciente> pacienteCollection;

    public Tarjeta() {
    }

    public Tarjeta(Long tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public Tarjeta(Long tarjetaID, String nombreEnTarjeta, Date fechaVencimiento) {
        this.tarjetaID = tarjetaID;
        this.nombreEnTarjeta = nombreEnTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getTarjetaID() {
        return tarjetaID;
    }

    public void setTarjetaID(Long tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public String getNombreEnTarjeta() {
        return nombreEnTarjeta;
    }

    public void setNombreEnTarjeta(String nombreEnTarjeta) {
        this.nombreEnTarjeta = nombreEnTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarjetaID != null ? tarjetaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.tarjetaID == null && other.tarjetaID != null) || (this.tarjetaID != null && !this.tarjetaID.equals(other.tarjetaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tarjeta[ tarjetaID=" + tarjetaID + " ]";
    }
    
}
