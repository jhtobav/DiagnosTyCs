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
@Table(name = "Gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByGerenteID", query = "SELECT g FROM Gerente g WHERE g.gerenteID = :gerenteID")})
public class Gerente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GerenteID")
    private Long gerenteID;
    @JoinColumn(name = "GerenteID", referencedColumnName = "PersonaID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Gerente() {
    }

    public Gerente(Long gerenteID) {
        this.gerenteID = gerenteID;
    }

    public Long getGerenteID() {
        return gerenteID;
    }

    public void setGerenteID(Long gerenteID) {
        this.gerenteID = gerenteID;
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
        hash += (gerenteID != null ? gerenteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.gerenteID == null && other.gerenteID != null) || (this.gerenteID != null && !this.gerenteID.equals(other.gerenteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Gerente[ gerenteID=" + gerenteID + " ]";
    }
    
}
