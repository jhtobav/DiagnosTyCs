/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.RegistroBiz;
import DTO.PersonaDTO;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="registroMedicoBean")
@SessionScoped
public class RegistroMedicoBean {
       
    private Long numDocMedico;
    private String contrasena;
    private String confirmarContrasena;
    private String nombres = "";
    private String apellidos = "";
    private String nombreMedico = "";
    private Date fechaNacimiento;
    private Long telefono;
    private String direccion;
    private String correo;
    private String mensaje;

    public Long getNumDocMedico() {
        return numDocMedico;
    }

    public void setNumDocMedico(Long numDocMedico) {
        this.numDocMedico = numDocMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String registro(){

        PersonaDTO personaDTO = new PersonaDTO();

        nombreMedico = nombres + " " + apellidos;

        personaDTO.setIdPersona(numDocMedico);
        personaDTO.setContrasena(contrasena);
        personaDTO.setNombrePersona(nombreMedico);
        personaDTO.setFechaNacimiento(fechaNacimiento);
        personaDTO.setTelefono(telefono);
        personaDTO.setDireccion(direccion);
        personaDTO.setCorreo(correo);

        RegistroBiz registroBiz = new RegistroBiz();
        mensaje = registroBiz.registroMedico(personaDTO);
        
        LoginBean.setMensajeEmergenteTipo("SEVERITY_INFO");
        LoginBean.setMensajeEmergenteTitulo("Medico Creado Exitosamente");
        LoginBean.setMensajeEmergenteContenido("Felicidades " + 
                nombres + " su usuario se ha creado correctamente");
        
        return "medicoBody.xhtml";

    }
     
}
