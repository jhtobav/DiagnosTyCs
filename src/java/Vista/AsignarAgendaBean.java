/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.AsignarAgendaBiz;
import DTO.DoctorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Felipe
 */
@Named(value = "asignarAgenda")
@Dependent
public class AsignarAgendaBean {

    private List<DoctorDTO> doctoresLaboratorio = new ArrayList<>();
    private List<DoctorDTO> doctoresImagen = new ArrayList<>();
    private Long idDoctorLunesManana;
    private Long idDoctorLunesTarde;
    private Long idDoctorMartesManana;
    private Long idDoctorMartesTarde;
    private Long idDoctorMiercolesManana;
    private Long idDoctorMiercolesTarde;
    private Long idDoctorJuevesManana;
    private Long idDoctorJuevesTarde;
    private Long idDoctorViernesManana;
    private Long idDoctorViernesTarde;
    
    @PostConstruct
    public void init() {
        
        AsignarAgendaBiz asignarAgendaBiz = new AsignarAgendaBiz();
        
        doctoresLaboratorio = asignarAgendaBiz.parseDoctorDoctorDTO("Laboratorio");
        doctoresImagen = asignarAgendaBiz.parseDoctorDoctorDTO("ImagenesDiagnosticas");
        
    }

    public List<DoctorDTO> getDoctoresLaboratorio() {
        return doctoresLaboratorio;
    }

    public void setDoctoresLaboratorio(List<DoctorDTO> doctoresLaboratorio) {
        this.doctoresLaboratorio = doctoresLaboratorio;
    }

    public List<DoctorDTO> getDoctoresImagen() {
        return doctoresImagen;
    }

    public void setDoctoresImagen(List<DoctorDTO> doctoresImagen) {
        this.doctoresImagen = doctoresImagen;
    }

    public Long getIdDoctorLunesManana() {
        return idDoctorLunesManana;
    }

    public void setIdDoctorLunesManana(Long idDoctorLunesManana) {
        this.idDoctorLunesManana = idDoctorLunesManana;
    }

    public Long getIdDoctorLunesTarde() {
        return idDoctorLunesTarde;
    }

    public void setIdDoctorLunesTarde(Long idDoctorLunesTarde) {
        this.idDoctorLunesTarde = idDoctorLunesTarde;
    }

    public Long getIdDoctorMartesManana() {
        return idDoctorMartesManana;
    }

    public void setIdDoctorMartesManana(Long idDoctorMartesManana) {
        this.idDoctorMartesManana = idDoctorMartesManana;
    }

    public Long getIdDoctorMartesTarde() {
        return idDoctorMartesTarde;
    }

    public void setIdDoctorMartesTarde(Long idDoctorMartesTarde) {
        this.idDoctorMartesTarde = idDoctorMartesTarde;
    }

    public Long getIdDoctorMiercolesManana() {
        return idDoctorMiercolesManana;
    }

    public void setIdDoctorMiercolesManana(Long idDoctorMiercolesManana) {
        this.idDoctorMiercolesManana = idDoctorMiercolesManana;
    }

    public Long getIdDoctorMiercolesTarde() {
        return idDoctorMiercolesTarde;
    }

    public void setIdDoctorMiercolesTarde(Long idDoctorMiercolesTarde) {
        this.idDoctorMiercolesTarde = idDoctorMiercolesTarde;
    }

    public Long getIdDoctorJuevesManana() {
        return idDoctorJuevesManana;
    }

    public void setIdDoctorJuevesManana(Long idDoctorJuevesManana) {
        this.idDoctorJuevesManana = idDoctorJuevesManana;
    }

    public Long getIdDoctorJuevesTarde() {
        return idDoctorJuevesTarde;
    }

    public void setIdDoctorJuevesTarde(Long idDoctorJuevesTarde) {
        this.idDoctorJuevesTarde = idDoctorJuevesTarde;
    }

    public Long getIdDoctorViernesManana() {
        return idDoctorViernesManana;
    }

    public void setIdDoctorViernesManana(Long idDoctorViernesManana) {
        this.idDoctorViernesManana = idDoctorViernesManana;
    }

    public Long getIdDoctorViernesTarde() {
        return idDoctorViernesTarde;
    }

    public void setIdDoctorViernesTarde(Long idDoctorViernesTarde) {
        this.idDoctorViernesTarde = idDoctorViernesTarde;
    }
    
    public String asignarAgendaLaboratorio(){
        
        AsignarAgendaBiz asignarAgendaBiz = new AsignarAgendaBiz();
        
        asignarAgendaBiz.asignarAgendaLaboratorioBiz(idDoctorLunesManana, idDoctorLunesTarde, 
                idDoctorMartesManana, idDoctorMartesTarde, 
                idDoctorMiercolesManana, idDoctorMiercolesTarde, 
                idDoctorJuevesManana, idDoctorJuevesTarde, 
                idDoctorViernesManana, idDoctorViernesTarde);
        
        return "inicio.xhtml";
        
    }
    
    public String asignarAgendaImagenDiagnostica(){

        AsignarAgendaBiz asignarAgendaBiz = new AsignarAgendaBiz();
        
        asignarAgendaBiz.asignarAgendaLaboratorioBiz(idDoctorLunesManana, idDoctorLunesTarde, 
                idDoctorMartesManana, idDoctorMartesTarde, 
                idDoctorMiercolesManana, idDoctorMiercolesTarde, 
                idDoctorJuevesManana, idDoctorJuevesTarde, 
                idDoctorViernesManana, idDoctorViernesTarde);
        
        return "inicio.xhtml";
        
    }
    
}
