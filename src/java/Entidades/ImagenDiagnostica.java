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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "ImagenDiagnostica.findByDescripcion", query = "SELECT i FROM ImagenDiagnostica i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ImagenDiagnostica.findByRutaArchivo", query = "SELECT i FROM ImagenDiagnostica i WHERE i.rutaArchivo = :rutaArchivo")})
public class ImagenDiagnostica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "imagenDiagnosticaID")
    private Long imagenDiagnosticaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rutaArchivo")
    private String rutaArchivo;
    @JoinColumn(name = "ExamenImagenDiagnostica_ImagenDiagnostica_examenID", referencedColumnName = "examenID")
    @ManyToOne(optional = false)
    private Examen examenImagenDiagnosticaImagenDiagnosticaexamenID;

    public ImagenDiagnostica() {
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID, String descripcion, String rutaArchivo) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
        this.descripcion = descripcion;
        this.rutaArchivo = rutaArchivo;
    }

    public Long getImagenDiagnosticaID() {
        return imagenDiagnosticaID;
    }

    public void setImagenDiagnosticaID(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Examen getExamenImagenDiagnosticaImagenDiagnosticaexamenID() {
        return examenImagenDiagnosticaImagenDiagnosticaexamenID;
    }

    public void setExamenImagenDiagnosticaImagenDiagnosticaexamenID(Examen examenImagenDiagnosticaImagenDiagnosticaexamenID) {
        this.examenImagenDiagnosticaImagenDiagnosticaexamenID = examenImagenDiagnosticaImagenDiagnosticaexamenID;
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
