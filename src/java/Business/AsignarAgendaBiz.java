/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.DoctorDAO;
import DTO.DoctorDTO;
import Entidades.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class AsignarAgendaBiz {
    
    public List<DoctorDTO> parseDoctorDoctorDTO(String especialidad){
        
        DoctorDAO doctorDAO = new DoctorDAO();
        
        List<Doctor> doctores = doctorDAO.getDoctores(especialidad);
        
        List<DoctorDTO> doctoresDTO = new ArrayList<>();
        DoctorDTO doctorDTO;

        for (Doctor doctor : doctores){
            
            doctorDTO = new DoctorDTO();
            doctorDTO.setIdDoctor(doctor.getDoctorID());
            doctorDTO.setNombreDoctor(doctor.getPersonapersonaID().getNombre());
            doctorDTO.setEspecialidad(doctor.getEspecialidad());
            doctorDTO.setSalario(doctor.getSalario());
            doctoresDTO.add(doctorDTO);
            
        }
        
        return doctoresDTO;
    }
    
}
