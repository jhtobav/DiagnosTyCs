/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author jhtob
 */
@Entity
@Table(name = "Tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByTarjetaID", query = "SELECT t FROM Tarjeta t WHERE t.tarjetaID = :tarjetaID"),
    @NamedQuery(name = "Tarjeta.findByNombreEnTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nombreEnTarjeta = :nombreEnTarjeta"),
    @NamedQuery(name = "Tarjeta.findByNumeroMes", query = "SELECT t FROM Tarjeta t WHERE t.numeroMes = :numeroMes"),
    @NamedQuery(name = "Tarjeta.findByNumeroAno", query = "SELECT t FROM Tarjeta t WHERE t.numeroAno = :numeroAno"),
    @NamedQuery(name = "Tarjeta.findByCsv", query = "SELECT t FROM Tarjeta t WHERE t.csv = :csv")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarjetaID")
    private Long tarjetaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreEnTarjeta")
    private String nombreEnTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroMes")
    private int numeroMes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroAno")
    private int numeroAno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CSV")
    private int csv;

    public Tarjeta() {
    }

    public Tarjeta(Long tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public Tarjeta(Long tarjetaID, String nombreEnTarjeta, int numeroMes, int numeroAno, int csv) {
        this.tarjetaID = tarjetaID;
        this.nombreEnTarjeta = nombreEnTarjeta;
        this.numeroMes = numeroMes;
        this.numeroAno = numeroAno;
        this.csv = csv;
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

    public int getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }

    public int getNumeroAno() {
        return numeroAno;
    }

    public void setNumeroAno(int numeroAno) {
        this.numeroAno = numeroAno;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
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
