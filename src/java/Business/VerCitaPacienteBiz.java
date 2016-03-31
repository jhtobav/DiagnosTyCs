/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PacienteDAO;
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

   public List<CitaDTO> parseCitaCitaDTO(Long idPaciente){
    
       List<CitaDTO> citasDTO = new ArrayList<>();
       CitaDTO citaDTO;
       
       Paciente paciente = new PacienteDAO().searchByIdPaciente(idPaciente);
              
       for(Cita c : paciente.getCitaCollection()){
           
           citaDTO = new CitaDTO();
           citaDTO.setCitaID(c.getCitaID());
           citaDTO.setNombreMedico(c.getMedicomedicoID().getPersonapersonaID().getNombre());
           citaDTO.setNombreDoctor(c.getDoctordoctorID().getPersonapersonaID().getNombre());
           citaDTO.setFecha(c.getFecha());
           citaDTO.setValor(c.getValor());
           citaDTO.setCita(c);
           citaDTO.setIdPaciente(c.getPacientepacienteID().getPacienteID());
           citaDTO.setNombrePaciente(c.getMedicomedicoID().getPersonapersonaID().getNombre());
           citasDTO.add(citaDTO);
           
       }    
       
       return citasDTO;
       
   }
    
}
