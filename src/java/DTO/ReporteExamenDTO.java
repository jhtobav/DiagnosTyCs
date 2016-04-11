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
public class ReporteExamenDTO implements Serializable {
    
    private String nombreExamen;
    private String descripcionExamen;
    private Long numExamenes;
    private Double promedioExamen;   

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public Long getNumExamenes() {
        return numExamenes;
    }

    public void setNumExamenes(Long numExamenes) {
        this.numExamenes = numExamenes;
    }

    public Double getPromedioExamen() {
        return promedioExamen;
    }

    public void setPromedioExamen(Double promedioExamen) {
        this.promedioExamen = promedioExamen;
    }

    public String getDescripcionExamen() {
        return descripcionExamen;
    }

    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
    }

    
}
