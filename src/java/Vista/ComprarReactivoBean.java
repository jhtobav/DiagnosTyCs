/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.ComprarReactivoBiz;
import DTO.ReactivoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="comprarReactivoBean")
@SessionScoped
public class ComprarReactivoBean {
    
    private List<ReactivoDTO> listaReactivos = new ArrayList<>();
    
    public String init() {
    
        listaReactivos = new ArrayList<>();
                
        listaReactivos = new ComprarReactivoBiz().parseReactivoReactivoDTO();
        
        return "actualizarReactivos.xhtml";
        
    }

    public List<ReactivoDTO> getListaReactivos() {
        return listaReactivos;
    }

    public void setListaReactivos(List<ReactivoDTO> listaReactivos) {
        this.listaReactivos = listaReactivos;
    }
    
    public String comprarReactivo(){
        
        new ComprarReactivoBiz().comprarReactivo(listaReactivos);
        
        return "administradorBody.xhtml";
        
    }
    
    
}
