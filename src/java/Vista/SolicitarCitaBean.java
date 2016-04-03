/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.SolicitarCitaBiz;
import DTO.ExamenDTO;
import DTO.MedicoDTO;
import Entidades.Agenda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@ManagedBean(name="solicitarCitaBean")
@SessionScoped
public class SolicitarCitaBean {
        
    private List<Agenda> tablaAgendas = new ArrayList<>();
    private List<MedicoDTO> medicos = new ArrayList<>();
    
    private String examenLaboratorio;
    private String imagenDiagnostica;
    private int numCelda;
    private String fecha;
    private Long medico;
    private Integer csv;

    public String init(String tipoExamen) {
        
        tablaAgendas = new ArrayList<>();
        medicos = new ArrayList<>();
        
        fecha = null;
        
        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();
        
        tablaAgendas = solicitarCitaBiz.cargarAgenda();
        medicos = solicitarCitaBiz.parseMedicoMedicoDTO();
        
        if (tipoExamen.equals("Laboratorio")) {
            return "solicitarCitaLaboratorio.xhtml";
        } else {
            return "solicitarCitaImagen.xhtml";
        }
        
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public List<Agenda> getTablaAgendas() {
        return tablaAgendas;
    }

    public void setTablaAgendas(List<Agenda> tablaAgendas) {
        this.tablaAgendas = tablaAgendas;
    }

    public List<MedicoDTO> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoDTO> medicos) {
        this.medicos = medicos;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCsv() {
        return csv;
    }

    public void setCsv(Integer csv) {
        this.csv = csv;
    }
    
    public String obtenerEstado(int indice){
        
        if(tablaAgendas.get(indice-1).getDisponible()){
            return "button";
        } else {
            return "hidden";
        }
        
    }
    
    public Date parsearFecha(String fecha){
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public String solicitarCitaImagen(){

        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();
        
        List<ExamenDTO> imagenes = solicitarCitaBiz.cargarImagenes();

        for (ExamenDTO imagen : imagenes){

            System.out.println("- " + imagenDiagnostica.trim().trim() + " -");          
            System.out.println("- " + imagen.getDescripcion().trim().trim() + " -");
            
            if(imagen.getDescripcion().trim().trim().trim()
                    .equals(imagenDiagnostica.trim().trim())){
                
                System.out.println("exito");
                solicitarCitaBiz.solicitarCitaImagen(csv, imagen, tablaAgendas.get(numCelda-1), parsearFecha(fecha), medico);
                break;
            
            }
        }
        
        return "pacienteBody.xhtml";
    }
    
    public String solicitarCitaLaboratorio(){
        
        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();
        
        List<ExamenDTO> examenes = solicitarCitaBiz.cargarExamenesLaboratorio();
        
        for(ExamenDTO examen : examenes){
            
            System.out.println("- " + examenLaboratorio + " -");
            System.out.println("- " + examen.getNombre() + " -");
            
            if(examen.getNombre().equals(examenLaboratorio)){
                
                System.out.println("exito");
                solicitarCitaBiz.solicitarCitaExamenLaboratorio(csv, examen, examenes, tablaAgendas.get(numCelda-1), parsearFecha(fecha), medico);                
                break;
                
            }
            
        }
                
        return "pacienteBody.xhtml";
    }
        
}
