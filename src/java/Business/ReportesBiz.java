/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.GastoDAO;
import Entidades.Gasto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ReportesBiz {
    
    public List<Gasto> reporteCostos(String tipoCosto, Date fecha){
        
        if(tipoCosto.equals("Todos")){
            
            return new GastoDAO().getListGastoByFecha(fecha);
            
        } else {

            return new GastoDAO().getListGastoByTipoAndFecha(tipoCosto, fecha);
            
        }
        
    }
    
}
