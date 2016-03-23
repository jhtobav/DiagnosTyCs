/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.AsignarAgendaBiz;
import DTO.DoctorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Felipe
 */
@Named(value = "asignarAgenda")
@Dependent
public class AsignarAgendaBean {

    private List<DoctorDTO> doctoresLaboratorio = new ArrayList<>();
    private List<DoctorDTO> doctoresImagen = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        
        AsignarAgendaBiz asignarAgendaBiz = new AsignarAgendaBiz();
        
        doctoresLaboratorio = asignarAgendaBiz.parseDoctorDoctorDTO("Laboratorio");
        doctoresImagen = asignarAgendaBiz.parseDoctorDoctorDTO("ImagenesDiagnosticas");
        
    }

    public List<DoctorDTO> getDoctoresLaboratorio() {
        return doctoresLaboratorio;
    }

    public void setDoctoresLaboratorio(List<DoctorDTO> doctoresLaboratorio) {
        this.doctoresLaboratorio = doctoresLaboratorio;
    }

    public List<DoctorDTO> getDoctoresImagen() {
        return doctoresImagen;
    }

    public void setDoctoresImagen(List<DoctorDTO> doctoresImagen) {
        this.doctoresImagen = doctoresImagen;
    }
    
    public String asignarAgenda(){
        
        return "inicio.xhtml";
        
    }
    
}
