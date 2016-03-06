/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.RegistroBiz;
import DTO.PacienteDTO;
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
       
    public static Long numDocPaciente;
    String contrasena;
    String nombrePaciente;
    int edad;
    Long telefono;
    String direccion;
    String correo;
    Long idTarjeta;
    Date fechaVencimiento;

    public static Long getNumDocPaciente() {
        return numDocPaciente;
    }

    public static void setNumDocPaciente(Long numDocPaciente) {
        RegistroBean.numDocPaciente = numDocPaciente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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
                
        numDocPaciente = 1023928372L;
        contrasena = "123456";
        nombrePaciente = "Jaime Toba";
        edad = 22;
        telefono = 3015023413L;
        direccion = "Cll 22B Sur N 1-07 Este";
        correo = "jhtobav@gmail.com";
        idTarjeta = 192665512L;
        fechaVencimiento = new Date();
        
        PacienteDTO pacienteDTO = new PacienteDTO();       
        pacienteDTO.setNumDocPaciente(numDocPaciente);
        pacienteDTO.setContrasena(contrasena);
        pacienteDTO.setNombrePaciente(nombrePaciente);
        pacienteDTO.setEdad(edad);
        pacienteDTO.setTelefono(telefono);
        pacienteDTO.setDireccion(direccion);
        pacienteDTO.setCorreo(correo);
        
        TarjetaDTO tarjetaDTO = new TarjetaDTO();
        tarjetaDTO.setNombrePaciente(nombrePaciente);
        tarjetaDTO.setIdTarjeta(idTarjeta);
        tarjetaDTO.setFechaVencimiento(fechaVencimiento);
        
        RegistroBiz registroBiz = new RegistroBiz();
        String mensaje = registroBiz.registroPaciente(pacienteDTO, tarjetaDTO);

        return mensaje;
        
    }
}
