package DAO;

import Entidades.Activo;
import Entidades.SolicitudPermiso;
import Vista.LoginBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhtob
 */
public class SolicitudPermisoDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public SolicitudPermiso createSolicitudPermiso(SolicitudPermiso solicitudPermiso) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(solicitudPermiso);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
            return solicitudPermiso;
        }

    }
    
    public SolicitudPermiso updateSolicitudPermisoAprobacion(SolicitudPermiso solicitudPermiso){
        
        SolicitudPermiso nuevaSolicitudPermiso = new SolicitudPermiso();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            nuevaSolicitudPermiso = em.merge(em.find(SolicitudPermiso.class, 
                    solicitudPermiso.getSolicitudPermisoID()));
            nuevaSolicitudPermiso.setAprobacion(solicitudPermiso.getAprobacion());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaSolicitudPermiso;
        }
        
    }
    
    public List<SolicitudPermiso> getListSolicitudPermiso() {

        EntityManager em = emf.createEntityManager();
        Query q;

        List<SolicitudPermiso> solicitudes = null;

        try {
            q = em.createNamedQuery("SolicitudPermiso.findAll", Activo.class);
            solicitudes = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return solicitudes;
        }

    }
    
}
