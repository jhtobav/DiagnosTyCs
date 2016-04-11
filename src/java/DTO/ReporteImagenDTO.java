/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Jaime
 */
public class ReporteImagenDTO implements Serializable {
    
    private String nombreImagen;
    private String descripcionImagen;
    private Long numImagenes;

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public Long getNumImagenes() {
        return numImagenes;
    }

    public void setNumImagenes(Long numImagenes) {
        this.numImagenes = numImagenes;
    }

    public String getDescripcionImagen() {
        return descripcionImagen;
    }

    public void setDescripcionImagen(String descripcionImagen) {
        this.descripcionImagen = descripcionImagen;
    }
    
}
