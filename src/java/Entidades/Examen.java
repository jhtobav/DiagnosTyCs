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
@Table(name = "Examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByExamenID", query = "SELECT e FROM Examen e WHERE e.examenID = :examenID"),
    @NamedQuery(name = "Examen.findByNombre", query = "SELECT e FROM Examen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Examen.findByDescripcion", query = "SELECT e FROM Examen e WHERE e.descripcion = :descripcion")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExamenID")
    private Long examenID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "CitaExamen_Examen_CitaID", referencedColumnName = "CitaID")
    @ManyToOne(optional = false)
    private Cita citaExamenExamenCitaID;
    @JoinColumn(name = "ExamenLaboratorio_ExamenLaboratorioID", referencedColumnName = "ExamenLaboratorioID")
    @ManyToOne(optional = false)
    private ExamenLaboratorio examenLaboratorioExamenLaboratorioID;
    @JoinColumn(name = "ImagenDiagnostica_ImagenDiagnosticaID", referencedColumnName = "ImagenDiagnosticaID")
    @ManyToOne(optional = false)
    private ImagenDiagnostica imagenDiagnosticaImagenDiagnosticaID;

    public Examen() {
    }

    public Examen(Long examenID) {
        this.examenID = examenID;
    }

    public Examen(Long examenID, String nombre, String descripcion) {
        this.examenID = examenID;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cita getCitaExamenExamenCitaID() {
        return citaExamenExamenCitaID;
    }

    public void setCitaExamenExamenCitaID(Cita citaExamenExamenCitaID) {
        this.citaExamenExamenCitaID = citaExamenExamenCitaID;
    }

    public ExamenLaboratorio getExamenLaboratorioExamenLaboratorioID() {
        return examenLaboratorioExamenLaboratorioID;
    }

    public void setExamenLaboratorioExamenLaboratorioID(ExamenLaboratorio examenLaboratorioExamenLaboratorioID) {
        this.examenLaboratorioExamenLaboratorioID = examenLaboratorioExamenLaboratorioID;
    }

    public ImagenDiagnostica getImagenDiagnosticaImagenDiagnosticaID() {
        return imagenDiagnosticaImagenDiagnosticaID;
    }

    public void setImagenDiagnosticaImagenDiagnosticaID(ImagenDiagnostica imagenDiagnosticaImagenDiagnosticaID) {
        this.imagenDiagnosticaImagenDiagnosticaID = imagenDiagnosticaImagenDiagnosticaID;
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
