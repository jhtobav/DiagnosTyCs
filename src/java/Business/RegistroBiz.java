/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AdministradorDAO;
import DAO.DoctorDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DAO.TarjetaDAO;
import DTO.DoctorDTO;
import DTO.PacienteDTO;
import DTO.PersonaDTO;
import DTO.TarjetaDTO;
import Entidades.Administrador;
import Entidades.Cita;
import Entidades.Doctor;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Persona;
import Entidades.Tarjeta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class RegistroBiz {

    public String registroPaciente(PacienteDTO pacienteDTO, TarjetaDTO tarjetaDTO) {

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setTarjetaID(tarjetaDTO.getIdTarjeta());
        tarjeta.setNombreEnTarjeta(tarjetaDTO.getNombrePaciente());
        tarjeta.setNumeroAno(tarjetaDTO.getNumeroAno());
        tarjeta.setNumeroMes(tarjetaDTO.getNumeroMes());
        tarjeta.setCsv(tarjetaDTO.getCsv());
        
        Paciente paciente = new Paciente();
        paciente.setNumDocumento(pacienteDTO.getNumDocPaciente());
        paciente.setNombre(pacienteDTO.getNombrePaciente());
        paciente.setContrasena(pacienteDTO.getContrasena());
        paciente.setCorreo(pacienteDTO.getCorreo());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setEps(pacienteDTO.getEps());
        paciente.setNombreContacto(pacienteDTO.getNombreContacto());
        paciente.setTelefonoContacto(pacienteDTO.getTelefonoContacto());
        paciente.setNumHijos(pacienteDTO.getNumHijos());
        paciente.setEstadoCuenta(true);
        paciente.setTarjetatarjetaID(tarjeta);
        List<Cita> citas = new ArrayList<>();
        paciente.setCitaCollection(citas);
              
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        
        tarjetaDAO.createTarjeta(tarjeta);
        pacienteDAO.createPaciente(paciente);

        return "inicioBody.xhtml";
    }
    
    public String registroMedico(PersonaDTO personaDTO) {
       
        Persona persona = new Persona();
        persona.setPersonaID(personaDTO.getIdPersona());
        persona.setNombre(personaDTO.getNombrePersona());
        persona.setContrasena(personaDTO.getContrasena());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setEstadoCuenta(true);
        persona.setRol(1);
                    
        Medico medico = new Medico();
        medico.setMedicoID(personaDTO.getIdPersona());
        medico.setEstado("activo");
        medico.setPersonapersonaID(persona);
        List<Cita> citas = new ArrayList<>();
        medico.setCitaCollection(citas);
        
        PersonaDAO personaDAO = new PersonaDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        
        personaDAO.createPersona(persona);
        medicoDAO.createMedico(medico);       

        return "inicio.xhtml";
    }
    
    public String registroDoctor(PersonaDTO personaDTO, DoctorDTO doctorDTO) {
       
        Persona persona = new Persona();
        persona.setPersonaID(personaDTO.getIdPersona());
        persona.setNombre(personaDTO.getNombrePersona());
        persona.setContrasena(personaDTO.getContrasena());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setEstadoCuenta(true);
        persona.setRol(5);
                    
        Doctor doctor = new Doctor();
        doctor.setDoctorID(personaDTO.getIdPersona());
        doctor.setSalario(doctorDTO.getSalario());
        doctor.setEstado("activo");
        doctor.setEspecialidad(doctorDTO.getEspecialidad());
        doctor.setPersonapersonaID(persona);
        List<Cita> citas = new ArrayList<>();
        doctor.setCitaCollection(citas);
        
        PersonaDAO personaDAO = new PersonaDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        
        personaDAO.createPersona(persona);
        doctorDAO.createDoctor(doctor);

        return "inicio.xhtml";
    }
    
    public String registroAdministrador(PersonaDTO personaDTO) {
       
        Persona persona = new Persona();
        persona.setPersonaID(personaDTO.getIdPersona());
        persona.setNombre(personaDTO.getNombrePersona());
        persona.setContrasena(personaDTO.getContrasena());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setEstadoCuenta(true);
        persona.setRol(3);
        
        Administrador administrador = new Administrador();
        administrador.setAdministradorID(personaDTO.getIdPersona());
        administrador.setPersonapersonaID(persona);
        
        PersonaDAO personaDAO = new PersonaDAO();
        AdministradorDAO administradorDAO = new AdministradorDAO();
        
        personaDAO.createPersona(persona);
        administradorDAO.createAdministrador(administrador);

        return "exito";
    }
}
