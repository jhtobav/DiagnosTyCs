/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.ImagenDiagnostica;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaImagen;
        }
        
    }
}
