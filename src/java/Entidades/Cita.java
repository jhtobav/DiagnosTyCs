/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByCitaID", query = "SELECT c FROM Cita c WHERE c.citaID = :citaID"),
    @NamedQuery(name = "Cita.findByHorario", query = "SELECT c FROM Cita c WHERE c.horario = :horario"),
    @NamedQuery(name = "Cita.findByValor", query = "SELECT c FROM Cita c WHERE c.valor = :valor")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CitaID")
    private Long citaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private long valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citaExamenExamenCitaID")
    private Collection<Examen> examenCollection;
    @JoinColumn(name = "Medico_MedicoID", referencedColumnName = "MedicoID")
    @ManyToOne(optional = false)
    private Medico medicoMedicoID;
    @JoinColumn(name = "Paciente_PacienteID", referencedColumnName = "PacienteID")
    @ManyToOne(optional = false)
    private Paciente pacientePacienteID;

    public Cita() {
    }

    public Cita(Long citaID) {
        this.citaID = citaID;
    }

    public Cita(Long citaID, Date horario, long valor) {
        this.citaID = citaID;
        this.horario = horario;
        this.valor = valor;
    }

    public Long getCitaID() {
        return citaID;
    }

    public void setCitaID(Long citaID) {
        this.citaID = citaID;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    public Medico getMedicoMedicoID() {
        return medicoMedicoID;
    }

    public void setMedicoMedicoID(Medico medicoMedicoID) {
        this.medicoMedicoID = medicoMedicoID;
    }

    public Paciente getPacientePacienteID() {
        return pacientePacienteID;
    }

    public void setPacientePacienteID(Paciente pacientePacienteID) {
        this.pacientePacienteID = pacientePacienteID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaID != null ? citaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.citaID == null && other.citaID != null) || (this.citaID != null && !this.citaID.equals(other.citaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cita[ citaID=" + citaID + " ]";
    }
    
}
