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
public class RegistroPacienteBean {
       
    private Long numDocPaciente;
    private String contrasena;
    private String confirmarContrasena;
    private String nombres = "";
    private String apellidos = "";
    private String nombrePaciente = "";
    private Date fechaNacimiento;
    private Long telefono;
    private String direccion;
    private String correo;
    
    private String eps;
    private int numeroHijos;
    private String contactoNombre;
    private Long contactoTelefono;
    
    private Long idTarjeta;
    private int numeroAno;
    private int numeroMes;
    private int csv;
    
    private String mensaje;

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Integer getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
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

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String registro(){

        PacienteDTO pacienteDTO = new PacienteDTO();
        TarjetaDTO tarjetaDTO = new TarjetaDTO();

        nombrePaciente = nombres + " " + apellidos;

        pacienteDTO.setNumDocPaciente(numDocPaciente);
        pacienteDTO.setContrasena(contrasena);
        pacienteDTO.setNombrePaciente(nombrePaciente);
        pacienteDTO.setFechaNacimiento(fechaNacimiento);
        pacienteDTO.setTelefono(telefono);
        pacienteDTO.setDireccion(direccion);
        pacienteDTO.setCorreo(correo);
        pacienteDTO.setNombreContacto(contactoNombre);
        pacienteDTO.setTelefonoContacto(contactoTelefono);
        pacienteDTO.setEps(eps);
        pacienteDTO.setNumHijos(numeroHijos);

        tarjetaDTO.setNombrePaciente(nombrePaciente);
        tarjetaDTO.setIdTarjeta(idTarjeta);
        tarjetaDTO.setNumeroAno(numeroAno);
        tarjetaDTO.setNumeroMes(numeroMes);
        tarjetaDTO.setCsv(csv);

        RegistroBiz registroBiz = new RegistroBiz();
        mensaje = registroBiz.registroPaciente(pacienteDTO, tarjetaDTO);
        
        LoginBean.setMensajeEmergenteTipo("SEVERITY_INFO");
        LoginBean.setMensajeEmergenteTitulo("Usuario Creado Exitosamente");
        LoginBean.setMensajeEmergenteContenido("Felicidades " + 
                nombres + " su usuario se ha creado correctamente");
        
        return "inicioBody.xhtml";

    }
     
}
