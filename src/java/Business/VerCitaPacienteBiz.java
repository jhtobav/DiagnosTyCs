/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.CitaDTO;
import Entidades.Cita;
import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class VerCitaPacienteBiz {

   public List<CitaDTO> parseCitaCitaDTO(Paciente paciente){
    
       List<CitaDTO> citasDTO = new ArrayList<>();
       CitaDTO citaDTO;
       
       System.out.println(paciente.getPacienteID());
              
       for(Cita c : paciente.getCitaCollection()){
           
           citaDTO = new CitaDTO();
           citaDTO.setCitaID(c.getCitaID());
           citaDTO.setNombreDoctor(c.getDoctordoctorID().getPersonapersonaID().getNombre());
           citaDTO.setNombreMedico(c.getMedicomedicoID().getPersonapersonaID().getNombre());
           citaDTO.setFecha(c.getHoraInicio());
           citaDTO.setValor(c.getValor());
           citasDTO.add(citaDTO);
           
       }    
       
       return citasDTO;
       
   }
    
}
