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
public class ExamenDTO implements Serializable {
    
    private String nombre;
    private String descripcion;
    private Long idReactivo;    

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

    public Long getIdReactivo() {
        return idReactivo;
    }

    public void setIdReactivo(Long idReactivo) {
        this.idReactivo = idReactivo;
    }
    
}
