/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Cita.findByHoraInicio", query = "SELECT c FROM Cita c WHERE c.horaInicio = :horaInicio"),
    @NamedQuery(name = "Cita.findByHoraFin", query = "SELECT c FROM Cita c WHERE c.horaFin = :horaFin"),
    @NamedQuery(name = "Cita.findByValor", query = "SELECT c FROM Cita c WHERE c.valor = :valor")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "citaID")
    private Long citaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @JoinColumn(name = "Doctor_doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctordoctorID;
    @JoinColumn(name = "Examen_examenID", referencedColumnName = "examenID")
    @ManyToOne(optional = false)
    private Examen examenexamenID;
    @JoinColumn(name = "Medico_medicoID", referencedColumnName = "medicoID")
    @ManyToOne(optional = false)
    private Medico medicomedicoID;
    @JoinColumn(name = "Paciente_pacienteID", referencedColumnName = "pacienteID")
    @ManyToOne(optional = false)
    private Paciente pacientepacienteID;

    public Cita() {
    }

    public Cita(Long citaID) {
        this.citaID = citaID;
    }

    public Cita(Long citaID, Date horaInicio, Date horaFin, long valor) {
        this.citaID = citaID;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.valor = valor;
    }

    public Long getCitaID() {
        return citaID;
    }

    public void setCitaID(Long citaID) {
        this.citaID = citaID;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Doctor getDoctordoctorID() {
        return doctordoctorID;
    }

    public void setDoctordoctorID(Doctor doctordoctorID) {
        this.doctordoctorID = doctordoctorID;
    }

    public Examen getExamenexamenID() {
        return examenexamenID;
    }

    public void setExamenexamenID(Examen examenexamenID) {
        this.examenexamenID = examenexamenID;
    }

    public Medico getMedicomedicoID() {
        return medicomedicoID;
    }

    public void setMedicomedicoID(Medico medicomedicoID) {
        this.medicomedicoID = medicomedicoID;
    }

    public Paciente getPacientepacienteID() {
        return pacientepacienteID;
    }

    public void setPacientepacienteID(Paciente pacientepacienteID) {
        this.pacientepacienteID = pacientepacienteID;
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
