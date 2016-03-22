/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.RegistroBiz;
import DTO.PersonaDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="registroAdministradorBean")
@SessionScoped
public class RegistroAdministradorBean {
       
    private Long numDocAdministrador;
    private String contrasena;
    private String confirmarContrasena;
    private String nombres = "";
    private String apellidos = "";
    private String nombreAdministrador = "";
    private Long edad;
    private Long telefono;
    private String direccion;
    private String correo;
    private String mensaje;

    public Long getNumDocAdministrador() {
        return numDocAdministrador;
    }

    public void setNumDocAdministrador(Long numDocAdministrador) {
        this.numDocAdministrador = numDocAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
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

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
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

        nombreAdministrador = nombres + " " + apellidos;

        personaDTO.setIdPersona(numDocAdministrador);
        personaDTO.setContrasena(contrasena);
        personaDTO.setNombrePersona(nombreAdministrador);
        personaDTO.setEdad(edad.intValue());
        personaDTO.setTelefono(telefono);
        personaDTO.setDireccion(direccion);
        personaDTO.setCorreo(correo);

        RegistroBiz registroBiz = new RegistroBiz();
        mensaje = registroBiz.registroAdministrador(personaDTO);
        
        LoginBean.setMensajeEmergenteTipo("SEVERITY_INFO");
        LoginBean.setMensajeEmergenteTitulo("Administrador Creado Exitosamente");
        LoginBean.setMensajeEmergenteContenido("Felicidades " + 
                nombres + " su usuario se ha creado correctamente");
        
        return "administradorBody.xhtml";

    }
     
}