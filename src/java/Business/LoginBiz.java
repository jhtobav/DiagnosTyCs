/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AdministradorDAO;
import DAO.DoctorDAO;
import DAO.GerenteDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DTO.LoginDTO;
import Entidades.Paciente;
import Entidades.Persona;
import Vista.LoginBean;

/**
 *
 * @author Jaime
 */
public class LoginBiz {

    public LoginDTO login(LoginDTO loginDTO) {

        LoginDTO loginDTORespuesta = new LoginDTO();
        
        PersonaDAO personaDAO = new PersonaDAO();

        Persona persona = personaDAO.searchByIdPersona(loginDTO.getIdPersona());

        LoginBean.setPersona(persona);
        if (persona != null) {
            loginDTORespuesta.setNombrePersona(persona.getNombre());
            if (persona.getContrasena()
                    .equals(loginDTO.getContrasena())) {
                switch (persona.getRol()) {
                    case 1:
                        LoginBean.setMedico(new MedicoDAO().searchByIdMedico(persona.getPersonaID()));
                        loginDTORespuesta.setMensaje("medico.xhtml");
                        return(loginDTORespuesta);
                    case 3:
                        LoginBean.setAdministrador(new AdministradorDAO().searchByIdAdministrador(persona.getPersonaID()));
                        loginDTORespuesta.setMensaje("administrador.xhtml");
                        return(loginDTORespuesta);
                    case 4:
                        LoginBean.setGerente(new GerenteDAO().searchByIdGerente(persona.getPersonaID()));
                        loginDTORespuesta.setMensaje("gerente.xhtml");
                        return(loginDTORespuesta);
                    case 5:
                        LoginBean.setDoctor(new DoctorDAO().searchByIdDoctor(persona.getPersonaID()));
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
                if (paciente.getContrasena().equals(loginDTO.getContrasena())) {
                    LoginBean.setPaciente(paciente);
                    loginDTORespuesta.setMensaje("paciente.xhtml");
                    return(loginDTORespuesta);
                }
            }
        }
        
        loginDTORespuesta.setMensaje("error");
        return loginDTORespuesta;
    }
}
