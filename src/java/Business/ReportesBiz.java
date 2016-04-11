/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ExamenLaboratorioDAO;
import DAO.GastoDAO;
import DAO.ImagenDiagnosticaDAO;
import DTO.ExamenDTO;
import DTO.ReporteExamenDTO;
import DTO.ReporteImagenDTO;
import Entidades.Gasto;
import Entidades.Laboratorio;
import java.util.ArrayList;
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
    
    public List<ReporteExamenDTO> reporteExamenes(Date fecha){
        
        List<ExamenDTO> nombresExamenes = new SolicitarCitaBiz().cargarExamenesLaboratorio();

        List<ReporteExamenDTO> examenesReporte = new ArrayList<>();
        ReporteExamenDTO reporteExamenDTO;
        
        for(ExamenDTO examenDTO : nombresExamenes){            
                                    
            reporteExamenDTO = new ReporteExamenDTO();
            reporteExamenDTO.setNombreExamen(examenDTO.getNombre());
            reporteExamenDTO.setDescripcionExamen(examenDTO.getDescripcion());
            reporteExamenDTO = new ExamenLaboratorioDAO().searchByFechaAndDescripcion(fecha, 
                    reporteExamenDTO);
            examenesReporte.add(reporteExamenDTO);
            
        }
        
        return examenesReporte;
        
    }
    
    public List<ReporteImagenDTO> reporteImagenes(Date fecha){
        
        List<ExamenDTO> nombresImagenes = new SolicitarCitaBiz().cargarImagenes();

        List<ReporteImagenDTO> imagenesReporte = new ArrayList<>();
        ReporteImagenDTO reporteImagenDTO;
        
        for(ExamenDTO examenDTO : nombresImagenes){            
                                    
            reporteImagenDTO = new ReporteImagenDTO();
            reporteImagenDTO.setNombreImagen(examenDTO.getNombre());
            reporteImagenDTO.setDescripcionImagen(examenDTO.getDescripcion());
            reporteImagenDTO = new ImagenDiagnosticaDAO().searchByFechaAndDescripcion(fecha, 
                    reporteImagenDTO);
            imagenesReporte.add(reporteImagenDTO);
            
        }
        
        return imagenesReporte;
        
    }
    
}
