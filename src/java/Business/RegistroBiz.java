/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DAO.TarjetaDAO;
import DTO.MedicoDTO;
import DTO.PacienteDTO;
import DTO.PersonaDTO;
import DTO.TarjetaDTO;
import Entidades.Cita;
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
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        
        Paciente paciente = new Paciente();
        paciente.setNumDocumento(pacienteDTO.getNumDocPaciente());
        paciente.setNombre(pacienteDTO.getNombrePaciente());
        paciente.setContrasena(pacienteDTO.getContrasena());
        paciente.setCorreo(pacienteDTO.getCorreo());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEdad(pacienteDTO.getEdad());
        paciente.setEstadoCuenta(true);
        paciente.setRol(2);
        paciente.setTarjetatarjetaID(tarjeta);
        List<Cita> citas = new ArrayList<>();
        paciente.setCitaCollection(citas);
              
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        
        tarjetaDAO.createTarjeta(tarjeta);
        pacienteDAO.createPaciente(paciente);

        return "inicio.xhtml";
    }
    
    public String registroMedico(PersonaDTO personaDTO, MedicoDTO medicoDTO) {
       
        Persona persona = new Persona();
        persona.setPersonaID(personaDTO.getIdPersona());
        persona.setNombre(personaDTO.getNombrePersona());
        persona.setContrasena(personaDTO.getContrasena());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEdad(personaDTO.getEdad());
        persona.setEstadoCuenta(true);
        persona.setRol(1);
                    
        Medico medico = new Medico();
        medico.setMedicoID(personaDTO.getIdPersona());
        medico.setEspecialidad(medicoDTO.getEspecialidad());
        medico.setSalario(medicoDTO.getSalario());
        medico.setEstado("activo");
        List<Cita> citas = new ArrayList<>();
        medico.setCitaCollection(citas);
        medico.setPersonapersonaID(persona);
        
        PersonaDAO personaDAO = new PersonaDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        
        personaDAO.createPersona(persona);
        medicoDAO.createMedico(medico);       

        return "inicio.xhtml";
    }
}
