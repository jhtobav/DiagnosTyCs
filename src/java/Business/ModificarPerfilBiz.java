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

/**
 *
 * @author jhtob
 */
public class ModificarPerfilBiz {
    
    public Paciente cargarPaciente(Long pacienteID){
        
        return new PacienteDAO().searchByIdPaciente(pacienteID);
        
    }
    
    public String modificarPaciente(PacienteDTO pacienteDTO, TarjetaDTO tarjetaDTO){
        
        new PacienteDAO().updatePacientePerfil(pacienteDTO);
        new TarjetaDAO().updateTarjeta(tarjetaDTO);

        return "exito";
        
    }
    
}
