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
@Table(name = "ExamenLaboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenLaboratorio.findAll", query = "SELECT e FROM ExamenLaboratorio e"),
    @NamedQuery(name = "ExamenLaboratorio.findByExamenLaboratorioID", query = "SELECT e FROM ExamenLaboratorio e WHERE e.examenLaboratorioID = :examenLaboratorioID"),
    @NamedQuery(name = "ExamenLaboratorio.findByResultado", query = "SELECT e FROM ExamenLaboratorio e WHERE e.resultado = :resultado")})
public class ExamenLaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExamenLaboratorioID")
    private Long examenLaboratorioID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Resultado")
    private String resultado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenLaboratorioExamenLaboratorioID")
    private Collection<Examen> examenCollection;
    @JoinColumn(name = "Reactivo_ReactivoID", referencedColumnName = "ReactivoID")
    @ManyToOne(optional = false)
    private Reactivo reactivoReactivoID;

    public ExamenLaboratorio() {
    }

    public ExamenLaboratorio(Long examenLaboratorioID) {
        this.examenLaboratorioID = examenLaboratorioID;
    }

    public ExamenLaboratorio(Long examenLaboratorioID, String resultado) {
        this.examenLaboratorioID = examenLaboratorioID;
        this.resultado = resultado;
    }

    public Long getExamenLaboratorioID() {
        return examenLaboratorioID;
    }

    public void setExamenLaboratorioID(Long examenLaboratorioID) {
        this.examenLaboratorioID = examenLaboratorioID;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    public Reactivo getReactivoReactivoID() {
        return reactivoReactivoID;
    }

    public void setReactivoReactivoID(Reactivo reactivoReactivoID) {
        this.reactivoReactivoID = reactivoReactivoID;
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
        if (!(object instanceof ExamenLaboratorio)) {
            return false;
        }
        ExamenLaboratorio other = (ExamenLaboratorio) object;
        if ((this.examenLaboratorioID == null && other.examenLaboratorioID != null) || (this.examenLaboratorioID != null && !this.examenLaboratorioID.equals(other.examenLaboratorioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ExamenLaboratorio[ examenLaboratorioID=" + examenLaboratorioID + " ]";
    }
    
}
