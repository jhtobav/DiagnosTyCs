/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DTO.LoginDTO;
import Entidades.Paciente;
import Entidades.Persona;

/**
 *
 * @author Jaime
 */
public class LoginBiz {

    public LoginDTO login(LoginDTO loginDTO) {
        
        LoginDTO loginDTORespuesta = new LoginDTO();
        
        PersonaDAO personaDAO = new PersonaDAO();

        Persona persona = personaDAO.searchByIdPersona(loginDTO.getIdPersona());

        if (persona != null) {
            loginDTORespuesta.setNombrePersona(persona.getNombre());
            loginDTORespuesta.setIdPersona(persona.getPersonaID());
            if (persona.getContrasena()
                    .equals(loginDTO.getContrasena())) {
                switch (persona.getRol()) {
                    case 1:
                        loginDTORespuesta.setMensaje("medico.xhtml");
                        return(loginDTORespuesta);
                    case 3:
                        loginDTORespuesta.setMensaje("administrador.xhtml");
                        return(loginDTORespuesta);
                    case 4:
                        loginDTORespuesta.setMensaje("gerente.xhtml");
                        return(loginDTORespuesta);
                    case 5:
                        loginDTORespuesta.setMensaje("doctor.xhtml");                        
                        return(loginDTORespuesta);
                    default:
                        break;
                }
            }
        }else{
            PacienteDAO pacienteDAO = new PacienteDAO();
            Paciente paciente = pacienteDAO.searchByNumDocumento(loginDTO.getIdPersona());
            if(paciente != null){
                loginDTORespuesta.setNombrePersona(paciente.getNombre());
                loginDTORespuesta.setIdPersona(paciente.getPacienteID());
                if (paciente.getContrasena().equals(loginDTO.getContrasena())) {
                    loginDTORespuesta.setMensaje("paciente.xhtml");
                    return(loginDTORespuesta);
                }
            }
        }
        
        loginDTORespuesta.setMensaje("error");
        return loginDTORespuesta;
    }
}
