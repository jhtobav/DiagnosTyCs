/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.RegistroBiz;
import DTO.PersonaDTO;
import DTO.TarjetaDTO;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="registroBean")
@SessionScoped
public class RegistroBean {
       
    public static Long idPersona;
    String contrasena;
    String nombrePersona;
    int edad;
    Long telefono;
    String direccion;
    String correo;
    Long idTarjeta;
    Date fechaVencimiento;

    public static Long getIdPersona() {
        return idPersona;
    }

    public static void setIdPersona(Long idPersona) {
        RegistroBean.idPersona = idPersona;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String registro(){
                
        idPersona = 1023928372L;
        contrasena = "123456";
        nombrePersona = "Jaime Toba";
        edad = 22;
        telefono = 3015023413L;
        direccion = "Cll 22B Sur N 1-07 Este";
        correo = "jhtobav@gmail.com";
        idTarjeta = 192665512L;
        fechaVencimiento = new Date();
        
        PersonaDTO personaDTO = new PersonaDTO();       
        personaDTO.setIdPersona(idPersona);
        personaDTO.setContrasena(contrasena);
        personaDTO.setNombrePersona(nombrePersona);
        personaDTO.setEdad(edad);
        personaDTO.setTelefono(telefono);
        personaDTO.setDireccion(direccion);
        personaDTO.setCorreo(correo);
        
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setNombrePersona(nombrePersona);
        tarjetaDTO.setIdTarjeta(idTarjeta);
        tarjetaDTO.setFechaVencimiento(fechaVencimiento);
        
        RegistroBiz registroBiz = new RegistroBiz();
        String mensaje = registroBiz.registroPaciente(personaDTO, tarjetaDTO);

        return mensaje;
        
    }
}
