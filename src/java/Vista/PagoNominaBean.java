/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.PagoNominaBiz;
import DTO.DoctorDTO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="pagoNominaBean")
@SessionScoped
public class PagoNominaBean {
    
    private List<DoctorDTO> listaDoctores;
    private Long costoNomina;
    private Long salarioPromedio;
        
    public String init(){
        
        costoNomina = 0l;
        salarioPromedio = 0l;
        
        listaDoctores = new PagoNominaBiz().parseDoctorDoctorDTO();
        
        for (DoctorDTO doctorDTO : listaDoctores){
            
            costoNomina += doctorDTO.getSalario();
            
        }
        
        salarioPromedio = costoNomina / listaDoctores.size();
        
        return "pagoNomina.xhtml";
        
    }

    public List<DoctorDTO> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(List<DoctorDTO> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public Long getCostoNomina() {
        return costoNomina;
    }

    public void setCostoNomina(Long costoNomina) {
        this.costoNomina = costoNomina;
    }

    public Long getSalarioPromedio() {
        return salarioPromedio;
    }

    public void setSalarioPromedio(Long salarioPromedio) {
        this.salarioPromedio = salarioPromedio;
    }
    
    public String pagarNomina(){
        
        new PagoNominaBiz().pagoNomina(costoNomina, listaDoctores.size(), salarioPromedio);
        
        return "gerenteBody.xhtml";
        
    }
    
}
