/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ReportesBiz;
import Entidades.Gasto;
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
@ManagedBean(name="reporteCostosBean")
@SessionScoped
public class ReporteCostosBean {
    
    private List<Gasto> listaCostos;
    private String fecha;
    private String tipoCosto;
    
    public String init(){
        
        listaCostos = null;
        fecha = null;
        tipoCosto = null;
        
        return "reporteCostos.xhtml";
        
    }

    public List<Gasto> getListaCostos() {
        return listaCostos;
    }

    public void setListaCostos(List<Gasto> listaCostos) {
        this.listaCostos = listaCostos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(String tipoCosto) {
        this.tipoCosto = tipoCosto;
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
        
        listaCostos = new ReportesBiz().reporteCostos(tipoCosto, parsearFecha(fecha));
        
    }
    
}
