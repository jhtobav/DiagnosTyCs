/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.SolicitarCitaBiz;
import DTO.ExamenDTO;
import Entidades.Agenda;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="solicitarCitaBean")
@SessionScoped
public class SolicitarCitaBean {
        
    private List<Agenda> tablaAgendas;
    private String examenLaboratorio;
    private String imagenDiagnostica;
    private int numCelda;

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

    public String getExamenLaboratorio() {
        return examenLaboratorio;
    }

    public void setExamenLaboratorio(String examenLaboratorio) {
        this.examenLaboratorio = examenLaboratorio;
    }

    public String getImagenDiagnostica() {
        return imagenDiagnostica;
    }

    public void setImagenDiagnostica(String imagenDiagnostica) {
        this.imagenDiagnostica = imagenDiagnostica;
    }

    public int getNumCelda() {
        return numCelda;
    }

    public void setNumCelda(int numCelda) {
        this.numCelda = numCelda;
    }
    
    public String obtenerEstado(int indice){
        
        if(tablaAgendas.get(indice-1).getDisponible()){
            return "button";
        } else {
            return "hidden";
        }
        
    }
    
    public String solicitarCitaImagen(){
        
        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();
        
        List<ExamenDTO> imagenes = solicitarCitaBiz.cargarImagenes();
        
        for (ExamenDTO examen : imagenes){
            if(examen.getDescripcion().trim().trim()
                    .equals(imagenDiagnostica.trim().trim())){
                System.out.println("exito");
                System.out.println("- " + imagenDiagnostica.trim().trim() + " -");
                System.out.println("- " + examen.getDescripcion().trim().trim() + " -");
                
                solicitarCitaBiz.solicitarCitaImagen(examen, tablaAgendas.get(numCelda-1));
                break;
            }
        }
        
        return "inicio.xhtml";
    }
    
    public String solicitarCitaLaboratorio(){
                
        System.out.println("chiao");
        System.out.println(examenLaboratorio);
        
        return "inicio.xhtml";
    }
        
}
