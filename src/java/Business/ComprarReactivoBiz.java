/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.GastoDAO;
import DAO.ReactivoDAO;
import DTO.ReactivoDTO;
import Entidades.Gasto;
import Entidades.Reactivo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ComprarReactivoBiz {
    
    public List<ReactivoDTO> parseReactivoReactivoDTO(){

        List<ReactivoDTO> reactivosDTO = new ArrayList<>();
        
        for(Reactivo reactivo : new ReactivoDAO().getListReactivo()){
        
            ReactivoDTO reactivoDTO = new ReactivoDTO();
            reactivoDTO.setId(reactivo.getReactivoID());
            reactivoDTO.setNombre(reactivo.getNombre());
            reactivoDTO.setUnidadesExistentes(reactivo.getUnidadesExistentes());
            reactivoDTO.setUnidadesNuevas(0l);
            reactivoDTO.setValor(reactivo.getValor());
            
            reactivosDTO.add(reactivoDTO);
        
        }
        
        return reactivosDTO;
        
    }
    
    public String comprarReactivo(List<ReactivoDTO> reactivosDTO){
        
        ReactivoDAO reactivoDAO = new ReactivoDAO();

        GastoDAO gastoDAO = new GastoDAO();
        
        for(ReactivoDTO reactivoDTO : reactivosDTO){
            
            if (reactivoDTO.getUnidadesNuevas() > 0){
            
                reactivoDAO.updateReactivoUnidades(reactivoDTO);
            
                Gasto gasto = new Gasto();
                gasto.setCosto(reactivoDTO.getValor() * reactivoDTO.getUnidadesNuevas());
                long cantidad = reactivoDTO.getUnidadesNuevas();
                gasto.setCantidad((int) cantidad);
                gasto.setDescripcion(reactivoDTO.getNombre());
                gasto.setFecha(new Date());
                gasto.setTipo("Compra de Reactivo");
                gasto.setValorUnidad(reactivoDTO.getValor());
                gastoDAO.createGasto(gasto);
            
            }
            
        }
        
        return "exito";
        
    }
    
}
