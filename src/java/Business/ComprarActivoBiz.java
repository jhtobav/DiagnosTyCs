/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ActivoDAO;
import DAO.GastoDAO;
import DTO.ActivoDTO;
import Entidades.Activo;
import Entidades.Gasto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ComprarActivoBiz {
    
    public List<ActivoDTO> parseActivoActivoDTO(){

        List<ActivoDTO> activosDTO = new ArrayList<>();
        
        for(Activo activo : new ActivoDAO().getListActivo()){
        
            ActivoDTO activoDTO = new ActivoDTO();
            activoDTO.setId(activo.getActivoID());
            activoDTO.setNombre(activo.getNombre());
            activoDTO.setUnidadesExistentes(activo.getUnidadesExistentes());
            activoDTO.setUnidadesNuevas(0l);
            activoDTO.setValor(activo.getValor());
            
            activosDTO.add(activoDTO);
        
        }
        
        return activosDTO;
        
    }
    
    public String comprarActivo(List<ActivoDTO> activosDTO){
        
        ActivoDAO activoDAO = new ActivoDAO();

        GastoDAO gastoDAO = new GastoDAO();
        
        for(ActivoDTO activoDTO : activosDTO){
            
            if (activoDTO.getUnidadesNuevas() > 0){
            
                activoDAO.updateActivoUnidades(activoDTO);
            
                Gasto gasto = new Gasto();
                gasto.setCosto(activoDTO.getValor() * activoDTO.getUnidadesNuevas());
                long cantidad = activoDTO.getUnidadesNuevas();
                gasto.setCantidad((int) cantidad);
                gasto.setDescripcion(activoDTO.getNombre());
                gasto.setFecha(new Date());
                gasto.setTipo("Compra de Activo");
                gasto.setValorUnidad(activoDTO.getValor());
                gastoDAO.createGasto(gasto);
            
            }
            
        }
        
        return "exito";
        
    }
    
}
