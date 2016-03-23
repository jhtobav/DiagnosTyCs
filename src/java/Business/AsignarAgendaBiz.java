/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AgendaDAO;
import DAO.DoctorDAO;
import DTO.DoctorDTO;
import Entidades.Agenda;
import Entidades.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
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
        
        AgendaDAO agendaDAO = new AgendaDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        
        List<Agenda> agendas = agendaDAO.getListAgenda();
        List<Agenda> agendasPorActualizar = new ArrayList<>();
        
        List<Doctor> doctores = doctorDAO.getDoctores("Laboratorio");
        
        HashMap listaDoctores = new HashMap();
        
        for(Doctor d : doctores){
            listaDoctores.put(d.getDoctorID(), d);
        }
                
        // Lunes Manana
        for(int i=1; i<16; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Lunes Tarde        
        for(int i=17; i<32; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Manana
        for(int i=33; i<48; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Tarde
        for (int i=49; i<64; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Miercoles Manana
        for (int i=65; i<80; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Tarde
        for(int i=81; i<96; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Manana
        for(int i=97; i<112; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Tarde
        for(int i=113; i<128; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Manana
        for(int i=129; i<144; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Tarde
        for(int i=145; i<160; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }     
        
        agendaDAO.updateAsignacionAgenda(agendasPorActualizar);
        
        return "exito";
    }

    
    public String asignarAgendaImagenBiz(Long idDoctorLunesManana, Long idDoctorLunesTarde,
                                    Long idDoctorMartesManana, Long idDoctorMartesTarde,
                                    Long idDoctorMiercolesManana, Long idDoctorMiercolesTarde,
                                    Long idDoctorJuevesManana, Long idDoctorJuevesTarde,
                                    Long idDoctorViernesManana, Long idDoctorViernesTarde){
        
        AgendaDAO agendaDAO = new AgendaDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        
        List<Agenda> agendas = agendaDAO.getListAgenda();
        List<Agenda> agendasPorActualizar = new ArrayList<>();
        
        List<Doctor> doctores = doctorDAO.getDoctores("Laboratorio");
        
        HashMap listaDoctores = new HashMap();
        
        for(Doctor d : doctores){
            listaDoctores.put(d.getDoctorID(), d);
        }
        
        // Lunes Manana
        for(int i=161; i<176; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Lunes Tarde        
        for(int i=177; i<192; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Manana
        for(int i=193; i<208; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Tarde
        for (int i=209; i<224; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Manana
        for (int i=225; i<240; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Tarde
        for(int i=241; i<256; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Manana
        for(int i=257; i<272; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Tarde
        for(int i=273; i<288; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Manana
        for(int i=289; i<304; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Tarde
        for(int i=305; i<320; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }    

        agendaDAO.updateAsignacionAgenda(agendasPorActualizar);
        
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
