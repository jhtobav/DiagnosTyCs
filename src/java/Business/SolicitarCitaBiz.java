/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AgendaDAO;
import Entidades.Agenda;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class SolicitarCitaBiz {

   public List<Agenda> cargarAgenda(){
              
       AgendaDAO agendaDAO = new AgendaDAO();
       
       return agendaDAO.getListAgenda();
       
   }
    
}
