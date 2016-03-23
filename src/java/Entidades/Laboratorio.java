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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Laboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l"),
    @NamedQuery(name = "Laboratorio.findByExamenLaboratorioID", query = "SELECT l FROM Laboratorio l WHERE l.examenLaboratorioID = :examenLaboratorioID"),
    @NamedQuery(name = "Laboratorio.findByNombre", query = "SELECT l FROM Laboratorio l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Laboratorio.findByDescripcion", query = "SELECT l FROM Laboratorio l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Laboratorio.findByResultado", query = "SELECT l FROM Laboratorio l WHERE l.resultado = :resultado")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "examenLaboratorioID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long examenLaboratorioID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resultado")
    private String resultado;
    @JoinColumn(name = "CitaLaboratorio_Laboratorio_citaID", referencedColumnName = "citaID")
    @ManyToOne(optional = false)
    private Cita citaLaboratorioLaboratoriocitaID;
    @JoinColumn(name = "Reactivo_reactivoID", referencedColumnName = "reactivoID")
    @ManyToOne(optional = false)
    private Reactivo reactivoreactivoID;

    public Laboratorio() {
    }

    public Laboratorio(Long examenLaboratorioID) {
        this.examenLaboratorioID = examenLaboratorioID;
    }

    public Laboratorio(Long examenLaboratorioID, String nombre, String descripcion, String resultado) {
        this.examenLaboratorioID = examenLaboratorioID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    public Long getExamenLaboratorioID() {
        return examenLaboratorioID;
    }

    public void setExamenLaboratorioID(Long examenLaboratorioID) {
        this.examenLaboratorioID = examenLaboratorioID;
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

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Cita getCitaLaboratorioLaboratoriocitaID() {
        return citaLaboratorioLaboratoriocitaID;
    }

    public void setCitaLaboratorioLaboratoriocitaID(Cita citaLaboratorioLaboratoriocitaID) {
        this.citaLaboratorioLaboratoriocitaID = citaLaboratorioLaboratoriocitaID;
    }

    public Reactivo getReactivoreactivoID() {
        return reactivoreactivoID;
    }

    public void setReactivoreactivoID(Reactivo reactivoreactivoID) {
        this.reactivoreactivoID = reactivoreactivoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenLaboratorioID != null ? examenLaboratorioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.examenLaboratorioID == null && other.examenLaboratorioID != null) || (this.examenLaboratorioID != null && !this.examenLaboratorioID.equals(other.examenLaboratorioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Laboratorio[ examenLaboratorioID=" + examenLaboratorioID + " ]";
    }
    
}
