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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByValor", query = "SELECT c FROM Cita c WHERE c.valor = :valor")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "citaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long citaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @JoinColumn(name = "Doctor_doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctordoctorID;
    @JoinColumn(name = "ImagenDiagnostica_imagenDiagnosticaID", referencedColumnName = "imagenDiagnosticaID")
    @OneToOne(optional = false)
    private ImagenDiagnostica imagenDiagnosticaimagenDiagnosticaID;
    @JoinColumn(name = "Medico_medicoID", referencedColumnName = "medicoID")
    @ManyToOne(optional = false)
    private Medico medicomedicoID;
    @JoinColumn(name = "Paciente_pacienteID", referencedColumnName = "pacienteID")
    @ManyToOne(optional = false)
    private Paciente pacientepacienteID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citaLaboratorioLaboratoriocitaID")
    private Collection<Laboratorio> laboratorioCollection;

    public Cita() {
    }

    public Cita(Long citaID) {
        this.citaID = citaID;
    }

    public Cita(Long citaID, Date fecha, long valor) {
        this.citaID = citaID;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Long getCitaID() {
        return citaID;
    }

    public void setCitaID(Long citaID) {
        this.citaID = citaID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public ImagenDiagnostica getImagenDiagnosticaimagenDiagnosticaID() {
        return imagenDiagnosticaimagenDiagnosticaID;
    }

    public void setImagenDiagnosticaimagenDiagnosticaID(ImagenDiagnostica imagenDiagnosticaimagenDiagnosticaID) {
        this.imagenDiagnosticaimagenDiagnosticaID = imagenDiagnosticaimagenDiagnosticaID;
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

    @XmlTransient
    public Collection<Laboratorio> getLaboratorioCollection() {
        return laboratorioCollection;
    }

    public void setLaboratorioCollection(Collection<Laboratorio> laboratorioCollection) {
        this.laboratorioCollection = laboratorioCollection;
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
