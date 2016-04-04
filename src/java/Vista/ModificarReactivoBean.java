/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ModirficarReactivoBiz;
import DTO.ReactivoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="modificarReactivoBean")
@SessionScoped
public class ModificarReactivoBean {
    
    private List<ReactivoDTO> listaReactivos = new ArrayList<>();
    
    public String init(String tipoModificacion) {
        
        listaReactivos = new ArrayList<>();
                
        listaReactivos = new ModirficarReactivoBiz().parseReactivoReactivoDTO();
        if("Cantidad".equals(tipoModificacion)){
            return "comprarReactivos.xhtml";
        } else {
            return "cambiarPrecioReactivos.xhtml";
        }
        
    }

    public List<ReactivoDTO> getListaReactivos() {
        return listaReactivos;
    }

    public void setListaReactivos(List<ReactivoDTO> listaReactivos) {
        this.listaReactivos = listaReactivos;
    }
    
    public String comprarReactivo(){
        
        new ModirficarReactivoBiz().comprarReactivo(listaReactivos);
        
        return "gerenteBody.xhtml";
        
    }
    
    public String modificarCosto() {
        
        new ModirficarReactivoBiz().modificarCostoReactivo(listaReactivos);

        return "administradorBody.xhtml";

    }
    
    
}
