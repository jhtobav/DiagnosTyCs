/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ListarAlertasBiz;
import Entidades.Alerta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="listarAlertaBean")
@SessionScoped
public class ListarAlertasBean {
    
    private List<Alerta> alertas = new ArrayList<>();
    private String fecha;
    
    @PostConstruct
    public void init() {
    
        ListarAlertasBiz listarAlertasBiz = new ListarAlertasBiz();
                
        alertas = listarAlertasBiz.listarAlertas();
        
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
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
        
    public void listarAlertas(){
            
        ListarAlertasBiz listarAlertasBiz = new ListarAlertasBiz();
        
        alertas = listarAlertasBiz.listarAlertasDesdeFecha(parsearFecha(fecha));
        
    }
    
}
