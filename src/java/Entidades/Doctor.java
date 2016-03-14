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
import javax.persistence.ManyToMany;
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
@Table(name = "Doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByDoctorID", query = "SELECT d FROM Doctor d WHERE d.doctorID = :doctorID"),
    @NamedQuery(name = "Doctor.findByEspecialidad", query = "SELECT d FROM Doctor d WHERE d.especialidad = :especialidad"),
    @NamedQuery(name = "Doctor.findByEstado", query = "SELECT d FROM Doctor d WHERE d.estado = :estado"),
    @NamedQuery(name = "Doctor.findBySalario", query = "SELECT d FROM Doctor d WHERE d.salario = :salario")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctorID")
    private Long doctorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "especialidad")
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private long salario;
    @ManyToMany(mappedBy = "doctorCollection")
    private Collection<Cita> citaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctordoctorID")
    private Collection<Agenda> agendaCollection;
    @JoinColumn(name = "Persona_personaID", referencedColumnName = "personaID")
    @ManyToOne(optional = false)
    private Persona personapersonaID;

    public Doctor() {
    }

    public Doctor(Long doctorID) {
        this.doctorID = doctorID;
    }

    public Doctor(Long doctorID, String especialidad, String estado, long salario) {
        this.doctorID = doctorID;
        this.especialidad = especialidad;
        this.estado = estado;
        this.salario = salario;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorID != null ? doctorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorID == null && other.doctorID != null) || (this.doctorID != null && !this.doctorID.equals(other.doctorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Doctor[ doctorID=" + doctorID + " ]";
    }
    
}
