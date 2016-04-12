/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.DoctorDAO;
import DAO.SolicitudPermisoDAO;
import DTO.SolicitudPermisoDTO;
import Entidades.SolicitudPermiso;
import Vista.LoginBean;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class SolicitarPermisoBiz {
    
    public List<SolicitudPermiso> listarPermisos(){
        
        return new SolicitudPermisoDAO().getListSolicitudPermiso();
        
    }
    
    public String solicitarPermiso(SolicitudPermisoDTO solicitudPermisoDTO){
        
        SolicitudPermiso solicitudPermiso = new SolicitudPermiso();
        
        solicitudPermiso.setDoctorID(LoginBean.idPersonaLogueada);
        solicitudPermiso.setFechaInicio(solicitudPermisoDTO.getFechaInicio());
        solicitudPermiso.setFechaFin(solicitudPermisoDTO.getFechaFin());
        solicitudPermiso.setJustificacion(solicitudPermisoDTO.getJustificacion());
        solicitudPermiso.setAprobacion("Pendiente");
        solicitudPermiso.setNombreDoctor(new DoctorDAO()
                .searchByIdDoctor(LoginBean.idPersonaLogueada).getPersonapersonaID().getNombre());
        
        new SolicitudPermisoDAO().createSolicitudPermiso(solicitudPermiso);
        
        return "exito";
        
    }
    
    public String aprobarPermiso(List<SolicitudPermiso> solicitudes){
        
        for(SolicitudPermiso solicitudPermiso : solicitudes){
            
            new SolicitudPermisoDAO().updateSolicitudPermisoAprobacion(solicitudPermiso);
            
        }
        
        return "exito";
    }
    
}
