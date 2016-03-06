/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Jaime
 */
public class PacienteDTO implements Serializable {
    
    private Long numDocPaciente;
    private String contrasena;
    private String nombrePaciente;
    private int Edad;
    private Long Telefono;
    private String direccion;
    private String correo;
   
    public PacienteDTO() {
    }

    public Long getNumDocPaciente() {
        return numDocPaciente;
    }

    public void setNumDocPaciente(Long numDocPaciente) {
        this.numDocPaciente = numDocPaciente;
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
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long Telefono) {
        this.Telefono = Telefono;
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

}
