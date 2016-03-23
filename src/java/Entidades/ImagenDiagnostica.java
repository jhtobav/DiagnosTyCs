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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ImagenDiagnostica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagenDiagnostica.findAll", query = "SELECT i FROM ImagenDiagnostica i"),
    @NamedQuery(name = "ImagenDiagnostica.findByImagenDiagnosticaID", query = "SELECT i FROM ImagenDiagnostica i WHERE i.imagenDiagnosticaID = :imagenDiagnosticaID"),
    @NamedQuery(name = "ImagenDiagnostica.findByNombre", query = "SELECT i FROM ImagenDiagnostica i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "ImagenDiagnostica.findByDescripcion", query = "SELECT i FROM ImagenDiagnostica i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ImagenDiagnostica.findByRutaImagen", query = "SELECT i FROM ImagenDiagnostica i WHERE i.rutaImagen = :rutaImagen"),
    @NamedQuery(name = "ImagenDiagnostica.findByValor", query = "SELECT i FROM ImagenDiagnostica i WHERE i.valor = :valor")})
public class ImagenDiagnostica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "imagenDiagnosticaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long imagenDiagnosticaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rutaImagen")
    private String rutaImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @JoinColumn(name = "CitaImagenDiagnostica_ImagenDiagnostica_citaID", referencedColumnName = "citaID")
    @ManyToOne(optional = true)
    private Cita citaImagenDiagnosticaImagenDiagnosticacitaID;
    @JoinColumn(name = "Reactivo_reactivoID", referencedColumnName = "reactivoID")
    @OneToOne(optional = false)
    private Reactivo reactivoreactivoID;

    public ImagenDiagnostica() {
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public ImagenDiagnostica(Long imagenDiagnosticaID, String nombre, String descripcion, String rutaImagen, long valor) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.valor = valor;
    }

    public Long getImagenDiagnosticaID() {
        return imagenDiagnosticaID;
    }

    public void setImagenDiagnosticaID(Long imagenDiagnosticaID) {
        this.imagenDiagnosticaID = imagenDiagnosticaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Cita getCitaImagenDiagnosticaImagenDiagnosticacitaID() {
        return citaImagenDiagnosticaImagenDiagnosticacitaID;
    }

    public void setCitaImagenDiagnosticaImagenDiagnosticacitaID(Cita citaImagenDiagnosticaImagenDiagnosticacitaID) {
        this.citaImagenDiagnosticaImagenDiagnosticacitaID = citaImagenDiagnosticaImagenDiagnosticacitaID;
    }

    public Reactivo getReactivoreactivoID() {
        return reactivoreactivoID;
    }

    public void setReactivoreactivoID(Reactivo reactivoreactivoID) {
        this.reactivoreactivoID = reactivoreactivoID;
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
