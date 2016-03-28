/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.CitaDTO;
import Entidades.Cita;
import Entidades.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class VerCitaMedicoBiz {

   public List<CitaDTO> parseCitaCitaDTO(Medico medico){
    
       List<CitaDTO> citasDTO = new ArrayList<>();
       CitaDTO citaDTO;
              
       for(Cita c : medico.getCitaCollection()){
           
           citaDTO = new CitaDTO();
           citaDTO.setCitaID(c.getCitaID());
           citaDTO.setNombreMedico(c.getMedicomedicoID().getPersonapersonaID().getNombre());
           citaDTO.setNombreDoctor(c.getDoctordoctorID().getPersonapersonaID().getNombre());
           citaDTO.setFecha(c.getFecha());
           citaDTO.setValor(c.getValor());
           citaDTO.setCita(c);
           citaDTO.setIdPaciente(c.getPacientepacienteID().getPacienteID());
           citaDTO.setNombrePaciente(c.getPacientepacienteID().getNombre());
           citasDTO.add(citaDTO);
           
       }    
       
       return citasDTO;
       
   }
    
}
