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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByMedicoID", query = "SELECT m FROM Medico m WHERE m.medicoID = :medicoID"),
    @NamedQuery(name = "Medico.findByEstado", query = "SELECT m FROM Medico m WHERE m.estado = :estado"),
    @NamedQuery(name = "Medico.findBySalario", query = "SELECT m FROM Medico m WHERE m.salario = :salario")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "medicoID")
    private Long medicoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private long salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicomedicoID")
    private Collection<Agenda> agendaCollection;
    @JoinColumn(name = "Persona_personaID", referencedColumnName = "personaID")
    @OneToOne(optional = false)
    private Persona personapersonaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicomedicoID")
    private Collection<Cita> citaCollection;

    public Medico() {
    }

    public Medico(Long medicoID) {
        this.medicoID = medicoID;
    }

    public Medico(Long medicoID, String estado, long salario) {
        this.medicoID = medicoID;
        this.estado = estado;
        this.salario = salario;
    }

    public Long getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Long medicoID) {
        this.medicoID = medicoID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
    }

    public Persona getPersonapersonaID() {
        return personapersonaID;
    }

    public void setPersonapersonaID(Persona personapersonaID) {
        this.personapersonaID = personapersonaID;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoID != null ? medicoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.medicoID == null && other.medicoID != null) || (this.medicoID != null && !this.medicoID.equals(other.medicoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Medico[ medicoID=" + medicoID + " ]";
    }
    
}
