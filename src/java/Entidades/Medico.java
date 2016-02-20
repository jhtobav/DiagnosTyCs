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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Medico.findByEspecialidad", query = "SELECT m FROM Medico m WHERE m.especialidad = :especialidad"),
    @NamedQuery(name = "Medico.findByEstado", query = "SELECT m FROM Medico m WHERE m.estado = :estado"),
    @NamedQuery(name = "Medico.findByCita", query = "SELECT m FROM Medico m WHERE m.cita = :cita"),
    @NamedQuery(name = "Medico.findBySalario", query = "SELECT m FROM Medico m WHERE m.salario = :salario")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MedicoID")
    private Long medicoID;
    @Size(max = 50)
    @Column(name = "Especialidad")
    private String especialidad;
    @Size(max = 50)
    @Column(name = "Estado")
    private String estado;
    @Column(name = "Cita")
    private BigInteger cita;
    @Column(name = "Salario")
    private BigInteger salario;
    @JoinColumn(name = "MedicoID", referencedColumnName = "PersonaID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Medico() {
    }

    public Medico(Long medicoID) {
        this.medicoID = medicoID;
    }

    public Long getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Long medicoID) {
        this.medicoID = medicoID;
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

    public BigInteger getCita() {
        return cita;
    }

    public void setCita(BigInteger cita) {
        this.cita = cita;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
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
