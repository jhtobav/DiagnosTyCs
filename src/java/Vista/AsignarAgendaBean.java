/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DTO.DoctorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Felipe
 */
@Named(value = "asignarAgenda")
@Dependent
public class AsignarAgendaBean {

    private List<DoctorDTO> doctores = new ArrayList<>();
    
    public AsignarAgendaBean() {
    }

    public List<DoctorDTO> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<DoctorDTO> doctores) {
        this.doctores = doctores;
    }
    
    public String asignarAgenda(){
        
        return "inicio.xhtml";
        
    }
    
}
