/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ReportesBiz;
import DTO.ReporteGananciasDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="reporteGananciasBean")
@SessionScoped
public class ReporteGananciasBean {
    
    private Long noExamenesLaboratorio;
    private Long gastoExamenesLaboratorio;
    private Long ingresoExamenesLaboratorio;
    private Long gananciasExamenesLaboratorio;   
    
    private Long noImagenes;
    private Long gastoImagenes;
    private Long ingresoImagenes;
    private Long gananciasImagenes;
    
    private String fecha;
    
    public String init(){
        
        noExamenesLaboratorio = null;
        gastoExamenesLaboratorio = null;
        ingresoExamenesLaboratorio = null;
        gananciasExamenesLaboratorio = null;

        noImagenes = null;
        gastoImagenes = null;
        ingresoImagenes = null;
        gananciasImagenes = null;

        fecha = null;

        return "reporteGanancias.xhtml";
        
    }

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date parsearFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public void listarGanancias(){
                
        ReporteGananciasDTO reporteGananciasDTO = new ReportesBiz().reporteGanancias(parsearFecha(fecha));
        
        noExamenesLaboratorio = reporteGananciasDTO.getNoExamenesLaboratorio();
        gastoExamenesLaboratorio = reporteGananciasDTO.getGastoExamenesLaboratorio();
        ingresoExamenesLaboratorio = reporteGananciasDTO.getIngresoExamenesLaboratorio();
        gananciasExamenesLaboratorio = reporteGananciasDTO.getGananciasExamenesLaboratorio();

        noImagenes = reporteGananciasDTO.getNoImagenes();
        gastoImagenes = reporteGananciasDTO.getGastoImagenes();
        ingresoImagenes = reporteGananciasDTO.getIngresoImagenes();
        gananciasImagenes = reporteGananciasDTO.getGananciasImagenes();      
        
    }
    
}
