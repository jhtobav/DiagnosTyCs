/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.LoginBiz;
import Business.SolicitarCitaBiz;
import DTO.LoginDTO;
import Entidades.Administrador;
import Entidades.Agenda;
import Entidades.Doctor;
import Entidades.Gerente;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="solicitarCitaBean")
@SessionScoped
public class SolicitarCitaBean {
        
    private List<Agenda> tablaAgendas;

    @PostConstruct
    public void init() {
        
        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();
        
        tablaAgendas = solicitarCitaBiz.cargarAgenda();
        
    }

    public List<Agenda> getTablaAgendas() {
        return tablaAgendas;
    }

    public void setTablaAgendas(List<Agenda> tablaAgendas) {
        this.tablaAgendas = tablaAgendas;
    }
    
    public String solicitarCita(){
                
        return "inicio.xhtml";
    }
        
}
