/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.RegistroBiz;
import DTO.PacienteDTO;
import DTO.TarjetaDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name = "registroBean")
@SessionScoped
public class RegistroPacienteBean {

    private Long numDocPaciente = null;
    private String contrasena = null;
    private String confirmarContrasena = null;
    private String nombres = null;
    private String apellidos = null;
    private String nombrePaciente = null;
    private String fechaNacimiento = null;
    private Long telefono = null;
    private String direccion = null;
    private String correo = null;

    private String eps = null;
    private Integer numeroHijos = null;
    private String contactoNombre = null;
    private Long contactoTelefono = null;

    private Long idTarjeta = null;
    private Integer numeroAno = null;
    private Integer numeroMes = null;
    private String nombreTarjeta = null;
    private Integer csv = null;
    
    public String init(){
        
        numDocPaciente = null;
        contrasena = null;
        confirmarContrasena = null;
        nombres = null;
        apellidos = null;
        nombrePaciente = null;
        fechaNacimiento = null;
        telefono = null;
        direccion = null;
        correo = null;
    
        eps = null;
        numeroHijos = null;
        contactoNombre = null;
        contactoTelefono = null;
    
        idTarjeta = null;
        numeroAno = null;
        numeroMes = null;
        csv = null;
        
        return "registrarse.xhtml";
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public Long getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(Long contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Integer getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public Integer getNumeroAno() {
        return numeroAno;
    }

    public void setNumeroAno(Integer numeroAno) {
        this.numeroAno = numeroAno;
    }

    public Integer getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(Integer numeroMes) {
        this.numeroMes = numeroMes;
    }

    public Integer getCsv() {
        return csv;
    }

    public void setCsv(Integer csv) {
        this.csv = csv;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public Date parsearFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }

    public String registro() {

        if (contrasena.equals(confirmarContrasena)){
        
            PacienteDTO pacienteDTO = new PacienteDTO();
            TarjetaDTO tarjetaDTO = new TarjetaDTO();

            nombrePaciente = nombres + " " + apellidos;

            pacienteDTO.setNumDocPaciente(numDocPaciente);
            pacienteDTO.setContrasena(contrasena);
            pacienteDTO.setNombrePaciente(nombrePaciente);
            pacienteDTO.setFechaNacimiento(parsearFecha(fechaNacimiento));
            pacienteDTO.setTelefono(telefono);
            pacienteDTO.setDireccion(direccion);
            pacienteDTO.setCorreo(correo);
            pacienteDTO.setNombreContacto(contactoNombre);
            pacienteDTO.setTelefonoContacto(contactoTelefono);
            pacienteDTO.setEps(eps);
            pacienteDTO.setNumHijos(numeroHijos);

            tarjetaDTO.setIdTarjeta(idTarjeta);
            tarjetaDTO.setNumeroAno(numeroAno);
            tarjetaDTO.setNumeroMes(numeroMes);
            tarjetaDTO.setNombrePaciente(nombreTarjeta);
            tarjetaDTO.setCsv(csv);

            new RegistroBiz().registroPaciente(pacienteDTO, tarjetaDTO);

            LoginBean.setMensajeEmergenteTipo("SEVERITY_INFO");
            LoginBean.setMensajeEmergenteTitulo("Usuario Creado Exitosamente");
            LoginBean.setMensajeEmergenteContenido("Felicidades "
                    + nombres + " su usuario se ha creado correctamente");

            return "inicioBody.xhtml";
        
        } else {
            
            return "inicioBody.xhtml";
            
        }

    }

}
