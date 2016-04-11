/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.DoctorDAO;
import DAO.GastoDAO;
import DTO.DoctorDTO;
import Entidades.Doctor;
import Entidades.Gasto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class PagoNominaBiz {
    
    public List<DoctorDTO> parseDoctorDoctorDTO(){
        
        List<Doctor> doctores = new DoctorDAO().getDoctores();
        
        List<DoctorDTO> doctoresDTO = new ArrayList<>();
        DoctorDTO doctorDTO;

        for (Doctor doctor : doctores){
            
            if(doctor.getPersonapersonaID().getEstadoCuenta()){
                
                doctorDTO = new DoctorDTO();
                doctorDTO.setIdDoctor(doctor.getDoctorID());
                doctorDTO.setNombreDoctor(doctor.getPersonapersonaID().getNombre());
                doctorDTO.setEspecialidad(doctor.getEspecialidad());
                doctorDTO.setSalario(doctor.getSalario());
                doctoresDTO.add(doctorDTO);
                
            }
            
        }
        
        return doctoresDTO;
    }
    
    public String pagoNomina(Long costoNomina, int cantidadDoctores, Long salarioPromedio){
           
        Gasto gasto = new Gasto();

        gasto.setTipo("Pago de Nomina");
        gasto.setDescripcion("Pago de Nomina a Doctores"); 
        gasto.setFecha(new Date());
        gasto.setCosto(costoNomina);
        gasto.setCantidad(cantidadDoctores);
        gasto.setValorUnidad(salarioPromedio);
        
        new GastoDAO().createGasto(gasto);
        
        return "exito";
        
    }
    
}
