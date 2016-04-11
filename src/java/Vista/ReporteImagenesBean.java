/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ReportesBiz;
import DTO.ReporteImagenDTO;
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
@ManagedBean(name="reporteImagenesBean")
@SessionScoped
public class ReporteImagenesBean {
    
    private List<ReporteImagenDTO> listaImagenes;
    private String fecha;
    
    public String init(){
        
        listaImagenes = null;
        fecha = null;
        
        return "reporteImagenes.xhtml";
        
    }

    public List<ReporteImagenDTO> getListaImagenes() {
        return listaImagenes;
    }

    public void setListaImagenes(List<ReporteImagenDTO> listaImagenes) {
        this.listaImagenes = listaImagenes;
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
    
    public void listarImagenes(){
                
        listaImagenes = new ReportesBiz().reporteImagenes(parsearFecha(fecha));
        
    }
    
}
