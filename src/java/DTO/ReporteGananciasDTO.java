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
public class ReporteGananciasDTO implements Serializable {
    
    private Long noExamenesLaboratorio;
    private Long gastoExamenesLaboratorio;
    private Long ingresoExamenesLaboratorio;
    private Long gananciasExamenesLaboratorio;   
    
    private Long noImagenes;
    private Long gastoImagenes;
    private Long ingresoImagenes;
    private Long gananciasImagenes;

    public Long getNoExamenesLaboratorio() {
        return noExamenesLaboratorio;
    }

    public void setNoExamenesLaboratorio(Long noExamenesLaboratorio) {
        this.noExamenesLaboratorio = noExamenesLaboratorio;
    }

    public Long getGastoExamenesLaboratorio() {
        return gastoExamenesLaboratorio;
    }

    public void setGastoExamenesLaboratorio(Long gastoExamenesLaboratorio) {
        this.gastoExamenesLaboratorio = gastoExamenesLaboratorio;
    }

    public Long getIngresoExamenesLaboratorio() {
        return ingresoExamenesLaboratorio;
    }

    public void setIngresoExamenesLaboratorio(Long ingresoExamenesLaboratorio) {
        this.ingresoExamenesLaboratorio = ingresoExamenesLaboratorio;
    }

    public Long getGananciasExamenesLaboratorio() {
        return gananciasExamenesLaboratorio;
    }

    public void setGananciasExamenesLaboratorio(Long gananciasExamenesLaboratorio) {
        this.gananciasExamenesLaboratorio = gananciasExamenesLaboratorio;
    }

    public Long getNoImagenes() {
        return noImagenes;
    }

    public void setNoImagenes(Long noImagenes) {
        this.noImagenes = noImagenes;
    }

    public Long getGastoImagenes() {
        return gastoImagenes;
    }

    public void setGastoImagenes(Long gastoImagenes) {
        this.gastoImagenes = gastoImagenes;
    }

    public Long getIngresoImagenes() {
        return ingresoImagenes;
    }

    public void setIngresoImagenes(Long ingresoImagenes) {
        this.ingresoImagenes = ingresoImagenes;
    }

    public Long getGananciasImagenes() {
        return gananciasImagenes;
    }

    public void setGananciasImagenes(Long gananciasImagenes) {
        this.gananciasImagenes = gananciasImagenes;
    }

    
}
