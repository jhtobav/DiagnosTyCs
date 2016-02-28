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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Activo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a"),
    @NamedQuery(name = "Activo.findByActivoID", query = "SELECT a FROM Activo a WHERE a.activoID = :activoID"),
    @NamedQuery(name = "Activo.findByDescripcion", query = "SELECT a FROM Activo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Activo.findByValor", query = "SELECT a FROM Activo a WHERE a.valor = :valor"),
    @NamedQuery(name = "Activo.findByUnidadesExistentes", query = "SELECT a FROM Activo a WHERE a.unidadesExistentes = :unidadesExistentes")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActivoID")
    private Long activoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadesExistentes")
    private int unidadesExistentes;
    @JoinColumn(name = "GastoActivo_Activo_GastoID", referencedColumnName = "GastoID")
    @ManyToOne(optional = false)
    private Gasto gastoActivoActivoGastoID;

    public Activo() {
    }

    public Activo(Long activoID) {
        this.activoID = activoID;
    }

    public Activo(Long activoID, String descripcion, long valor, int unidadesExistentes) {
        this.activoID = activoID;
        this.descripcion = descripcion;
        this.valor = valor;
        this.unidadesExistentes = unidadesExistentes;
    }

    public Long getActivoID() {
        return activoID;
    }

    public void setActivoID(Long activoID) {
        this.activoID = activoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }

    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }

    public Gasto getGastoActivoActivoGastoID() {
        return gastoActivoActivoGastoID;
    }

    public void setGastoActivoActivoGastoID(Gasto gastoActivoActivoGastoID) {
        this.gastoActivoActivoGastoID = gastoActivoActivoGastoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activoID != null ? activoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.activoID == null && other.activoID != null) || (this.activoID != null && !this.activoID.equals(other.activoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Activo[ activoID=" + activoID + " ]";
    }
    
}
