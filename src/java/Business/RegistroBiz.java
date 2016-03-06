/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PacienteDAO;
import DAO.TarjetaDAO;
import DTO.PacienteDTO;
import DTO.TarjetaDTO;
import Entidades.Cita;
import Entidades.Paciente;
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
}
