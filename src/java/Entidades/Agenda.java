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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByAgendaID", query = "SELECT a FROM Agenda a WHERE a.agendaID = :agendaID"),
    @NamedQuery(name = "Agenda.findByDisponible", query = "SELECT a FROM Agenda a WHERE a.disponible = :disponible")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "agendaID")
    private Integer agendaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private boolean disponible;
    @JoinColumn(name = "Doctor_doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctordoctorID;
    @JoinColumn(name = "Medico_medicoID", referencedColumnName = "medicoID")
    @ManyToOne(optional = false)
    private Medico medicomedicoID;

    public Agenda() {
    }

    public Agenda(Integer agendaID) {
        this.agendaID = agendaID;
    }

    public Agenda(Integer agendaID, boolean disponible) {
        this.agendaID = agendaID;
        this.disponible = disponible;
    }

    public Integer getAgendaID() {
        return agendaID;
    }

    public void setAgendaID(Integer agendaID) {
        this.agendaID = agendaID;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Doctor getDoctordoctorID() {
        return doctordoctorID;
    }

    public void setDoctordoctorID(Doctor doctordoctorID) {
        this.doctordoctorID = doctordoctorID;
    }

    public Medico getMedicomedicoID() {
        return medicomedicoID;
    }

    public void setMedicomedicoID(Medico medicomedicoID) {
        this.medicomedicoID = medicomedicoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaID != null ? agendaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaID == null && other.agendaID != null) || (this.agendaID != null && !this.agendaID.equals(other.agendaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Agenda[ agendaID=" + agendaID + " ]";
    }
    
}
