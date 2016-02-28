/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Reactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reactivo.findAll", query = "SELECT r FROM Reactivo r"),
    @NamedQuery(name = "Reactivo.findByReactivoID", query = "SELECT r FROM Reactivo r WHERE r.reactivoID = :reactivoID"),
    @NamedQuery(name = "Reactivo.findByNombre", query = "SELECT r FROM Reactivo r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Reactivo.findByValor", query = "SELECT r FROM Reactivo r WHERE r.valor = :valor"),
    @NamedQuery(name = "Reactivo.findByUnidadesExistentes", query = "SELECT r FROM Reactivo r WHERE r.unidadesExistentes = :unidadesExistentes")})
public class Reactivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReactivoID")
    private Long reactivoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadesExistentes")
    private int unidadesExistentes;
    @JoinColumn(name = "GastoReactivo_Reactivo_GastoID", referencedColumnName = "GastoID")
    @ManyToOne(optional = false)
    private Gasto gastoReactivoReactivoGastoID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reactivoReactivoID")
    private Collection<Alerta> alertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reactivoReactivoID")
    private Collection<ExamenLaboratorio> examenLaboratorioCollection;

    public Reactivo() {
    }

    public Reactivo(Long reactivoID) {
        this.reactivoID = reactivoID;
    }

    public Reactivo(Long reactivoID, String nombre, long valor, int unidadesExistentes) {
        this.reactivoID = reactivoID;
        this.nombre = nombre;
        this.valor = valor;
        this.unidadesExistentes = unidadesExistentes;
    }

    public Long getReactivoID() {
        return reactivoID;
    }

    public void setReactivoID(Long reactivoID) {
        this.reactivoID = reactivoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Gasto getGastoReactivoReactivoGastoID() {
        return gastoReactivoReactivoGastoID;
    }

    public void setGastoReactivoReactivoGastoID(Gasto gastoReactivoReactivoGastoID) {
        this.gastoReactivoReactivoGastoID = gastoReactivoReactivoGastoID;
    }

    @XmlTransient
    public Collection<Alerta> getAlertaCollection() {
        return alertaCollection;
    }

    public void setAlertaCollection(Collection<Alerta> alertaCollection) {
        this.alertaCollection = alertaCollection;
    }

    @XmlTransient
    public Collection<ExamenLaboratorio> getExamenLaboratorioCollection() {
        return examenLaboratorioCollection;
    }

    public void setExamenLaboratorioCollection(Collection<ExamenLaboratorio> examenLaboratorioCollection) {
        this.examenLaboratorioCollection = examenLaboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reactivoID != null ? reactivoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reactivo)) {
            return false;
        }
        Reactivo other = (Reactivo) object;
        if ((this.reactivoID == null && other.reactivoID != null) || (this.reactivoID != null && !this.reactivoID.equals(other.reactivoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reactivo[ reactivoID=" + reactivoID + " ]";
    }
    
}
