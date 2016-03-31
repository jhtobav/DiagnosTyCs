/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.MedicoDAO;
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

   public List<CitaDTO> parseCitaCitaDTO(Long idMedico){
    
       List<CitaDTO> citasDTO = new ArrayList<>();
       CitaDTO citaDTO;
       
       Medico medico = new MedicoDAO().searchByIdMedico(idMedico);
              
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
