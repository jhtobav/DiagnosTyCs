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
@Table(name = "Persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersonaID", query = "SELECT p FROM Persona p WHERE p.personaID = :personaID"),
    @NamedQuery(name = "Persona.findByContrasena", query = "SELECT p FROM Persona p WHERE p.contrasena = :contrasena"),
    @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo"),
    @NamedQuery(name = "Persona.findByEstadoCuenta", query = "SELECT p FROM Persona p WHERE p.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "Persona.findByRol", query = "SELECT p FROM Persona p WHERE p.rol = :rol"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonaID")
    private Long personaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstadoCuenta")
    private boolean estadoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rol")
    private int rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaID")
    private Collection<Administrador> administradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaID")
    private Collection<Gerente> gerenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaID")
    private Collection<Medico> medicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaID")
    private Collection<Paciente> pacienteCollection;

    public Persona() {
    }

    public Persona(Long personaID) {
        this.personaID = personaID;
    }

    public Persona(Long personaID, String contrasena, int edad, long telefono, String direccion, String correo, boolean estadoCuenta, int rol, String nombre) {
        this.personaID = personaID;
        this.contrasena = contrasena;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.estadoCuenta = estadoCuenta;
        this.rol = rol;
        this.nombre = nombre;
    }

    public Long getPersonaID() {
        return personaID;
    }

    public void setPersonaID(Long personaID) {
        this.personaID = personaID;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    @XmlTransient
    public Collection<Gerente> getGerenteCollection() {
        return gerenteCollection;
    }

    public void setGerenteCollection(Collection<Gerente> gerenteCollection) {
        this.gerenteCollection = gerenteCollection;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaID != null ? personaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaID == null && other.personaID != null) || (this.personaID != null && !this.personaID.equals(other.personaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Persona[ personaID=" + personaID + " ]";
    }
    
}
