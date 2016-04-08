/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.GastoDAO;
import Entidades.Gasto;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ReportesBiz {
    
    public List<Gasto> reporteCostos(String tipoCosto){
        
        return new GastoDAO().getListGastoByTipo(tipoCosto);
        
    }
    
}
