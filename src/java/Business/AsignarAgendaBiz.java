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
        for(int i=0; i<=15; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Lunes Tarde        
        for(int i=16; i<=31; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Manana
        for(int i=32; i<=47; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Tarde
        for (int i=48; i<=63; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Miercoles Manana
        for (int i=64; i<=79; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Tarde
        for(int i=80; i<=95; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Manana
        for(int i=96; i<=111; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Tarde
        for(int i=112; i<=127; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesTarde));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Manana
        for(int i=128; i<=143; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesManana));            
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Tarde
        for(int i=144; i<=159; i++){
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
        
        List<Doctor> doctores = doctorDAO.getDoctores("ImagenesDiagnosticas");
        
        HashMap listaDoctores = new HashMap();
        
        for(Doctor d : doctores){
            listaDoctores.put(d.getDoctorID(), d);
        }
        
        // Lunes Manana
        for(int i=160; i<=175; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Lunes Tarde        
        for(int i=176; i<=191; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorLunesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Manana
        for(int i=192; i<=207; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Martes Tarde
        for (int i=208; i<=223; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMartesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Manana
        for (int i=224; i<=239; i++) {
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesManana));
            agendasPorActualizar.add(agendas.get(i));
        }

        // Miercoles Tarde
        for(int i=240; i<=255; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorMiercolesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Manana
        for(int i=256; i<=271; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Jueves Tarde
        for(int i=272; i<=287; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorJuevesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Manana
        for(int i=288; i<=303; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesManana));
            agendasPorActualizar.add(agendas.get(i));
        }
        
        // Viernes Tarde
        for(int i=304; i<=319; i++){
            agendas.get(i).setDisponible(true);
            agendas.get(i).setDoctordoctorID((Doctor) listaDoctores.get(idDoctorViernesTarde));
            agendasPorActualizar.add(agendas.get(i));
        }    

        agendaDAO.updateAsignacionAgenda(agendasPorActualizar);
        
        return "exito";
    }
    
    public List<DoctorDTO> parseDoctorDoctorDTO(String especialidad){
        
        List<Doctor> doctores = new DoctorDAO().getDoctores(especialidad);
        
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
