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
@Table(name = "Precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precio.findAll", query = "SELECT p FROM Precio p"),
    @NamedQuery(name = "Precio.findByPrecioID", query = "SELECT p FROM Precio p WHERE p.precioID = :precioID"),
    @NamedQuery(name = "Precio.findByNombreExamen", query = "SELECT p FROM Precio p WHERE p.nombreExamen = :nombreExamen"),
    @NamedQuery(name = "Precio.findByPrecio", query = "SELECT p FROM Precio p WHERE p.precio = :precio")})
public class Precio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioID")
    private Long precioID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreExamen")
    private String nombreExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;

    public Precio() {
    }

    public Precio(Long precioID) {
        this.precioID = precioID;
    }

    public Precio(Long precioID, String nombreExamen, long precio) {
        this.precioID = precioID;
        this.nombreExamen = nombreExamen;
        this.precio = precio;
    }

    public Long getPrecioID() {
        return precioID;
    }

    public void setPrecioID(Long precioID) {
        this.precioID = precioID;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioID != null ? precioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.precioID == null && other.precioID != null) || (this.precioID != null && !this.precioID.equals(other.precioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Precio[ precioID=" + precioID + " ]";
    }
    
}
