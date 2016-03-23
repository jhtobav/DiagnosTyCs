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
    public List<DoctorDTO> obtenerDoctores(String especialidad){
        
        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctores = doctorDAO.getDoctors(especialidad);
        for(Doctor d : doctores){
        }
        List<DoctorDTO> doctoresDTO = new ArrayList<>();
        return null;
    }
}
