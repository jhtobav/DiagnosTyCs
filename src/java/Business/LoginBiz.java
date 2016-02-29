/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AdministradorDAO;
import DAO.GerenteDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.PersonaDAO;
import DTO.PersonaLoginDTO;
import Entidades.Persona;
import Vista.LoginBean;

/**
 *
 * @author Jaime
 */
public class LoginBiz {

    public String login(PersonaLoginDTO personaLoginDTO) {

        PersonaDAO personaDAO = new PersonaDAO();

        Persona persona = personaDAO.searchByIdPersona(personaLoginDTO.getIdPersona());

        LoginBean.setPersona(persona);

        if (persona != null) {
            if (persona.getContrasena()
                    .equals(personaLoginDTO.getContrasena())) {
                switch (persona.getRol()) {
                    case 1:
                        LoginBean.setMedico(new MedicoDAO().searchByIdMedico(persona.getPersonaID()));
                        return "medico.xhtml";
                    case 2:
                        LoginBean.setPaciente(new PacienteDAO().searchByPersona(persona));
                        return "paciente.xhtml";
                    case 3:
                        LoginBean.setAdministrador(new AdministradorDAO().searchByIdAdministrador(persona.getPersonaID()));
                        return "administrador.xhtml";
                    case 4:
                        LoginBean.setGerente(new GerenteDAO().searchByIdGerente(persona.getPersonaID()));
                        return "gerente.xhtml";
                    default:
                        break;
                }
            }
        }

        return "error";
    }
}
