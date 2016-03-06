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
@Table(name = "Examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByExamenID", query = "SELECT e FROM Examen e WHERE e.examenID = :examenID"),
    @NamedQuery(name = "Examen.findByNombre", query = "SELECT e FROM Examen e WHERE e.nombre = :nombre")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "examenID")
    private Long examenID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenexamenID")
    private Collection<Cita> citaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenImagenDiagnosticaImagenDiagnosticaexamenID")
    private Collection<ImagenDiagnostica> imagenDiagnosticaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenLaboratorioLaboratorioexamenID")
    private Collection<Laboratorio> laboratorioCollection;

    public Examen() {
    }

    public Examen(Long examenID) {
        this.examenID = examenID;
    }

    public Examen(Long examenID, String nombre) {
        this.examenID = examenID;
        this.nombre = nombre;
    }

    public Long getExamenID() {
        return examenID;
    }

    public void setExamenID(Long examenID) {
        this.examenID = examenID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @XmlTransient
    public Collection<ImagenDiagnostica> getImagenDiagnosticaCollection() {
        return imagenDiagnosticaCollection;
    }

    public void setImagenDiagnosticaCollection(Collection<ImagenDiagnostica> imagenDiagnosticaCollection) {
        this.imagenDiagnosticaCollection = imagenDiagnosticaCollection;
    }

    @XmlTransient
    public Collection<Laboratorio> getLaboratorioCollection() {
        return laboratorioCollection;
    }

    public void setLaboratorioCollection(Collection<Laboratorio> laboratorioCollection) {
        this.laboratorioCollection = laboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenID != null ? examenID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.examenID == null && other.examenID != null) || (this.examenID != null && !this.examenID.equals(other.examenID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Examen[ examenID=" + examenID + " ]";
    }
    
}
