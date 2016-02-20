/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Paciente.findByNumTarjeta", query = "SELECT p FROM Paciente p WHERE p.numTarjeta = :numTarjeta"),
    @NamedQuery(name = "Paciente.findByCita", query = "SELECT p FROM Paciente p WHERE p.cita = :cita")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacienteID")
    private Long pacienteID;
    @Column(name = "NumTarjeta")
    private BigInteger numTarjeta;
    @Column(name = "Cita")
    private BigInteger cita;
    @JoinColumn(name = "PacienteID", referencedColumnName = "PersonaID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

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

    public BigInteger getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(BigInteger numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public BigInteger getCita() {
        return cita;
    }

    public void setCita(BigInteger cita) {
        this.cita = cita;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
