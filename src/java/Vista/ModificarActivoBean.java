/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ComprarActivoBiz;
import DTO.ActivoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="modificarActivoBean")
@SessionScoped
public class ModificarActivoBean {
    
    private List<ActivoDTO> listaActivos = new ArrayList<>();
    
    public String init(String tipoModificacion) {
    
        listaActivos = new ArrayList<>();
                
        listaActivos = new ComprarActivoBiz().parseActivoActivoDTO();
        
        if ("Cantidad".equals(tipoModificacion)) {
            return "comprarActivos.xhtml";
        } else {
            return "cambiarPrecioActivos.xhtml";
        }
        
    }

    public List<ActivoDTO> getListaActivos() {
        return listaActivos;
    }

    public void setListaActivos(List<ActivoDTO> listaActivos) {
        this.listaActivos = listaActivos;
    }
    
    public String comprarActivo(){
        
        new ComprarActivoBiz().comprarActivo(listaActivos);
        
        return "gerenteBody.xhtml";
        
    }
    
    public String modificarCosto(){
        
        return "administradorBody.xhtml";
        
    }
    
    
}
