/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.SolicitarPermisoBiz;
import DTO.SolicitudPermisoDTO;
import Entidades.SolicitudPermiso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="solicitarPermisoBean")
@SessionScoped
public class SolicitarPermisoBean {

    public String fechaInicio;
    public String fechaFin;
    public String justificacion;
    
    public List<SolicitudPermiso> listaSolicitudes;
    
    public String init(String tipoPagina) {
       
        switch (tipoPagina) {
            case "permisoDoctorSolicitar":
                
                fechaInicio = null;
                fechaFin = null;
                justificacion = null;
                return "permisoDoctorSolicitar.xhtml";
                
            case "permisoDoctorAprobar":
                
                listaSolicitudes = new SolicitarPermisoBiz().listarPermisos();
                return "permisoDoctorAprobar.xhtml";
                
            case "permisoDoctorListar":
                
                listaSolicitudes = new SolicitarPermisoBiz().listarPermisos();
                return "permisoDoctorListar.xhtml";
            default:
                break;
        }
        
        return "inicio.xhtml";
        
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public List<SolicitudPermiso> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudPermiso> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
    
    Date parsearFecha(String fecha){
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }

    public String solicitarPermiso(){

        SolicitudPermisoDTO solicitudPermisoDTO = new SolicitudPermisoDTO();
        
        solicitudPermisoDTO.setFechaInicio(parsearFecha(fechaInicio));
        solicitudPermisoDTO.setFechaFin(parsearFecha(fechaFin));
        solicitudPermisoDTO.setJustificacion(justificacion);
        
        new SolicitarPermisoBiz().solicitarPermiso(solicitudPermisoDTO);
        
        return "doctorBody.xhtml";
        
    }
    
    public String aprobarPermiso(){
        
        new SolicitarPermisoBiz().aprobarPermiso(listaSolicitudes);
        
        return "doctorBody.xhtml";
        
    }
}
