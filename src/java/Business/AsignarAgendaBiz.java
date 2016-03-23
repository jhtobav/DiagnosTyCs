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
    
    public String asignarAgendaLaboratorioBiz(Long idDoctorLunesManana, Long idDoctorLunesTarde,
                                    Long idDoctorMartesManana, Long idDoctorMartesTarde,
                                    Long idDoctorMiercolesManana, Long idDoctorMiercolesTarde,
                                    Long idDoctorJuevesManana, Long idDoctorJuevesTarde,
                                    Long idDoctorViernesManana, Long idDoctorViernesTarde){
        
        // Lunes Manana
        for(int i=1; i<16; i++){
            
        }

        // Lunes Tarde        
        for(int i=17; i<32; i++){
            
        }
        
        // Martes Manana
        for(int i=33; i<48; i++){
            
        }
        
        // Martes Tarde
        for (int i=49; i<64; i++) {

        }
        
        // Miercoles Manana
        for (int i=65; i<80; i++) {

        }

        // Miercoles Tarde
        for(int i=81; i<96; i++){
            
        }
        
        // Jueves Manana
        for(int i=97; i<112; i++){
            
        }
        
        // Jueves Tarde
        for(int i=113; i<128; i++){
            
        }
        
        // Viernes Manana
        for(int i=129; i<144; i++){
            
        }
        
        // Viernes Tarde
        for(int i=145; i<160; i++){
            
        }     
        
        return "exito";
    }

    
    public String asignarAgendaImagenBiz(Long idDoctorLunesManana, Long idDoctorLunesTarde,
                                    Long idDoctorMartesManana, Long idDoctorMartesTarde,
                                    Long idDoctorMiercolesManana, Long idDoctorMiercolesTarde,
                                    Long idDoctorJuevesManana, Long idDoctorJuevesTarde,
                                    Long idDoctorViernesManana, Long idDoctorViernesTarde){
        
        // Lunes Manana
        for(int i=161; i<176; i++){
            
        }

        // Lunes Tarde        
        for(int i=177; i<192; i++){
            
        }
        
        // Martes Manana
        for(int i=193; i<208; i++){
            
        }
        
        // Martes Tarde
        for (int i=209; i<224; i++) {

        }

        // Miercoles Manana
        for (int i=225; i<240; i++) {

        }

        // Miercoles Tarde
        for(int i=241; i<256; i++){
            
        }
        
        // Jueves Manana
        for(int i=257; i<272; i++){
            
        }
        
        // Jueves Tarde
        for(int i=273; i<288; i++){
            
        }
        
        // Viernes Manana
        for(int i=289; i<304; i++){
            
        }
        
        // Viernes Tarde
        for(int i=305; i<320; i++){
            
        }            
        
        return "exito";
    }
    
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
