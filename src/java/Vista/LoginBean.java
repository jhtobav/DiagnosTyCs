/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.LoginBiz;
import DTO.LoginDTO;
import Entidades.Administrador;
import Entidades.Doctor;
import Entidades.Gerente;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Persona;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("DiagnosTyCsPU");
    
    public static Long idPersona;
    String contrasena;
    String nombrePersona;
    String visible="none";
    
    public static Persona persona = null;
    public static Medico medico = null;
    public static Paciente paciente = null;
    public static Administrador administrador = null;
    public static Gerente gerente = null;
    public static Doctor doctor = null;
       
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    
    public String getVisible() {
        return visible;
    }
    
    public void setVisible(String visible) {
        this.visible = visible;
    }

    public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        LoginBean.persona = persona;
    }

    public static Medico getMedico() {
        return medico;
    }

    public static void setMedico(Medico medico) {
        LoginBean.medico = medico;
    }

    public static Paciente getPaciente() {
        return paciente;
    }

    public static void setPaciente(Paciente paciente) {
        LoginBean.paciente = paciente;
    }

    public static Administrador getAdministrador() {
        return administrador;
    }

    public static void setAdministrador(Administrador administrador) {
        LoginBean.administrador = administrador;
    }

    public static Gerente getGerente() {
        return gerente;
    }

    public static void setGerente(Gerente gerente) {
        LoginBean.gerente = gerente;
    }

    public static Doctor getDoctor() {
        return doctor;
    }

    public static void setDoctor(Doctor doctor) {
        LoginBean.doctor = doctor;
    }
    
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        LoginBean.emf = emf;
    }   

    public String login(){
        
        visible = "none";
        
        LoginDTO loginDTO = new LoginDTO();       
        loginDTO.setIdPersona(idPersona);
        loginDTO.setContrasena(contrasena);
        
        LoginBiz loginBiz = new LoginBiz();
        loginDTO = loginBiz.login(loginDTO);
        
        if(loginDTO.getMensaje().equals("error")){
            visible = "initial";
            return "inicio.xhtml";                   
        }else{
            return loginDTO.getMensaje();
        }

    }
    
    @PreDestroy
    public void destruct()
    {
        emf.close();
    }
}
