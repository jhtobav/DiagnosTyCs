/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ModificarPerfilBiz;
import DTO.PacienteDTO;
import DTO.TarjetaDTO;
import Entidades.Paciente;
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
@ManagedBean(name="modificarPacienteBean")
@SessionScoped
public class ModificarPacienteBean {
    
    private Long numDocPaciente = null;
    private String contrasena = null;
    private String confirmarContrasena = null;
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
    private Integer csv = null;
    
    public String init() {
        
        Paciente paciente = new ModificarPerfilBiz().cargarPaciente(LoginBean.idPersonaLogueada);
        
        numDocPaciente = paciente.getNumDocumento();
        contrasena = paciente.getContrasena();
        nombrePaciente = paciente.getNombre();
        fechaNacimiento = null;
        telefono = paciente.getTelefono();
        direccion = paciente.getDireccion();
        correo = paciente.getCorreo();

        eps = paciente.getEps();
        numeroHijos = paciente.getNumHijos();
        contactoNombre = paciente.getNombreContacto();
        contactoTelefono = paciente.getTelefonoContacto();
        
        idTarjeta = paciente.getTarjetatarjetaID().getTarjetaID();
        numeroAno = paciente.getTarjetatarjetaID().getNumeroAno();
        numeroMes = paciente.getTarjetatarjetaID().getNumeroMes();
        csv = paciente.getTarjetatarjetaID().getCsv();
        
        return "modificarPaciente.xhtml";
        
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
    
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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
    
    public Date parsearFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public String modificacion() {

        PacienteDTO pacienteDTO = new PacienteDTO();
        TarjetaDTO tarjetaDTO = new TarjetaDTO();

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

        tarjetaDTO.setNombrePaciente(nombrePaciente);
        tarjetaDTO.setIdTarjeta(idTarjeta);
        tarjetaDTO.setNumeroAno(numeroAno);
        tarjetaDTO.setNumeroMes(numeroMes);
        tarjetaDTO.setCsv(csv);

        new ModificarPerfilBiz().modificarPaciente(pacienteDTO, tarjetaDTO);

        return "pacienteBody.xhtml";

    }
    
}
