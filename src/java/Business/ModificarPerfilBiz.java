/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PacienteDAO;
import DAO.TarjetaDAO;
import DTO.PacienteDTO;
import DTO.TarjetaDTO;
import Entidades.Paciente;
import Entidades.Tarjeta;

/**
 *
 * @author jhtob
 */
public class ModificarPerfilBiz {
    
    public Paciente cargarPaciente(Long pacienteID){
        
        return new PacienteDAO().searchByIdPaciente(pacienteID);
        
    }
    
    public String modificarPaciente(PacienteDTO pacienteDTO, TarjetaDTO tarjetaDTO){

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
        
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setTarjetaID(tarjetaDTO.getIdTarjeta());
        tarjeta.setNombreEnTarjeta(tarjetaDTO.getNombrePaciente());
        tarjeta.setNumeroAno(tarjetaDTO.getNumeroAno());
        tarjeta.setNumeroMes(tarjetaDTO.getNumeroMes());
        tarjeta.setCsv(tarjetaDTO.getCsv());

        new PacienteDAO().updatePacientePerfil(paciente);
        new TarjetaDAO().updateTarjeta(tarjeta);

        return "exito";
        
    }
    
}
