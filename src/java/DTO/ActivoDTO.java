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
public class ActivoDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private Long valor;
    private Long unidadesExistentes;
    private Long unidadesNuevas;

    public ActivoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getUnidadesExistentes() {
        return unidadesExistentes;
    }

    public void setUnidadesExistentes(Long unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }

    public Long getUnidadesNuevas() {
        return unidadesNuevas;
    }

    public void setUnidadesNuevas(Long unidadesNuevas) {
        this.unidadesNuevas = unidadesNuevas;
    }
    
}
