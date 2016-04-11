/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ReporteImagenDTO;
import Entidades.ImagenDiagnostica;
import Vista.LoginBean;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author jhtob
 */
public class ImagenDiagnosticaDAO {
    
    EntityManagerFactory emf = LoginBean.getEmf();
        
    public ImagenDiagnostica updateImagenDiagnostica(ImagenDiagnostica imagenDiagnostica){
        
        ImagenDiagnostica nuevaImagen = new ImagenDiagnostica();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevaImagen = em.merge(em.find(ImagenDiagnostica.class, imagenDiagnostica.getImagenDiagnosticaID()));
            nuevaImagen.setRutaImagen(imagenDiagnostica.getRutaImagen());
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaImagen;
        }
        
    }
    
    public ReporteImagenDTO searchByFechaAndDescripcion(Date fecha, ReporteImagenDTO reporteImagenDTO) {

        EntityManager em = emf.createEntityManager();
        Query q;

        try {
            q = em.createNamedQuery("ImagenDiagnostica.findByDescripcionAndCount");
            q.setParameter("fecha", fecha);
            q.setParameter("nombreImagen", reporteImagenDTO.getNombreImagen());
            q.setParameter("descripcionImagen", reporteImagenDTO.getDescripcionImagen());
            reporteImagenDTO.setNumImagenes((Long) q.getSingleResult());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return reporteImagenDTO;
        }

    }
}
