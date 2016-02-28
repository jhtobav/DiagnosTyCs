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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByPacienteID", query = "SELECT p FROM Paciente p WHERE p.pacienteID = :pacienteID"),
    @NamedQuery(name = "Paciente.findByPersonaID", query = "SELECT p FROM Paciente p WHERE p.pacienteID = :pacienteD")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacienteID")
    private Long pacienteID;
    @JoinColumn(name = "Persona_PersonaID", referencedColumnName = "PersonaID")
    @ManyToOne(optional = false)
    private Persona personaPersonaID;
    @JoinColumn(name = "Tarjeta_TarjetaID", referencedColumnName = "TarjetaID")
    @ManyToOne(optional = false)
    private Tarjeta tarjetaTarjetaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientePacienteID")
    private Collection<Cita> citaCollection;

    public Paciente() {
    }

    public Paciente(Long pacienteID) {
        this.pacienteID = pacienteID;
    }

    public Long getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Long pacienteID) {
        this.pacienteID = pacienteID;
    }

    public Persona getPersonaPersonaID() {
        return personaPersonaID;
    }

    public void setPersonaPersonaID(Persona personaPersonaID) {
        this.personaPersonaID = personaPersonaID;
    }

    public Tarjeta getTarjetaTarjetaID() {
        return tarjetaTarjetaID;
    }

    public void setTarjetaTarjetaID(Tarjeta tarjetaTarjetaID) {
        this.tarjetaTarjetaID = tarjetaTarjetaID;
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
        hash += (pacienteID != null ? pacienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacienteID == null && other.pacienteID != null) || (this.pacienteID != null && !this.pacienteID.equals(other.pacienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paciente[ pacienteID=" + pacienteID + " ]";
    }
    
}
