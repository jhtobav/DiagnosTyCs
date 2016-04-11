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
    private Long numImagen;

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public Long getNumImagen() {
        return numImagen;
    }

    public void setNumImagen(Long numImagen) {
        this.numImagen = numImagen;
    }

    
    
}
