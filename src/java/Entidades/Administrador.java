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
@Table(name = "Administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByAdministradorID", query = "SELECT a FROM Administrador a WHERE a.administradorID = :administradorID")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "administradorID")
    private Long administradorID;
    @JoinColumn(name = "Persona_personaID", referencedColumnName = "personaID")
    @OneToOne(optional = false)
    private Persona personapersonaID;

    public Administrador() {
    }

    public Administrador(Long administradorID) {
        this.administradorID = administradorID;
    }

    public Long getAdministradorID() {
        return administradorID;
    }

    public void setAdministradorID(Long administradorID) {
        this.administradorID = administradorID;
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
        hash += (administradorID != null ? administradorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.administradorID == null && other.administradorID != null) || (this.administradorID != null && !this.administradorID.equals(other.administradorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Administrador[ administradorID=" + administradorID + " ]";
    }
    
}
