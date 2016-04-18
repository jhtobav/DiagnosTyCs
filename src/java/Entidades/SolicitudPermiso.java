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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "SolicitudPermiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudPermiso.findAll", query = "SELECT s FROM SolicitudPermiso s"),
    @NamedQuery(name = "SolicitudPermiso.findBySolicitudPermisoID", query = "SELECT s FROM SolicitudPermiso s WHERE s.solicitudPermisoID = :solicitudPermisoID"),
    @NamedQuery(name = "SolicitudPermiso.findByDoctorID", query = "SELECT s FROM SolicitudPermiso s WHERE s.doctorID = :doctorID"),
    @NamedQuery(name = "SolicitudPermiso.findByNombreDoctor", query = "SELECT s FROM SolicitudPermiso s WHERE s.nombreDoctor = :nombreDoctor"),
    @NamedQuery(name = "SolicitudPermiso.findByJustificacion", query = "SELECT s FROM SolicitudPermiso s WHERE s.justificacion = :justificacion"),
    @NamedQuery(name = "SolicitudPermiso.findByAprobacion", query = "SELECT s FROM SolicitudPermiso s WHERE s.aprobacion = :aprobacion"),
    @NamedQuery(name = "SolicitudPermiso.findByFechaInicio", query = "SELECT s FROM SolicitudPermiso s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "SolicitudPermiso.findByFechaFin", query = "SELECT s FROM SolicitudPermiso s WHERE s.fechaFin = :fechaFin")})
public class SolicitudPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "solicitudPermisoID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solicitudPermisoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctorID")
    private long doctorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreDoctor")
    private String nombreDoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "justificacion")
    private String justificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "aprobacion")
    private String aprobacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public SolicitudPermiso() {
    }

    public SolicitudPermiso(Long solicitudPermisoID) {
        this.solicitudPermisoID = solicitudPermisoID;
    }

    public SolicitudPermiso(Long solicitudPermisoID, long doctorID, String nombreDoctor, String justificacion, String aprobacion, Date fechaInicio, Date fechaFin) {
        this.solicitudPermisoID = solicitudPermisoID;
        this.doctorID = doctorID;
        this.nombreDoctor = nombreDoctor;
        this.justificacion = justificacion;
        this.aprobacion = aprobacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getSolicitudPermisoID() {
        return solicitudPermisoID;
    }

    public void setSolicitudPermisoID(Long solicitudPermisoID) {
        this.solicitudPermisoID = solicitudPermisoID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudPermisoID != null ? solicitudPermisoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudPermiso)) {
            return false;
        }
        SolicitudPermiso other = (SolicitudPermiso) object;
        if ((this.solicitudPermisoID == null && other.solicitudPermisoID != null) || (this.solicitudPermisoID != null && !this.solicitudPermisoID.equals(other.solicitudPermisoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudPermiso[ solicitudPermisoID=" + solicitudPermisoID + " ]";
    }
    
}
