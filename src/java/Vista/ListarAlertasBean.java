/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ListarAlertasBiz;
import Entidades.Alerta;
import java.util.ArrayList;
import java.util.List;
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
    
}
