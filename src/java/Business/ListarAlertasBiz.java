/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AlertaDAO;
import Entidades.Alerta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ListarAlertasBiz {
    
    public List<Alerta> listarAlertas(Date fecha){
     
        List<Alerta> alertas = new AlertaDAO().getListLastAlerta(fecha);
        
        return alertas;
    }
    
}
