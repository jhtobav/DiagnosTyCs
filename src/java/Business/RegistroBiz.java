/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DAO.TarjetaDAO;
import DTO.PersonaDTO;
import DTO.TarjetaDTO;
import Entidades.Paciente;
import Entidades.Persona;
import Entidades.Tarjeta;

/**
 *
 * @author Jaime
 */
public class RegistroBiz {

    public String registroPaciente(PersonaDTO personaDTO, TarjetaDTO tarjetaDTO) {

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setTarjetaID(tarjetaDTO.getIdTarjeta());
        tarjeta.setNombreEnTarjeta(tarjetaDTO.getNombrePersona());
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        
        Persona persona = new Persona();
        persona.setPersonaID(personaDTO.getIdPersona());
        persona.setNombre(personaDTO.getNombrePersona());
        persona.setContrasena(personaDTO.getContrasena());
        persona.setCorreo(personaDTO.getCorreo());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setEdad(personaDTO.getEdad());
        persona.setEstadoCuenta(true);
        persona.setRol(2);
        persona.setTelefono(personaDTO.getTelefono());
                
        Paciente paciente = new Paciente();
        paciente.setPersonaPersonaID(persona);
        paciente.setTarjetaTarjetaID(tarjeta);
              
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        
        tarjetaDAO.createTarjeta(tarjeta);
        System.out.println("exito1");
        personaDAO.createPersona(persona);
        System.out.println("exito2");
        pacienteDAO.createPaciente(paciente);
        System.out.println("exito3");

        return "welcome.xhtml";
    }
}
