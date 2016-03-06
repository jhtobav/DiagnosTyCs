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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Paciente.findByNumDocumento", query = "SELECT p FROM Paciente p WHERE p.numDocumento = :numDocumento"),
    @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paciente.findByEdad", query = "SELECT p FROM Paciente p WHERE p.edad = :edad"),
    @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paciente.findByDireccion", query = "SELECT p FROM Paciente p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Paciente.findByCorreo", query = "SELECT p FROM Paciente p WHERE p.correo = :correo"),
    @NamedQuery(name = "Paciente.findByContrasena", query = "SELECT p FROM Paciente p WHERE p.contrasena = :contrasena"),
    @NamedQuery(name = "Paciente.findByEstadoCuenta", query = "SELECT p FROM Paciente p WHERE p.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "Paciente.findByRol", query = "SELECT p FROM Paciente p WHERE p.rol = :rol")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pacienteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long pacienteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numDocumento")
    private long numDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoCuenta")
    private boolean estadoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol")
    private int rol;
    @JoinColumn(name = "Tarjeta_tarjetaID", referencedColumnName = "tarjetaID")
    @OneToOne
    private Tarjeta tarjetatarjetaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientepacienteID")
    private Collection<Cita> citaCollection;

    public Paciente() {
    }

    public Paciente(Long pacienteID) {
        this.pacienteID = pacienteID;
    }

    public Paciente(Long pacienteID, long numDocumento, String nombre, int edad, long telefono, String direccion, String correo, String contrasena, boolean estadoCuenta, int rol) {
        this.pacienteID = pacienteID;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estadoCuenta = estadoCuenta;
        this.rol = rol;
    }

    public Long getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Long pacienteID) {
        this.pacienteID = pacienteID;
    }

    public long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Tarjeta getTarjetatarjetaID() {
        return tarjetatarjetaID;
    }

    public void setTarjetatarjetaID(Tarjeta tarjetatarjetaID) {
        this.tarjetatarjetaID = tarjetatarjetaID;
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
