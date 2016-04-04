package DAO;


import DTO.ActivoDTO;
import Entidades.Activo;
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
public class ActivoDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Activo updateActivoUnidades(ActivoDTO activoDTO){
        
        Activo nuevoActivo = new Activo();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoActivo = em.merge(em.find(Activo.class, activoDTO.getId()));
            nuevoActivo.setUnidadesExistentes(nuevoActivo.getUnidadesExistentes() 
                    + activoDTO.getUnidadesNuevas());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoActivo;
        }
        
    }
    
    public Activo updateActivoCosto(ActivoDTO activoDTO){
        
        Activo nuevoActivo = new Activo();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoActivo = em.merge(em.find(Activo.class, activoDTO.getId()));
            nuevoActivo.setValor(activoDTO.getValor());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoActivo;
        }
        
    }
    
    public List<Activo> getListActivo() {

        EntityManager em = emf.createEntityManager();
        Query q;

        List<Activo> activos = null;

        try {
            q = em.createNamedQuery("Activo.findAll", Activo.class);
            activos = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return activos;
        }

    }
    
}
