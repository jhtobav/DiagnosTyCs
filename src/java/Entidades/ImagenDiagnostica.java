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
@Table(name = "ImagenDiagnostica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenDiagnostica.findAll", query = "SELECT i FROM ImagenDiagnostica i"),
    @NamedQuery(name = "ImagenDiagnostica.findByImagenDiagnosticaID", query = "SELECT i FROM ImagenDiagnostica i WHERE i.imagenDiagnosticaID = :imagenDiagnosticaID"),
    @NamedQuery(name = "ImagenDiagnostica.findByRutaArchivoImagen", query = "SELECT i FROM ImagenDiagnostica i WHERE i.rutaArchivoImagen = :rutaArchivoImagen")})
public class ImagenDiagnostica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImagenDiagnosticaID")
    private Long imagenDiagnosticaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "RutaArchivoImagen")
    private String rutaArchivoImagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenDiagnosticaImagenDiagnosticaID")
    private Collection<Examen> examenCollection;

    public ImagenDiagnostica() {
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID, String rutaArchivoImagen) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
        this.rutaArchivoImagen = rutaArchivoImagen;
    }

    public Long getImagenDiagnosticaID() {
        return imagenDiagnosticaID;
    }

    public void setImagenDiagnosticaID(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public String getRutaArchivoImagen() {
        return rutaArchivoImagen;
    }

    public void setRutaArchivoImagen(String rutaArchivoImagen) {
        this.rutaArchivoImagen = rutaArchivoImagen;
    }

    @XmlTransient
    public Collection<Examen> getExamenCollection() {
        return examenCollection;
    }

    public void setExamenCollection(Collection<Examen> examenCollection) {
        this.examenCollection = examenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagenDiagnosticaID != null ? imagenDiagnosticaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImagenDiagnostica)) {
            return false;
        }
        ImagenDiagnostica other = (ImagenDiagnostica) object;
        if ((this.imagenDiagnosticaID == null && other.imagenDiagnosticaID != null) || (this.imagenDiagnosticaID != null && !this.imagenDiagnosticaID.equals(other.imagenDiagnosticaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ImagenDiagnostica[ imagenDiagnosticaID=" + imagenDiagnosticaID + " ]";
    }
    
}
