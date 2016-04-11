/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ReportesBiz;
import DTO.ReporteExamenDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="reporteExamenesBean")
@SessionScoped
public class ReporteExamenesBean {
    
    private List<ReporteExamenDTO> listaExamenes;
    private String fecha;
    
    public String init(){
        
        listaExamenes = null;
        fecha = null;
        
        return "reporteExamenes.xhtml";
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<ReporteExamenDTO> getListaExamenes() {
        return listaExamenes;
    }

    public void setListaExamenes(List<ReporteExamenDTO> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }

    public Date parsearFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public void listarCostos(){
                
        listaExamenes = new ReportesBiz().reporteExamenes(parsearFecha(fecha));
        
    }
    
}
